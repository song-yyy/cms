package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.impl.ArticleServiceImpl;
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
 * @Date: 2019/11/27 9:16
 */
@RestController
@RequestMapping("/article")
@Api(description = "信息管理")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/add")
    @ApiOperation(value = "新增信息",notes = "category.code codegory.name不需要输入")
    public Message addArtivle(Article article) {
        articleService.saveOrUpdateArticle(article);
        return MessageUtil.success();
    }

    @GetMapping("/delete")
    @ApiOperation("根据Id删除信息")
    @ApiImplicitParam(value = "信息Id",name = "id",paramType = "query",dataType = "int",required = true)
    public Message deleteArticle(int id) {
        articleService.deleteById(id);
        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation("更新数据")
    public Message update(Article article) {
        articleService.saveOrUpdateArticle(article);
        return MessageUtil.success();
    }


    @GetMapping("/findById")
    @ApiOperation("根据Id查询信息")
    @ApiImplicitParam(value = "信息Id",name = "id",paramType = "query",dataType = "int",required = true)
    public Message<Article> findById(int id) {
        Article article = articleService.findById(id);
        return MessageUtil.success(article);
    }


    @GetMapping("/findAll")
    @ApiOperation("查询所有信息")
    public Message<List<Article>> findAll() {
        List<Article> articles = articleService.findAll();
        return MessageUtil.success(articles);
    }
}
