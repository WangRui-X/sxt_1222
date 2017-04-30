package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shop.core.model.ArticleCategory;

public interface ArticleCategoryDao {
	
	@Select("SELECT id,name from xx_article_category WHERE grade=0  ORDER BY orders LIMIT #{count}")
	List<ArticleCategory> findRootList(@Param("count")int count);

}
