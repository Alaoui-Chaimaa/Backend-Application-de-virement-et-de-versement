package ma.octo.assignement.web;

import ma.octo.assignement.dto.VersementDto;

import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.exceptions.TransactionException;

import ma.octo.assignement.serviceInterfaces.IVersementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"versements"})
public class VersementController {

    @Autowired
    private IVersementService versementService;

    @GetMapping("")
    List<VersementDto> loadAll() {
        return versementService.loadAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody VersementDto versementDto)
            throws SoldeDisponibleInsuffisantException, CompteNonExistantException, TransactionException {

        versementService.saveVersementDto(versementDto);
    }

}

