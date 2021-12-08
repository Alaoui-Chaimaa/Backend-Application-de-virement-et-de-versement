package ma.octo.assignement.domain;

import ma.octo.assignement.domain.util.EventType;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUDIT_OPERATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditOperation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100)
  private String message;

  @Enumerated(EnumType.STRING)
  private EventType eventType;


}
