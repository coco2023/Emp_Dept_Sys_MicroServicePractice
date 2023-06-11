package com.microprac.springsecurity.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@EnableWebSecurity
@Log4j2

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasAuthority("USER")
//                .antMatchers("/admin/**").hasAuthority("ADMIN")

                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        http.addFilterAt(customFromLoginFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    private CustomFromLoginFilter customFromLoginFilter() {
        CustomFromLoginFilter filter = new CustomFromLoginFilter("/login");
        log.info("this is filter: " + filter);
        return filter;
    }

}
