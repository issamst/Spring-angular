package com.training.management.service;


import com.training.management.models.ERole;
import com.training.management.models.Role;
import com.training.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findByName(ERole eRole) {
        return roleRepository.findByName(eRole).orElseThrow(() -> new RuntimeException("Role not found"));
    }
}
