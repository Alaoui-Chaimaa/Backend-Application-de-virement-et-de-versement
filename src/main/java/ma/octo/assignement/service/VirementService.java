package ma.octo.assignement.service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.mapper.VirementMapper;
import ma.octo.assignement.repository.VirementRepository;
import ma.octo.assignement.serviceInterfaces.ICompteService;
import ma.octo.assignement.serviceInterfaces.IVirementService;
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
public class VirementService implements IVirementService {

    public static final BigDecimal MONTANT_MAXIMAL = new BigDecimal(10000);
    public static final BigDecimal zero = new BigDecimal(0);
    public static final BigDecimal dix = new BigDecimal(10);
    Logger LOGGER = LoggerFactory.getLogger(VirementService.class);


    @Autowired
    private VirementRepository virementRepository;
    @Autowired
    private ICompteService compteService;
    @Autowired
    private AutiService autiService;

    @Override
    public List<VirementDto> loadAll() {
        List<VirementDto> virementDtoList = new ArrayList<>();
        List<Virement> virements = virementRepository.findAll();
        if (!CollectionUtils.isEmpty(virements)) {
            for (int i = 0; i < virements.size(); i++){
                virementDtoList.add(VirementMapper.map(virements.get(i)));
            }
        }
        return virementDtoList;
    }

    public void saveVirementDto(VirementDto virementDto) throws CompteNonExistantException, TransactionException {
        Compte compteEmetteur = compteService.findByNrCompte(virementDto.getCompteEmetteur().getNrCompte());
        Compte compteBeneficiaire = compteService.findByNrCompte(virementDto.getCompteBeneficiaire().getNrCompte());
        virementDto.setDateVirement(new Date());
        if (compteEmetteur == null) {
            System.out.println("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }

        if (compteBeneficiaire == null) {
            System.out.println("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }

        if (virementDto.getMontantVirement() == zero) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (virementDto.getMontantVirement() == zero) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (virementDto.getMontantVirement().compareTo(dix)<0) {
            System.out.println("Montant minimal de virement non atteint");
            throw new TransactionException("Montant minimal de virement non atteint");
        } else if (virementDto.getMontantVirement().compareTo(MONTANT_MAXIMAL)>0) {
            System.out.println("Montant maximal de virement dépassé");
            throw new TransactionException("Montant maximal de virement dépassé");
        }

        if (virementDto.getMotifVirement().length() < 0) {
            System.out.println("Motif vide");
            throw new TransactionException("Motif vide");
        }

        if (compteEmetteur.getSolde().subtract(virementDto.getMontantVirement()).compareTo(zero)<0){
            LOGGER.error("Solde insuffisant pour l'utilisateur");
        }




        Virement virement = new Virement();
        virement.setDateExecution(virementDto.getDateVirement());
        virement.setCompteBeneficiaire(compteBeneficiaire);
        virement.setCompteEmetteur(compteEmetteur);
        virement.setMotifVirement(virementDto.getMotifVirement());
        virement.setMontantVirement(virementDto.getMontantVirement());


        compteEmetteur.setSolde(compteEmetteur.getSolde().subtract(virementDto.getMontantVirement()));
        compteService.saveCompte(compteEmetteur);

        compteBeneficiaire
                .setSolde(compteBeneficiaire.getSolde().add(virementDto.getMontantVirement()));
        compteService.saveCompte(compteBeneficiaire);

        virementRepository.save(virement);


        autiService.auditVirement("Virement depuis " + virementDto.getCompteEmetteur().getNrCompte() + " vers " + virementDto
                .getCompteBeneficiaire().getNrCompte() + " d'un montant de " + virementDto.getMontantVirement());

    }

	@Override
	public void saveVirement(Virement virement) {
		// TODO Auto-generated method stub
		
	}

}
