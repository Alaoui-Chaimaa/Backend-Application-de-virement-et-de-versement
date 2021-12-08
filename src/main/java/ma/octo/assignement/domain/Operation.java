package ma.octo.assignement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="type_operation")
public abstract class Operation {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(precision = 16, scale = 2, nullable = false)
	    private BigDecimal montantVirement;

	    @Column
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date dateExecution;

	    @ManyToOne
	    private Compte compteBeneficiaire;

	    @Column(length = 200)
	    private String motifVirement;

}
