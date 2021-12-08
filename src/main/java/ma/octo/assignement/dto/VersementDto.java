package ma.octo.assignement.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.octo.assignement.domain.Compte;

@Data
@NoArgsConstructor

public class VersementDto {
	private Compte CompteBeneficiaire;
    private BigDecimal montant;
    private Date dateVersement;
    private String cinEmetteur;

}
