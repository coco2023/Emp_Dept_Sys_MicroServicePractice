package com.microprac.rbacauthprac.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/basic/**")
                .authorizeRequests()
                .anyRequest().hasRole("ADMIN")
                .antMatchers("/basic/logout").permitAll()

                .and()
                    .httpBasic()

                .and()
                    .csrf().disable();
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("123")
                .roles("ADMIN");
    }
}
