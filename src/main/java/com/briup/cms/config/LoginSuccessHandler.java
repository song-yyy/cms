package com.briup.cms.config;

import com.briup.cms.exception.CustomerException;
import com.briup.cms.util.JwtTokenUtils;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/28 10:09
 */

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

             response.setContentType("application/json;charset=UTF-8");

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());

            String token = JwtTokenUtils.createToken(userDetails, false);

            token = JwtTokenUtils.TOKEN_PREFIX + token;

            response.setHeader(JwtTokenUtils.TOKEN_HEADER,token);

            Message<String> success = MessageUtil.success(token);
            response.getWriter().println(objectMapper.writeValueAsString(success));
        } catch (UsernameNotFoundException e) {
            response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"创建token失败，请与管理员联系")));
        }
    }
}
