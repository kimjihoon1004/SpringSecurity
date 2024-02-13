package com.eugeneprogram.testweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.eugeneprogram.testweb.service.TestService;

/*
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpSession;
*/

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    TestService testService;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        int num = 0;
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        try {
            num = testService.comparePw(password, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (num > 0) {
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
    
    
   
}
