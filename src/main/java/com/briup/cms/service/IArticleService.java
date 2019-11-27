package com.briup.cms.service;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArticleDao;
import com.briup.cms.exception.CustomerException;

import java.util.List;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/27 9:25
 */
public interface IArticleService {
    void saveOrUpdateArticle(Article article) throws CustomerException;
    void deleteById(int id) throws CustomerException;
    Article findById(int id) throws  CustomerException;
    List<Article> findAll() throws CustomerException;
}
