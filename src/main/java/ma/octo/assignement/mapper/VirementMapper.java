package ma.octo.assignement.mapper;

import org.springframework.stereotype.Component;

import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;

@Component
public class VirementMapper {

	public static VirementDto map(Virement virement) {
        VirementDto virementDto = new VirementDto();

        virementDto.setCompteEmetteur(virement.getCompteEmetteur());
        virementDto.setCompteBeneficiaire(virement.getCompteBeneficiaire());
        virementDto.setDateVirement(virement.getDateExecution());
        virementDto.setMotifVirement(virement.getMotifVirement());
        virementDto.setMontantVirement(virement.getMontantVirement());

        return virementDto;
    }

    public  Virement map(VirementDto virementDto) {

        Virement virement = new Virement();
        virement.setCompteEmetteur(virementDto.getCompteEmetteur());
        virement.setCompteBeneficiaire(virementDto.getCompteBeneficiaire());
        virement.setDateExecution(virementDto.getDateVirement());
        virement.setMotifVirement(virementDto.getMotifVirement());
        virement.setMontantVirement(virementDto.getMontantVirement());

        return virement;
    }
}