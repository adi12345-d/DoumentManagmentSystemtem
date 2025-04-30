package com.document.dmdemo.exception;

public class AuditLogNotFoundException extends RuntimeException {
    public AuditLogNotFoundException(String auditLogId) {
        super("Audit log not found with ID: " + auditLogId);
    }
}