package ma.octo.assignement.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

import java.math.BigDecimal;


@Entity
@Table(name = "COMPTE")
@Data//ajouté
@NoArgsConstructor //ajouté
@AllArgsConstructor //ajouté
public class Compte {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 16, unique = true)
  private String nrCompte;

  //on doit ajouter l'attribut rib pour le versement , doit etre unique
  @Column(length = 24, unique = true)
  private String rib; 

  @Column(precision = 16, scale = 2)
  private BigDecimal solde;

  @ManyToOne()
  @JoinColumn(name = "utilisateur_id")
  private Utilisateur utilisateur;

  
}
