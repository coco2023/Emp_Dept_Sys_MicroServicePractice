package com.microprac.rbacauthprac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("123")
                .roles("USER")
                .and()
                .withUser("admin").password("123")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/dashboard")
//                    .permitAll()
                    .and()
                .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/login?logout")
                    .permitAll();
    }

}
