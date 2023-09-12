package com.Spring_Boot.Material_Inventory.security;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration

public class User_Security extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    //    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(config -> config
//                        .requestMatchers("/").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/siteIncharge").hasRole("USER")
//                        .requestMatchers("/getMaterial").hasRole("ADMIN")
//                        .anyRequest().authenticated()).formLogin(Customizer.withDefaults());
//        return http.build();
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder()
//                .username("adarsh")
//                .password(passwordEncoder().encode("123"))
//                .roles("ADMIN").build();
//        UserDetails user2 = User.builder()
//                .username("vijay")
//                .password(passwordEncoder().encode("221"))
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
