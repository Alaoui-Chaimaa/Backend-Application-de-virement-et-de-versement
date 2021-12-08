package ma.octo.assignement.web;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.serviceInterfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController {

    @Autowired
    private IUtilisateurService utilisateurService;

    @GetMapping("utilisateurs")
    List<Utilisateur> loadAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.loadAll();

        if (CollectionUtils.isEmpty(utilisateurs)) {
            return null;
        } else {
            return utilisateurs;
        }
    }


}
