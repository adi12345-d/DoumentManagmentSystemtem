package com.document.dmdemo.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String roleId) {
        super("Role not found with ID: " + roleId);
    }
}