package com.microprac.rbacauthprac.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/form/**")
                .authorizeRequests()
                .anyRequest().hasRole("USER")

                .and()
                .formLogin()
                    .loginPage("/form/formLogin").permitAll()
                    .loginProcessingUrl("/form/formLoginPost").permitAll()
                    .defaultSuccessUrl("/form/formHome")

                .and()
                    .logout().logoutUrl("/form/logout")
                    .logoutSuccessUrl("/form/formLogin")

                .and()
                    .httpBasic().disable()
                    .csrf().disable();
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("123")
                .roles("USER");
    }

}
