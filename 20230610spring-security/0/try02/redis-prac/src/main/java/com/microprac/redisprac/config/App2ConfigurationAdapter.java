package com.microprac.redisprac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2)

public class App2ConfigurationAdapter {

    @Bean
    public SecurityFilterChain filterChainApp2(HttpSecurity http) throws Exception {

        http.antMatcher("/user*")
                .authorizeRequests()
                .anyRequest()
                .hasRole("USER")

                .and()
                .formLogin()
                .loginPage("/loginUser")
                .loginProcessingUrl("/user_login")
                .failureUrl("/loginUser?error=loginError")
                .defaultSuccessUrl("/userPage")

                .and()
                .logout()
                .logoutUrl("/user_logout")
                .logoutSuccessUrl("/protectedLinks")
                .deleteCookies("JSESSIONID")

                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")

                .and()
                .csrf().disable();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsServiceApp2() {
        UserDetails user = User.withUsername("user")
                .password("123")
                .roles("User")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


}
