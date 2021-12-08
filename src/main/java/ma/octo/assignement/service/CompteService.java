package ma.octo.assignement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ma.octo.assignement.repository.CompteRepository;
import ma.octo.assignement.serviceInterfaces.ICompteService;

import ma.octo.assignement.domain.Compte;

@Service
public class CompteService implements ICompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public List<Compte> loadAll() {
        List<Compte> comptes = compteRepository.findAll();

        if (CollectionUtils.isEmpty(comptes)) {
            return null;
        } else {
            return comptes;
        }
    }

    @Override
    public void saveCompte(Compte compte) {
        compteRepository.save(compte);
    }

    @Override
    public Compte getCompte(Long id) {
        return compteRepository.getById(id);
    }

    @Override
    public Compte findByNrCompte(String numeroCompte) {
        return compteRepository.findByNrCompte(numeroCompte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

	@Override
	public Compte findByRib(String rib) {
		// TODO Auto-generated method stub
		return compteRepository.findByRib(rib);
	}
}
