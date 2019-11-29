package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.ex.CategoryEX;
import com.briup.cms.service.ICateGoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/29 9:17
 */
@RestController
@RequestMapping("/index")
@Api(description = "首页管理")
public class IndexController {

    @Autowired
    private ICateGoryService iCateGoryService;

    @GetMapping("/index")
    @ApiOperation("展示首页数据")
    public Message<List<CategoryEX>> showIndex() {
        return MessageUtil.success(iCateGoryService.findAllCategoryEx());
    }
}
