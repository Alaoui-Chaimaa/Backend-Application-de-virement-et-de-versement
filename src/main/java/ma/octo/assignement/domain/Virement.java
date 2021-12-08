package ma.octo.assignement.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "VIREMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation {
 

  @Id  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  private Compte compteEmetteur;

  
}
