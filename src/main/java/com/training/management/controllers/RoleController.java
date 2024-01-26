package com.training.management.controllers;


import com.training.management.models.Role;
import com.training.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    //get all roles
    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok(roleService.findAll());
    }



}
