package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICateGoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/26 10:55
 */

@RestController
@RequestMapping("/category")
@Api(description = "栏目管理")
public class CateController {

    @Autowired
    private ICateGoryService categoryService;

    @PostMapping("/add")
    @ApiOperation("添加栏目")
    public Message addCategory(Category category) {
        categoryService.savaOrUpdateCategory(category);
        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation("/根据Id删除栏目")
    @ApiImplicitParam(name = "id",value = "栏目Id",paramType = "query",dataType = "int",required = true)
    public Message deleteCategory(int id) {
        categoryService.deleteById(id);
        return MessageUtil.success();
    }


    @PostMapping("/update")
    @ApiOperation("更新数据")
    public Message update(Category category) {
        categoryService.savaOrUpdateCategory(category);
        return MessageUtil.success();
    }

    @GetMapping("/findById")
    @ApiOperation("根据Id查询栏目")
    @ApiImplicitParam(name = "id",value = "栏目Id",paramType = "query",dataType = "int",required = true)
    public Message findById(int id) {
        Category category = categoryService.findById(id);
        return MessageUtil.success(category);
    }

    @GetMapping("/findAll")
    @ApiOperation("查询所有栏目")
    public Message<List<Category>> findAll() {
        List<Category> categories =categoryService.findAll();
        return MessageUtil.success(categories);
    }


}
