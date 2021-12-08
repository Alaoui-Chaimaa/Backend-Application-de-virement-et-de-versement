package ma.octo.assignement.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import ma.octo.assignement.domain.util.Gender;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Date;


@Entity
@Table(name = "UTILISATEUR")
@Data //ajouté
@AllArgsConstructor //ajouté
@NoArgsConstructor //ajouté
public class Utilisateur implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 10, nullable = false, unique = true)
  private String username;

  @Enumerated(EnumType.STRING) //ajouté
  @Column(length = 10, nullable = false)
  private Gender gender;
  
  
  @Column(length = 60, nullable = false)
  private String lastname;

  @Column(length = 60, nullable = false)
  private String firstname;

  @Temporal(TemporalType.DATE)
  private Date birthdate;



}
