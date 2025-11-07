package com.ohgiraffers.jenkins.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                  // origin 이후 요청 경로 패턴(~~localhost:xxxx/이곳)
//                .allowedOrigins("*")                        // origin 등록(어떤 front 서버든 상관 없이)
//                .allowedOrigins("http://localhost:5173")      // origin 등록
                // .allowedOrigins("http://localhost:8011")      // origin 등록(프론트가 컨테이너화 된 이후)
                .allowedOrigins("http://localhost:30000")      // origin 등록(k8s nodeport 이후)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");                        // method 등록(GET, POST, PUT, DELETE)
    }
}
