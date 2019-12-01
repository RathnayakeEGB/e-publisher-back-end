package com.e.configaration.security.sercurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e.configaration.security.exception.ResourceNotFoundException;
import com.e.entities.User;
import com.e.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	    @Autowired
	    UserRepository userRepository;

	    @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(email)
	                .orElseThrow(() ->
	                        new UsernameNotFoundException("User not found with email : " + email)
	        );

	        return UserPrincipal.create(user);
	    }

	    @Transactional
	    public UserDetails loadUserById(Long id) {
	        User user = userRepository.findById(id).orElseThrow(
	            () -> new ResourceNotFoundException("User", "id", id)
	        );

	        return UserPrincipal.create(user);
	    }
	
}
