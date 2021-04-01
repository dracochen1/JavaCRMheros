package com.crmheros.crmheros;

import com.crmheros.crmheros.interceptors.RoleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    RoleInterceptor roleInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedOrigins("http://localhost:3000")
                .allowedHeaders("*");
    }

    @Bean
    public RoleInterceptor createRoleInterceptor() {

        return new RoleInterceptor();
    }

    public @Override
    void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createRoleInterceptor()).addPathPatterns("/supers/");
    }
}