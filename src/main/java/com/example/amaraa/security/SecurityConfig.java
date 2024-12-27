package com.example.amaraa.security;

import com.example.amaraa.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserService userService;

    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Using the new functional approach for security configuration
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/register", "/login", "/products/**", "/images/**", "/css/**", "/js/**", "/").permitAll() // Public paths
                                .requestMatchers("/users/**").authenticated() // Require authentication for user-specific paths
                                .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict access to admin paths
                                .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login") // Custom login page
                                .defaultSuccessUrl("/", true) // Redirect to homepage on login success
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // Custom logout URL
                                .logoutSuccessUrl("/") // Redirect to homepage on logout success
                                .invalidateHttpSession(true) // Invalidate the session
                                .deleteCookies("JSESSIONID") // Delete session cookies
                                .permitAll()
                )
                .csrf(csrf ->
                        csrf
                                .csrfTokenRepository(org.springframework.security.web.csrf.CookieCsrfTokenRepository.withHttpOnlyFalse()) // CSRF token storage
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userService) // Custom user service to load user details
                .passwordEncoder(passwordEncoder()); // BCrypt password encoder
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
