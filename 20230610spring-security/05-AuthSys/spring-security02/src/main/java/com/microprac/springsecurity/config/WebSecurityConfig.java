package com.microprac.springsecurity.config;

import com.microprac.springsecurity.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@EnableWebSecurity
@Log4j2

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")

                .and()
                .logout().logoutUrl("/logout")
//                         .logoutSuccessUrl("/login")
                         .clearAuthentication(true).permitAll()

                .and()
                .csrf().disable();;

//        http.addFilterAt(customFromLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAt(customJSONLoginFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    private CustomJSONLoginFilter customJSONLoginFilter() {
        CustomJSONLoginFilter customJSONLoginFilter = new CustomJSONLoginFilter("/login", userService);

        return customJSONLoginFilter;
    }

//    private CustomFromLoginFilter customFromLoginFilter() {
//        CustomFromLoginFilter filter = new CustomFromLoginFilter("/login");
//        log.info("this is filter: " + filter);
//        return filter;
//    }

}
