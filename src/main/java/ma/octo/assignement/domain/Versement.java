package ma.octo.assignement.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "VERSEMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VERSEMENT")
public class Versement extends Operation {

	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "NOM_EMETTEUR")
    private String nomEmetteur;
	
	@Column(name = "CIN_EMETTEUR")
    private String cinEmetteur;
}
