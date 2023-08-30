package com.Spring_Boot.Material_Inventory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class User_Security {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(config -> config
                        .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/siteIncharge").hasRole("USER")
                        .requestMatchers("/getMaterial").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin().loginPage("/login");
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("adarsh")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN").build();
        UserDetails user2 = User.builder()
                .username("vijay")
                .password(passwordEncoder().encode("221"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
