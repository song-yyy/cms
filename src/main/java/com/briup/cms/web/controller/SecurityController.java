package com.briup.cms.web.controller;

import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/28 10:37
 */
@RestController
@ApiIgnore
public class SecurityController {

        @GetMapping("/authentication/login")
        public Message login() {
            return MessageUtil.error(403,"该用户没有登录，请跳转到登录页面");
        }
}
