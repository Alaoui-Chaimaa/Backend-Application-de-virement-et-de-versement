package ma.octo.assignement.web;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.serviceInterfaces.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"comptes/"})
public class CompteController {

    @Autowired
    private ICompteService compteService;

    @GetMapping(value = {""}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    List<Compte> loadAllCompte() {
        return compteService.loadAll();
    }


    @GetMapping(value = {"{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    Compte getCompte(@PathVariable("id") Long id) {
        System.out.println(id);
        return compteService.getCompte(id);
    }


    @PostMapping(value = {""}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void saveCompte(@RequestBody Compte compte){
         compteService.saveCompte(compte);
    }


    @PutMapping(value = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateCompte(@RequestBody Compte compte,@PathVariable Long id){
        compte.setId(id);
        compteService.saveCompte(compte);
    }


    @DeleteMapping(value = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteCompte(@PathVariable Long id){
        compteService.deleteCompte(id);
    }
}
