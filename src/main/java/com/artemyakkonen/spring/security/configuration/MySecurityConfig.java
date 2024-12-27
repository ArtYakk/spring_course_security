package com.artemyakkonen.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class MySecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((user) -> user
                .requestMatchers("/").hasAnyRole("MANAGER", "HR", "EMPLOYEE")
                .requestMatchers("/manager_info/**").hasRole("MANAGER")
                .requestMatchers("/hr_info/**").hasRole("HR")
                .anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults());


        return http.build();
    }


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
