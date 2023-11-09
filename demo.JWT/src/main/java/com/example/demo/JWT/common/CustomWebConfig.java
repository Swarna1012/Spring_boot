package com.example.demo.JWT.common;

import com.example.demo.JWT.config.JwtInterceptor;
import com.example.demo.JWT.dto.RequestMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor);
    }

    @Bean
    @RequestScope
    public RequestMeta getRequestMeta(){
        return new RequestMeta();
    }

    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor(getRequestMeta());
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver pageResolver = new PageableHandlerMethodArgumentResolver();

        pageResolver.setPageParameterName("page-number");
        pageResolver.setSizeParameterName("page-size");
        pageResolver.setOneIndexedParameters(true);

        Pageable defaultPageable = PageRequest.of(0, 5);
        pageResolver.setFallbackPageable(defaultPageable);

        argumentResolvers.add(pageResolver);
    }
}
