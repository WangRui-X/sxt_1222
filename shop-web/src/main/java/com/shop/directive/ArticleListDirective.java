package com.shop.directive;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shop.core.model.Article;
import com.shop.core.model.ArticleCategory;
import com.shop.service.ArticleCategoryService;
import com.shop.service.ArticleService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class ArticleListDirective extends BaseDirective{
	
	@Resource
	private ArticleService  articleService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		Integer articleCategoryId=(Integer) getParameter(params, "articleCategoryId");
		BigDecimal count=(BigDecimal) getParameter(params, "count");
		List<Article> articles=articleService.findArticleList(articleCategoryId,count.intValue());
		setVariable(env, body, "articles", articles);
		
	}

}
