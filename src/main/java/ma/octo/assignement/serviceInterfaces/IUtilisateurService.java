package ma.octo.assignement.serviceInterfaces;
import java.util.List;

import ma.octo.assignement.domain.Utilisateur;

public interface IUtilisateurService {
	List<Utilisateur> loadAll();
    void saveUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateur(Long id);

}
