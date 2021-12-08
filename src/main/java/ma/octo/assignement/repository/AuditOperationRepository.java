package ma.octo.assignement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.octo.assignement.domain.AuditOperation;

@Repository
public interface AuditOperationRepository extends JpaRepository<AuditOperation, Long> {
}
