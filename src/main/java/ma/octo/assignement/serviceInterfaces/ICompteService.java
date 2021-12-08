package ma.octo.assignement.serviceInterfaces;

import java.util.List;

import ma.octo.assignement.domain.Compte;

public interface ICompteService {
	    List<Compte> loadAll();
	    void saveCompte(Compte compte);
	    Compte getCompte(Long id);
	    Compte findByNrCompte(String numeroCompte);
	    Compte findByRib(String rib);
	    void deleteCompte(Long id);

}
