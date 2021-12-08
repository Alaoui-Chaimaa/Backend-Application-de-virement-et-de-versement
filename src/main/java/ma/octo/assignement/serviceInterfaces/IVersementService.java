package ma.octo.assignement.serviceInterfaces;

import java.util.List;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;

public interface IVersementService {
	List<VersementDto> loadAll();
    void saveVersement(Versement versement);
    void saveVersementDto(VersementDto versementDto) throws CompteNonExistantException, TransactionException;

}
