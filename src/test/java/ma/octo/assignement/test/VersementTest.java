package ma.octo.assignement.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.domain.util.Gender;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.mapper.VersementMapper;


public class VersementTest {

	   private VersementMapper mapper;

	    @Mock
	    private static VersementDto versementDto;
	    @Mock
	    private static Versement versement;
	    
	    
	    @BeforeEach
	    public void init() {
	        versementDto = new VersementDto();
	        versement = new Versement();
	        Utilisateur utilisateur = new Utilisateur(356L,"Alaoui Chaimaa",Gender.F, "Alaoui", "Chaimaa",null);

	        final Compte CompteBeneficiaire = new Compte(101L, "1256743289761234", "123456010000B02511239912" ,new BigDecimal(150000), utilisateur);
	        final BigDecimal montantVersement = new BigDecimal(2000);
	        final Date dateVersement = new Date();

	        versementDto.setCompteBeneficiaire(CompteBeneficiaire);
	        versementDto.setMontant(montantVersement);
	        versementDto.setDateVersement(dateVersement);


	        versement.setCompteBeneficiaire(CompteBeneficiaire);
	        versement.setMontantVirement(montantVersement);
	        versement.setDateExecution(dateVersement);
	    }


	    @Test
	    void mapVersementDtoToVersement(){

	   
	            Versement result = mapper.map(versementDto);


	            Assertions.assertEquals(result.getCompteBeneficiaire().getRib(), versementDto.getCompteBeneficiaire().getRib());
	            Assertions.assertEquals(result.getMontantVirement(), versementDto.getMontant());
	            Assertions.assertEquals(result.getDateExecution(), versementDto.getDateVersement());
	      
	    }

	

	    @Test
	    void mapVersementToVersementDtoTest(){

	      

	            VersementDto result = mapper.map(versement);


	            Assertions.assertEquals(result.getCompteBeneficiaire().getRib(), versement.getCompteBeneficiaire().getRib());
	            Assertions.assertEquals(result.getMontant(), versement.getMontantVirement());
	            Assertions.assertEquals(result.getDateVersement(), versement.getDateExecution());
	      
	    }


	    

}
