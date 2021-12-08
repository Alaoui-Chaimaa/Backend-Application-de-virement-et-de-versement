package ma.octo.assignement.service;

import ma.octo.assignement.domain.AuditOperation;
import ma.octo.assignement.domain.util.EventType;
import ma.octo.assignement.repository.AuditOperationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AutiService {

    Logger LOGGER = LoggerFactory.getLogger(AutiService.class);

    @Autowired
    private AuditOperationRepository auditOperationRepository;

    public void auditVirement(String message) {

        LOGGER.info("Audit de l'événement {}", EventType.VIREMENT);

        AuditOperation audit = new AuditOperation();
        audit.setEventType(EventType.VIREMENT);
        audit.setMessage(message);
        auditOperationRepository.save(audit);
    }


    public void auditVersement(String message) {

        LOGGER.info("Audit de l'événement {}", EventType.VERSEMENT);

        AuditOperation audit = new AuditOperation();
        audit.setEventType(EventType.VERSEMENT);
        audit.setMessage(message);
        auditOperationRepository.save(audit);
    }
}
