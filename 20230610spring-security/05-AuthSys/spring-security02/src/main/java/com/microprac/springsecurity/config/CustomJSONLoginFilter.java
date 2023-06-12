package com.microprac.springsecurity.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.microprac.springsecurity.entity.UserDO;
import com.microprac.springsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomJSONLoginFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private UserService userService;

    CustomJSONLoginFilter(String defaultFilterProcessesUrl, UserService userService) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, HttpMethod.POST.name()));
        this.userService = userService;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        JSONObject requestBody = getRequestBody(httpServletRequest);

        // here is receiving the JSON post request from PostMan
        String username = requestBody.getString("username");
        String password = requestBody.getString("password");
        String role = requestBody.getString("role");

//        // here is to receive the form request
//        String username = httpServletRequest.getParameter("username");
//        String password = httpServletRequest.getParameter("password");
//        String role = httpServletRequest.getParameter("role");


        validateUsernameAndPassword(username, password);

        log.info("role: " + role + "username: " + username);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, simpleGrantedAuthorities);
        log.info("token: " + token.toString());
        return token;
    }

    /**
     * check username and password
     * @param username
     * @param password
     * @throws AuthenticationException
     */
    private void validateUsernameAndPassword(String username, String password) throws AuthenticationException {
        UserDO userDO = userService.getByUsername(username);
        //TODO: get "user not exist" ERROR here when using PostMan to login
        if (userDO == null) {
            throw new RuntimeException("user not exist");
        }
        if (!userDO.getPassword().equals(password)) {
            throw new AuthenticationServiceException("error username or password");
        }
    }

    /**
     * get response body
     * @param request
     * @return
     * @throws AuthenticationException
     */
    private JSONObject getRequestBody(HttpServletRequest request) throws AuthenticationException{
        try {
            StringBuilder stringBuilder = new StringBuilder();
            InputStream inputStream = request.getInputStream();
            byte[] bs = new byte[StreamUtils.BUFFER_SIZE];

            int len;
            while ((len = inputStream.read(bs)) != -1) {
                stringBuilder.append(new String(bs, 0, len));
            }
            return JSON.parseObject(stringBuilder.toString());

        } catch (IOException e) {
            log.error("get request body error.");
        }
        throw new AuthenticationServiceException("invalid request body");
    }
}
