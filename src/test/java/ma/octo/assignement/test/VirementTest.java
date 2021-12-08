package ma.octo.assignement.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.domain.util.Gender;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.mapper.VirementMapper;
import ma.octo.assignement.service.VirementService;

@SpringBootTest
public class VirementTest {
	
	    @Autowired
	    private VirementMapper mapper;

	   
	    @Mock
	    private static VirementDto virementDto;
	    @Mock
	    private static Virement virement;
	    
	   
	    @BeforeEach
	    public void init() {
	        virementDto = new VirementDto();
	        virement = new Virement();
	        Utilisateur utilisateur1 = new Utilisateur(356L,"Alaoui Chaimaa",Gender.F, "Alaoui", "Chaimaa",null);
	        Utilisateur utilisateur2 = new Utilisateur(789L,"Mekaoui Salma",Gender.F, "Mekaoui", "Salma", null);
	        final Compte CompteEmetteur = new Compte(100L, "2314567894678976", "123456010000B02500199912" ,new BigDecimal(100000), utilisateur1);
	        final Compte CompteBeneficiaire = new Compte(101L, "1256743289761234", "123456010000B02511239912" ,new BigDecimal(150000), utilisateur2);
	        final BigDecimal montantVirement = new BigDecimal(2000);
	        final String motifVirement = "crédit";
	        final Date dateVirement = new Date();

	        virementDto.setCompteEmetteur(CompteEmetteur);
	        virementDto.setCompteBeneficiaire(CompteBeneficiaire);
	        virementDto.setMontantVirement(montantVirement);
	        virementDto.setMotifVirement(motifVirement);
	        virementDto.setDateVirement(dateVirement);

	        virement.setCompteEmetteur(CompteEmetteur);
	        virement.setCompteBeneficiaire(CompteBeneficiaire);
	        virement.setMontantVirement(montantVirement);
	        virement.setMotifVirement(motifVirement);
	        virement.setDateExecution(dateVirement);
	    }
	 
	    @Test
	    void mapVirementDtoToVirement(){

	 

	            Virement result = mapper.map(virementDto);

	            Assertions.assertEquals(result.getCompteEmetteur().getNrCompte(), virementDto.getCompteEmetteur().getNrCompte());
	            Assertions.assertEquals(result.getCompteBeneficiaire().getNrCompte(), virementDto.getCompteBeneficiaire().getNrCompte());
	            Assertions.assertEquals(result.getMontantVirement(), virementDto.getMontantVirement());
	            Assertions.assertEquals(result.getMotifVirement(), virementDto.getMotifVirement());
	            Assertions.assertEquals(result.getDateExecution(), virementDto.getDateVirement());
	       
	    }
	    @Test
	    void mapVirementToVirementDto(){


	        

	            VirementDto result = mapper.map(virement);

	            Assertions.assertEquals(result.getCompteEmetteur().getNrCompte(), virement.getCompteEmetteur().getNrCompte());
	            Assertions.assertEquals(result.getCompteBeneficiaire().getNrCompte(), virement.getCompteBeneficiaire().getNrCompte());
	            Assertions.assertEquals(result.getMontantVirement(), virement.getMontantVirement());
	            Assertions.assertEquals(result.getMotifVirement(), virement.getMotifVirement());
	            Assertions.assertEquals(result.getDateVirement(), virement.getDateExecution());
	       
	    }
	   

	    
	    }




