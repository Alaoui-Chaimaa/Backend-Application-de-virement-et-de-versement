package ma.octo.assignement.mapper;

import org.springframework.stereotype.Component;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;

@Component
public class VersementMapper {
	 public static VersementDto map(Versement versement) {
	        VersementDto versementDto = new VersementDto();

	        versementDto.setDateVersement(versement.getDateExecution());
	        versementDto.setCompteBeneficiaire(versement.getCompteBeneficiaire());
	        versementDto.setMontant(versement.getMontantVirement());
	        versementDto.setCinEmetteur(versement.getCinEmetteur());
	        return versementDto;
	    }

	    public static Versement map(VersementDto versementDto) {
	        Versement versement = new Versement();

	        versement.setDateExecution(versementDto.getDateVersement());
	        versement.setCompteBeneficiaire(versementDto.getCompteBeneficiaire());
	        versement.setMontantVirement(versementDto.getMontant());
	        versement.setCinEmetteur(versementDto.getCinEmetteur());
	        return versement;
	    }


}
