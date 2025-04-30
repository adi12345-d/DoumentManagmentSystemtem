package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.AuditLogNotFoundException;
import com.document.dmdemo.model.AuditLogEntity;
import com.document.dmdemo.repo.AuditLogRepository;
import com.document.dmdemo.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public AuditLogEntity saveAuditLog(AuditLogEntity auditLog) {
        return auditLogRepository.save(auditLog);
    }

    @Override
    public void deleteAuditLog(Long auditLogId) {
        if (!auditLogRepository.existsById(auditLogId)) {
            throw new AuditLogNotFoundException("Audit log not found with ID: " + auditLogId);
        }
        auditLogRepository.deleteById(auditLogId);
    }

    @Override
    public AuditLogEntity getAuditLogById(Long auditLogId) {
        return auditLogRepository.findById(auditLogId)
                .orElseThrow(() -> new AuditLogNotFoundException("Audit log not found with ID: " + auditLogId));
    }

    @Override
    public List<AuditLogEntity> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }
}