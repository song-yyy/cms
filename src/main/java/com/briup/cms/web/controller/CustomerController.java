package com.briup.cms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/28 14:30
 */
@RestController
@Api(description = "登录管理")
public class CustomerController {

    @PostMapping("/authentication/form")
    @ApiOperation("登录逻辑")
    public void login(String username,String password) {

    }
}
