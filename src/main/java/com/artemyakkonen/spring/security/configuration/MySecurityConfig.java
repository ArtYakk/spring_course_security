package com.artemyakkonen.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@Order(2)
public class MySecurityConfig{

@Bean
public UserDetailsService userDetailsService()  {
   UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails user1 = users
                .username("zaur")
                .password("zaur")
                .roles("EMPLOYEE")
                .build();
        UserDetails user2 = users
                .username("elena")
                .password("elena")
                .roles("HR")
                .build();
        UserDetails user3 = users
                .username("ivan")
                .password("ivan")
                .roles("MANAGER", "HR")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
