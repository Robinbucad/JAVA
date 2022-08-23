package com.example.refactorCRUDbp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationConfiguration configuration;


    void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //Todos los usuarios podrán acceder a estos endpoints

        http.authorizeRequests()
                .antMatchers(GET,
                        "/login/**",
                        "/user/**",
                        "/profesor/**",
                        "/student/**",
                        "/estAsignatura/**",
                        "/roles/**"
                ).permitAll()

                //Solo el admin podra

                .antMatchers(POST,
                        "/user/**",
                        "/profesor/**",
                        "/student/**",
                        "/estAsignatura/**"
                ).hasAnyAuthority("ADMIN")
                .antMatchers(PUT,
                        "/user/**",
                        "/profesor/**",
                        "/student/**",
                        "/estAsignatura/**"
                ).hasAnyAuthority("ADMIN")
                .antMatchers(DELETE,
                        "/user/**",
                        "/profesor/**",
                        "/student/**",
                        "/estAsignatura/**"
                ).hasAnyAuthority("ADMIN")

                .anyRequest().authenticated(); // TODOS TIENEN QUE ESTAR AUTENTICADOS

        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return configuration.getAuthenticationManager();
    }
}