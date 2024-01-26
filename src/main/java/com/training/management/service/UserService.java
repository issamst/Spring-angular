package com.training.management.service;

import com.training.management.models.ERole;
import com.training.management.models.Role;
import com.training.management.models.User;
import com.training.management.payload.response.UserResponseDto;
import com.training.management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder encoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    public UserResponseDto getUserById(Long id)  {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToResponseDto).orElse(null);
    }

    private UserResponseDto convertToResponseDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUsername(user.getUsername());
        responseDto.setEmail(user.getEmail());
        responseDto.setRoles(user.getRoles());
        return responseDto;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public User createUser(String name, String email, String password, ERole eRole) {
       return convertToEntity(name, email, password, eRole);
    }

    public User convertToEntity(String name, String email, String password, ERole eRole) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        // set user role
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findByName(eRole);
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public void sentEmailToUser(String username, String password,String email) {
        // send email to user with password
        System.out.println("Email sent to " + username + " with password: " + password + " to email: " + email);
    }
}
