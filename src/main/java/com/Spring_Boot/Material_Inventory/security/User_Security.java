package com.Spring_Boot.Material_Inventory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class User_Security {

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails userDetails1 = User.withUsername("Sachin")
//                .password(passwordEncoder.encode("123"))
//                .roles("ADMIN").build();
//        UserDetails userDetails2 = User.withUsername("Adarsh")
//                .password(passwordEncoder.encode("221"))
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    public UserDetailsService userDetailsService() {
//        return new UserInfoUserDetailsService();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/myStore/getMaterial").permitAll()
//                .and().authorizeHttpRequests().requestMatchers("/myStore/siteIncharge")
//                .authenticated().and().formLogin().and().build();
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
//        dao.setUserDetailsService(userDetailsService());
//        dao.setPasswordEncoder(passwordEncoder());
//        return dao;
//    }

}
