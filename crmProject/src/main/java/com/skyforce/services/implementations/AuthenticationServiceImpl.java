package com.skyforce.services.implementations;

import com.skyforce.models.User;
import com.skyforce.repositories.UserRepository;
import com.skyforce.security.details.UserDetailsImpl;
import com.skyforce.services.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by Sulaymon on 18.03.2018.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String email = userDetails.getUsername();
        return userRepository.findByEmail(email);
    }
}
