package com.eugeneprogram.testweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.eugeneprogram.testweb.security.CustomAuthenticationProvider;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
        http
            .authorizeHttpRequests((authz) -> authz
                    .requestMatchers(
                            new AntPathRequestMatcher("/"),
                            new AntPathRequestMatcher("/selectDB.do"),
                            new AntPathRequestMatcher("/testPage"),
                            new AntPathRequestMatcher("/test.html"),
                            new AntPathRequestMatcher("/visa.do")
                    ).permitAll()
                    .anyRequest().authenticated())
            .httpBasic(withDefaults());
        return http.build();
    }
    
    
}
