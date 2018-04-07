package com.skyforce.services.implementations;

import com.skyforce.models.User;
import com.skyforce.repositories.UserRepository;
import com.skyforce.security.role.Role;
import com.skyforce.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Date 04.04.2018
 *
 * @author Hursanov Sulaymon
 * @version v1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registerNewUser(User user) {
        String password = user.getHashPassword();
        String encoded = passwordEncoder.encode(password);
        user.setHashPassword(encoded);
        user.setRole(Role.USER);
        userRepository.save(user);
    }
}
