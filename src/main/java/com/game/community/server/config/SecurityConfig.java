package com.game.community.server.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * 개발 단계 : hsts, csrf, 보안 해제함
 * 배포 전 보강할 것
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 보안 설정
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http 비활성화
        http.httpBasic(AbstractHttpConfigurer::disable);
        
        // hsts 보안 설정
//        http.headers(headers ->headers
//                .httpStrictTransportSecurity(hsts -> hsts
//                .maxAgeInSeconds(31536000)
//                .includeSubDomains(true)
//                .preload(true)
//                ));

        // http 요청  -> https로 강제함
//        http
//                .requiresChannel(channel -> channel
//                        .anyRequest().requiresSecure());
        
        // x-frame-option 설정
        http.headers(headers -> headers
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
        );
        // csrf 비활성화
        http.csrf(csrf -> csrf.disable());
        // cors config로 따로 관리
        http.cors(Customizer.withDefaults());
        return http.build();
    }


}
