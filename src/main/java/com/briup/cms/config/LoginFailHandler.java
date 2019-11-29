package com.briup.cms.config;

import com.briup.cms.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/28 10:11
 */
public class LoginFailHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationFailure(HttpServletRequest requestequest, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"登陆失败：" + exception.getMessage())));
    }

}
