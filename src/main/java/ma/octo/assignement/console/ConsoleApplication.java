package ma.octo.assignement.console;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.domain.util.Gender;
import ma.octo.assignement.serviceInterfaces.ICompteService;
import ma.octo.assignement.serviceInterfaces.IUtilisateurService;
import ma.octo.assignement.serviceInterfaces.IVirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private ICompteService compteService;
    @Autowired
    private IUtilisateurService utilisateurService;
    @Autowired
    private IVirementService virementService;

    @Override
    public void run(String... args) {
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setUsername("user1");
        utilisateur1.setLastname("last1");
        utilisateur1.setFirstname("first1");
        utilisateur1.setGender(Gender.M);

        utilisateurService.saveUtilisateur(utilisateur1);


        Utilisateur utilisateur2 = new Utilisateur();
        utilisateur2.setUsername("user2");
        utilisateur2.setLastname("last2");
        utilisateur2.setFirstname("first2");
        utilisateur2.setGender(Gender.F);

        utilisateurService.saveUtilisateur(utilisateur2);

        Compte compte1 = new Compte();
        compte1.setNrCompte("010000A000001000");
        compte1.setRib("RIB1");
        compte1.setSolde(BigDecimal.valueOf(200000L));
        compte1.setUtilisateur(utilisateur1);

        compteService.saveCompte(compte1);

        Compte compte2 = new Compte();
        compte2.setNrCompte("010000B025001000");
        compte2.setRib("RIB2");
        compte2.setSolde(BigDecimal.valueOf(140000L));
        compte2.setUtilisateur(utilisateur2);

        compteService.saveCompte(compte2);

        Virement virement = new Virement();
        virement.setMontantVirement(BigDecimal.TEN);
        virement.setCompteBeneficiaire(compte2);
        virement.setCompteEmetteur(compte1);
        virement.setDateExecution(new Date());
        virement.setMotifVirement("Assignment 2021");

        virementService.saveVirement(virement);
    }
}