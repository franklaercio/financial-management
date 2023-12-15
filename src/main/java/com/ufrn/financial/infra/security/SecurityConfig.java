package com.ufrn.financial.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorized -> authorized
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/person").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/persons").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/persons/cpf/{cpf}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/persons").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/persons/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/persons/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/cards/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/cards").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/cards/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/cards").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/transactions/card/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/transactions/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/transactions").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
