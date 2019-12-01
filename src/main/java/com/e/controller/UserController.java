package com.e.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.configaration.security.exception.ResourceNotFoundException;
import com.e.configaration.security.sercurity.CurrentUser;
import com.e.configaration.security.sercurity.UserPrincipal;
import com.e.entities.User;
import com.e.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
	
}
