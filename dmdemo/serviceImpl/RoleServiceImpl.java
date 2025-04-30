package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.InvalidRoleException;
import com.document.dmdemo.exception.RoleNotFoundException;
import com.document.dmdemo.model.RoleEntity;
import com.document.dmdemo.repo.RoleRepository;
import com.document.dmdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleEntity saveRole(RoleEntity role) throws InvalidRoleException {
        validateRole(role);
        return roleRepository.save(role);
    }

    @Override
    public RoleEntity updateRole(RoleEntity role) throws InvalidRoleException {
        if (!roleRepository.existsById(role.getId())) {
            throw new RoleNotFoundException("Role not found with ID: " + role.getId());
        }
        validateRole(role);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        if (!roleRepository.existsById(roleId)) {
            throw new RoleNotFoundException("Role not found with ID: " + roleId);
        }
        roleRepository.deleteById(roleId);
    }

    @Override
    public RoleEntity getRoleById(Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role not found with ID: " + roleId));
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    private void validateRole(RoleEntity role) throws InvalidRoleException {
        if (role.getName() == null || role.getName().isEmpty()) {
            throw new InvalidRoleException("Role name cannot be empty.");
        }
    }
}