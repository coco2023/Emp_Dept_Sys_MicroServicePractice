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

import static io.netty.util.CharsetUtil.encoder;

@Configuration
@Order(1)

public class App1ConfigurationAdapter {

    @Bean
    public SecurityFilterChain filterChainApp1(HttpSecurity http) throws Exception {

        http.antMatcher("/admin*")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")

                .and()
                .formLogin()
                .loginPage("/loginAdmin")
                .loginProcessingUrl("/admin_login")
                .failureUrl("/loginAdmin?error=loginError")
                .defaultSuccessUrl("/adminPage")

                .and()
                .logout()
                .logoutUrl("/admin_logout")
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
    public UserDetailsService userDetailsServiceApp1() {
        UserDetails admin = User.withUsername("admin")
                .password("123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

}
