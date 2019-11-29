package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.ex.CategoryEX;
import com.briup.cms.exception.CustomerException;

import java.util.List;

/**
 * @Program:
 * @Description:
 * @Author: Songyu
 * @Date: 2019/11/26 10:56
 */
public interface ICateGoryService {

    void savaOrUpdateCategory(Category category) throws CustomerException;

    void deleteById(int id) throws CustomerException;

    Category findById(int id) throws CustomerException;

    List<Category> findAll() throws CustomerException;

    //查询所有栏目包括栏目所对应的信息
    List<CategoryEX> findAllCategoryEx() throws CustomerException;
}
