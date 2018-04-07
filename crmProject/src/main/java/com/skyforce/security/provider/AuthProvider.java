package com.skyforce.security.provider;

import com.skyforce.models.User;
import com.skyforce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sulaymon on 18.03.2018.
 */
@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pass = authentication.getCredentials().toString();

        Optional<User> userOptional = userRepository.findFirstByEmail(email);
        if (userOptional.isPresent()){
            User user = userOptional.get();

            if (!passwordEncoder.matches(pass, user.getHashPassword())){
                throw new BadCredentialsException("Wrong password or login");
            }
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails, pass, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
