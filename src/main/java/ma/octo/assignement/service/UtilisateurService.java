package ma.octo.assignement.service;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.repository.UtilisateurRepository;
import ma.octo.assignement.serviceInterfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements IUtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public List<Utilisateur> loadAll() {
        return utilisateurRepository.findAll();
    }


    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }


	@Override
	public Utilisateur getUtilisateur(Long id) {
		// TODO Auto-generated method stub
		return utilisateurRepository.getById(id);
		
	}
}
