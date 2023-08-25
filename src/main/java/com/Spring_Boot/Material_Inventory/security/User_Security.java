package com.Spring_Boot.Material_Inventory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class User_Security {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserInfoUserDetailsService();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
//        dao.setUserDetailsService(this.userDetailsService());
//        dao.setPasswordEncoder(passwordEncoder());
//        return dao;
//    }
//
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.authenticationProvider(authenticationProvider());
//    }

//    public void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().
//    }



}
