package com.training.management.payload.response;

import com.training.management.models.Role;

import java.util.Set;

public class UserResponseDto {

    private String username;
    private String email;
    private Set<Role> roles;


    public UserResponseDto() {
    }

    public UserResponseDto(String username, String email, Set<Role> roleSet) {
        this.username = username;
        this.email = email;
        this.roles = roleSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
