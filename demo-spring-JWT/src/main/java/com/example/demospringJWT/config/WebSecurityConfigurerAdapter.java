package com.example.demospringJWT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {
    protected abstract void configure(AuthenticationManagerBuilder auth) throws Exception;


    @Bean
    public AuthenticationManager authenticationManagerBean() throws
            Exception {
        return null;
    }

    protected abstract void configure(HttpSecurity http) throws Exception;
}



//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-security</artifactId>
//</dependency>
//<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-web -->
//<dependency>
//<groupId>org.springframework.security</groupId>
//<artifactId>spring-security-web</artifactId>
//<version>6.1.4</version>
//</dependency>
//
//<dependency>
//<groupId>io.jsonwebtoken</groupId>
//<artifactId>jjwt</artifactId>
//<version>0.9.1</version>
//</dependency>
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-web</artifactId>
//</dependency>
//
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-test</artifactId>
//<scope>test</scope>
//</dependency>
//<dependency>
//<groupId>org.springframework.security</groupId>
//<artifactId>spring-security-test</artifactId>
//<scope>test</scope>
//</dependency>
