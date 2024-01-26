package com.training.management;


import com.training.management.models.ERole;
import com.training.management.models.Role;
import com.training.management.models.User;
import com.training.management.payload.request.CompanyRequestDto;
import com.training.management.repository.RoleRepository;
import com.training.management.repository.UserRepository;
import com.training.management.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CompanyService companyService;


    @Override
    public void run(String... args) throws Exception {
            createRole(ERole.ROLE_ADMIN);
            createRole(ERole.ROLE_ASSISTANT);
            createRole(ERole.ROLE_PARTICIPANT);
            createRole(ERole.ROLE_TRAINER);
            createAdminUser();
            createNormalUser();
            //createParticipant();
//            createCompany(CompanyRequestDto.builder().name("Company 1").email("company1@gmail.com")
//                    .address("Dhaka").phoneNumber("01753155400").build());
    }



    private void createCompany(CompanyRequestDto dto) {
        companyService.createCompany(dto);
    }

    void createRole(ERole role){
        Optional<Role> roleInst = roleRepository.findByName(role);
        if(!roleInst.isPresent()) {
            Role entity = new Role(role);
            roleRepository.save(entity);
        }
    }

    void createAdminUser(){
        Optional<User> user = userRepository.findByUsername("admin");
        Set<Role> roleSet = new HashSet<>();
        Optional<Role> role = roleRepository.findByName(ERole.ROLE_ADMIN);
        role.ifPresent(roleSet::add);

        if(!user.isPresent()){
            User newUser = new User("admin","admin@gmail.com",
                    passwordEncoder.encode("123456"));
            newUser.setRoles(roleSet);
            userRepository.save(newUser);
        }
    }

    void createNormalUser(){
        Optional<User> user = userRepository.findByUsername("user");
        Set<Role> roleSet = new HashSet<>();
        Optional<Role> role = roleRepository.findByName(ERole.ROLE_ASSISTANT);
        role.ifPresent(roleSet::add);

        if(!user.isPresent()){
            User newUser = new User("user","user@gmail.com",
                    passwordEncoder.encode("123456"));
            newUser.setRoles(roleSet);
            userRepository.save(newUser);
        }
    }

    private void createParticipant() {
        Optional<User> user = userRepository.findByUsername("participant");
        Set<Role> roleSet = new HashSet<>();
        Optional<Role> role = roleRepository.findByName(ERole.ROLE_PARTICIPANT);
        role.ifPresent(roleSet::add);

        if(!user.isPresent()) {
            User newUser = new User("part", "part@gmail.com",
                    passwordEncoder.encode("123456"));
            newUser.setRoles(roleSet);
            userRepository.save(newUser);

        }
    }

}
