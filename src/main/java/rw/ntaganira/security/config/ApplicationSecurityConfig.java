package rw.ntaganira.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import rw.ntaganira.security.filter.JwtAuthenticationFilter;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : ApplicationSecurityConfig.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Configures Spring Security authentication and authorization
 * --------------------------------------------------------------------
 */

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(
                        HttpSecurity http) throws Exception {

                http
                                .csrf(csrf -> csrf.disable())

                                .authorizeHttpRequests(auth -> auth

                                                .requestMatchers(

                                                                "/",
                                                                "/products/**",
                                                                "/vendors/**",

                                                                "/assets/**",
                                                                "/css/**",
                                                                "/js/**",
                                                                "/images/**",
                                                                "/fonts/**",

                                                                "/api/v1/auth/**",
                                                                "/h2-console/**"

                                                ).permitAll()
                                                .requestMatchers("/admin/**")
                                                .hasRole("ADMIN")
                                                .requestMatchers("/api/v1/storage/**")
                                                .hasAnyRole(
                                                                "ADMIN",
                                                                "VENDOR")
                                                .anyRequest()
                                                .authenticated())

                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(
                                                                SessionCreationPolicy.STATELESS))

                                .headers(headers -> headers.frameOptions(frame -> frame.disable()))

                                .addFilterBefore(
                                                jwtAuthenticationFilter,
                                                UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(
                        AuthenticationConfiguration configuration) throws Exception {

                return configuration.getAuthenticationManager();
        }

}