package com.microprac.springsecurity.config;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2

public class CustomFromLoginFilter extends AbstractAuthenticationProcessingFilter {

    CustomFromLoginFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, HttpMethod.POST.name()));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        // get username & password from http request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        log.info("username: " + username + "password: " + password);

        // check the userName and password
        customCheck(username, password);

        // define the role
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("USER"));

        log.info("this is request: " + request.toString());
        log.info("simpList: " + simpleGrantedAuthorityList.toString());
        log.info("response: " + response.toString());

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, simpleGrantedAuthorityList);
        log.info("token getPrincipal: " + token.getPrincipal());
        log.info("token getDetails: " + token.getDetails());
        log.info("token: " + token.toString());

        return token;

    }

    private void customCheck(String username, String password){
        if (!("user".equals(username) && "123".equals(password))) {
            throw new RuntimeException("Wrong userName or password!");
        }
    }
}
