/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author dell
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserService userDetailService;
    
    @Bean
     public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
     @Bean
    public UserService getUserService(){
        return new UserService();
    }
    
    //Bean: Es como el autowire que inyectaba dependencias, peeero inyectamos dependencias pero de configuracion
    //que debe hacer el programa cuando se esta ejecutando
    
    @Bean
    DaoAuthenticationProvider AuthenticationProvider (){
     DaoAuthenticationProvider  daoAuthenticationProvider = new DaoAuthenticationProvider();
     daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
     daoAuthenticationProvider.setUserDetailsService(getUserService());
     return daoAuthenticationProvider;
    }
    
     @Bean
     public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
         return new AppAuthenticationSuccessHandler();
     }
    
    public SecurityConfig(UserService userPrincipalDetailsService){
        this.userDetailService= userPrincipalDetailsService;
    }
    
    @Override
    protected void configure (AuthenticationManagerBuilder auth){
    auth.authenticationProvider(AuthenticationProvider());
    }
    
    //El siguiente método funciona para hacer la autenticacion del usuario
    
    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/persona", "/login", "/personaN")
                .hasRole("ADMIN")
                .antMatchers("/persona", "/", "/login")
                .hasAnyRole("USER", "VENDEDOR", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/persona", true);
    }
    
    //El siguiente método funciona para ralizar la autorización de accesos
    //i18n
    
    
}
