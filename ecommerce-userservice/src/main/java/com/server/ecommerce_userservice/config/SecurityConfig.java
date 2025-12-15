package com.server.ecommerce_userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth-> auth.
                        requestMatchers("/swagger-ui.html",   // the HTML entry (redirects to /swagger-ui/index.html)
                                "/swagger-ui/**",     // UI assets
                                "/v3/api-docs",       // OpenAPI JSON root
                                "/v3/api-docs/**",    // grouped docs
                                  "/v3/api-docs.yaml",
                                "/ws/**",
                                "/chat*"// YAML (if you hit it)
                        )
                        .permitAll()
                        .requestMatchers("/auth/**")
                        .permitAll()
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
