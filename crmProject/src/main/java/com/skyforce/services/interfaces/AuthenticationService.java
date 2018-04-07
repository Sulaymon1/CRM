package com.skyforce.services.interfaces;

import com.skyforce.models.User;
import org.springframework.security.core.Authentication;

/**
 * Created by Sulaymon on 18.03.2018.
 */
public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}
