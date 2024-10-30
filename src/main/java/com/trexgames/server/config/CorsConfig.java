package com.trexgames.server.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * 개발 단계 : 출처, 메서드, 헤더 보안 해제함
 * 배포 전에 보강할 것
 */
@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 주소
        corsConfiguration.setAllowedOriginPatterns(List.of("http://localhost:8090/**"));
//        corsConfiguration.setAllowedOrigins(List.of("http://localhost:8090/"));
        // 메서드
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // 헤더
        corsConfiguration.setAllowedHeaders(List.of("*"));
//        corsConfiguration.addAllowedHeader("Authorization");
//        corsConfiguration.addAllowedHeader("Content-Type");
//        corsConfiguration.addAllowedHeader("Accept");
//        corsConfiguration.addAllowedHeader("Origin");
//        corsConfiguration.setAllowCredentials(true);
        // 적용 설정
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source)); // Casting 수정
        bean.setOrder(0);
        return bean;
    }
}


