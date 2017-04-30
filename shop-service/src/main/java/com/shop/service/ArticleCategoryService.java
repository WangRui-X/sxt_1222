package com.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.ArticleCategory;
import com.shop.dao.ArticleCategoryDao;

@Service
public class ArticleCategoryService {
	
	@Resource
	private ArticleCategoryDao articleCategoryDao;

	public List<ArticleCategory> findRootList(int count) {
		if(count==0){
			count=2;
		}
		return articleCategoryDao.findRootList(count);
	}
	
	
}
