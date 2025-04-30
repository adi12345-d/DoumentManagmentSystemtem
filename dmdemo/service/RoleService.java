package com.document.dmdemo.service;

import com.document.dmdemo.exception.InvalidRoleException;
import com.document.dmdemo.model.RoleEntity;

import java.util.List;

public interface RoleService {
    RoleEntity createRole(RoleEntity role);
    RoleEntity updateRole(RoleEntity role) throws InvalidRoleException;
    void deleteRole(Long roleId);
    RoleEntity getRoleById(Long roleId);
    RoleEntity getRoleByName(String name);
    List<RoleEntity> getAllRoles();
}