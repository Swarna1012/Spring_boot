package com.example.demospringJWT.config;

import com.example.demospringJWT.jwtutils.JwtAuthenticationEntryPoint;
import com.example.demospringJWT.jwtutils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtFilter filter;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws
            Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http .csrf(AbstractHttpConfigurer::disable)
                .securityMatcher("/login")
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )


//                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
//                .and()
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

}


