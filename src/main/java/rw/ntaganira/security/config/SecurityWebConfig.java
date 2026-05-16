package rw.ntaganira.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : SecurityWebConfig.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Excludes static resources from Spring Security
 * --------------------------------------------------------------------
 */

@Configuration
public class SecurityWebConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        return (WebSecurity web) -> web
                .ignoring()
                .requestMatchers(

                        "/assets/**",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/fonts/**",
                        "/favicon.ico");
    }

}