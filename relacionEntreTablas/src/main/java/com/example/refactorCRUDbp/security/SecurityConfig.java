package com.example.refactorCRUDbp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login"); // Cambiamos el login que viene por defecto
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //Todos los usuarios podrán acceder a estos endpoints

        http.authorizeRequests().antMatchers("/login/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/user/**").permitAll(); //LIMITAMOS LO QUE PUEDE HACER EL USER
        http.authorizeRequests().antMatchers(GET,"/profesor/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/student/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/estAsignatura/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/roles/**").permitAll();

        http.authorizeRequests().antMatchers(POST,"/user/**").hasAnyAuthority("ADMIN"); // SOLO PUEDE POSTEAR EL QUE TENGA ROL ADMIN
        http.authorizeRequests().antMatchers(POST,"/profesor/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/student/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/estAsignatura/**").hasAnyAuthority("ADMIN");

        http.authorizeRequests().antMatchers(PUT,"/user/**").hasAnyAuthority("ADMIN"); //
        http.authorizeRequests().antMatchers(PUT,"/profesor/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(PUT,"/student/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(PUT,"/estAsignatura/**").hasAnyAuthority("ADMIN");



        http.authorizeRequests().antMatchers(DELETE,"/user/**").hasAnyAuthority("ADMIN"); //
        http.authorizeRequests().antMatchers(DELETE,"/profesor/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/student/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/estAsignatura/**").hasAnyAuthority("ADMIN");


        http.authorizeRequests().anyRequest().authenticated(); // TODOS TIENEN QUE ESTAR AUTENTICADOS
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
