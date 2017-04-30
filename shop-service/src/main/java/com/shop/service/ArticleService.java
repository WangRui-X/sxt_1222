package com.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.Article;
import com.shop.core.utils.AssertUtil;
import com.shop.dao.ArticleDao;

@Service
public class ArticleService {
	
	@Resource
	private ArticleDao articleDao;

	public List<Article> findArticleList(Integer articleCategoryId, int count) {
		AssertUtil.isTrue(articleCategoryId==null||articleCategoryId<1, "分类Id不能为空");
		if(count==0){
			count=6;
		}
		
		return articleDao.findArticleList(articleCategoryId,count);
	}
}
