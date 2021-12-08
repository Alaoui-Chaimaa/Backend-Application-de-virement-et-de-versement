package ma.octo.assignement.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.octo.assignement.domain.Compte;

@Data
@NoArgsConstructor
public class VirementDto {
  private Compte CompteEmetteur;
  private Compte CompteBeneficiaire;
  private String motifVirement;
  private BigDecimal montantVirement;
  private Date dateVirement;

 
}
