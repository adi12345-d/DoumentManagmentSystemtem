package com.document.dmdemo.service;

import com.document.dmdemo.model.AuditLogEntity;

import java.util.List;

public interface AuditLogService {
    AuditLogEntity createAuditLog(AuditLogEntity auditLog);
    List<AuditLogEntity> getAuditLogsByDocumentId(Long documentId);
}