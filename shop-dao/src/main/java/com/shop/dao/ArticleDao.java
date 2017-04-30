package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shop.core.model.Article;

public interface ArticleDao {
	
	@Select("SELECT id,title from xx_article where article_category=#{articleCategoryId}  ORDER BY hits  desc LIMIT #{count}")
	List<Article> findArticleList(@Param("articleCategoryId")Integer articleCategoryId, @Param("count")int count);
	
}
