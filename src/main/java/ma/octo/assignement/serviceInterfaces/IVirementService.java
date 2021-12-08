package ma.octo.assignement.serviceInterfaces;
import java.util.List;

import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;

public interface IVirementService {
	List<VirementDto> loadAll();
    void saveVirement(Virement virement);
    void saveVirementDto(VirementDto virementDto) throws CompteNonExistantException, TransactionException;

}
