package ma.octo.assignement.service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.mapper.VersementMapper;
import ma.octo.assignement.mapper.VirementMapper;
import ma.octo.assignement.repository.VersementRepository;
import ma.octo.assignement.repository.VirementRepository;
import ma.octo.assignement.service.AutiService;
import ma.octo.assignement.serviceInterfaces.ICompteService;
import ma.octo.assignement.serviceInterfaces.IVersementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VersementService implements IVersementService {

	public static final BigDecimal MONTANT_MAXIMAL = new BigDecimal(10000);
	public static final BigDecimal zero = new BigDecimal(0);
	public static final BigDecimal dix = new BigDecimal(10);
    Logger LOGGER = LoggerFactory.getLogger(VirementService.class);


    @Autowired
    private VersementRepository versementRepository;
    @Autowired
    private ICompteService compteService;
    @Autowired
    private AutiService autiService;


    @Override
    public List<VersementDto> loadAll() {
        List<VersementDto> versementDtoList = new ArrayList<>();
        List<Versement> versements = versementRepository.findAll();
        if (!CollectionUtils.isEmpty(versements)) {
            for (int i = 0; i < versements.size(); i++){
                versementDtoList.add(VersementMapper.map(versements.get(i)));
            }
        }
        return versementDtoList;
    }

    @Override
    public void saveVersement(Versement versement) {
        versementRepository.save(versement);
    }

    @Override
    public void saveVersementDto(VersementDto versementDto) throws CompteNonExistantException, TransactionException {
        Compte compteBeneficiaire = compteService.findByRib(versementDto.getCompteBeneficiaire().getRib());
        versementDto.setDateVersement(new Date());
        if (compteBeneficiaire == null) {
            System.out.println("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }

        if (versementDto.getMontant()== zero) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (versementDto.getMontant() == zero) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (versementDto.getMontant().compareTo(dix)<0) {
            System.out.println("Montant minimal de Versement non atteint");
            throw new TransactionException("Montant minimal de Versement non atteint");
        } else if (versementDto.getMontant().compareTo(MONTANT_MAXIMAL)>0) {
            System.out.println("Montant maximal de Versement dépassé");
            throw new TransactionException("Montant maximal de Versement dépassé");
        }

        compteBeneficiaire
                .setSolde(compteBeneficiaire.getSolde().add(versementDto.getMontant()));
        compteService.saveCompte(compteBeneficiaire);

        Versement versement = new Versement();
        versement.setDateExecution(versementDto.getDateVersement());
        versement.setCompteBeneficiaire(compteBeneficiaire);
        versement.setMontantVirement(versementDto.getMontant());

        versementRepository.save(versement);


        autiService.auditVersement("Versement d'un montant de " + versementDto.getMontant()+ " vers " + versementDto
                .getCompteBeneficiaire().getRib());
    }
}
