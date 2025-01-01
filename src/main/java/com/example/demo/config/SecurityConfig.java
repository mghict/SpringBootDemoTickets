package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(authorize->
                        authorize
                                .requestMatchers("/api/error","/api/health")
                                .permitAll()
                                .requestMatchers("/api/admin/**")
                                    .hasAnyRole("ADMIN")
                                .requestMatchers("/api/user/**")
                                    .hasAnyRole("USER","ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .httpBasic(basic->{})
                .formLogin(form->form.disable())
                ;
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("sadmin")
                        .password(passwordEncoder().encode("root"))
                        .roles("ADMIN","USER")
                        .build(),
                User.withUsername("admin")
                        .password(passwordEncoder().encode("root"))
                        .roles("ADMIN")
                        .build(),
                User.withUsername("user")
                        .password(passwordEncoder().encode("123"))
                        .roles("USER")
                        .build()
        );
    }
}
