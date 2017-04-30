package com.shop.directive;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.shop.core.model.Navigation;
import com.shop.core.model.ProductCateGory;
import com.shop.core.model.Promotion;
import com.shop.service.NavigationService;
import com.shop.service.ProductCateGoryService;
import com.shop.service.PromotionService;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class PromotionListDirective extends BaseDirective{
	
	@Resource
	private PromotionService promotionService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		
		Integer productCategoryId=(Integer) getParameter(params, "productCategoryId");
		BigDecimal count=(BigDecimal) getParameter(params, "count");
		//是否结束
		Boolean hasEnd=(Boolean) getParameter(params, "hasEnd");
		List<Promotion> promotions=promotionService.findPromotions(productCategoryId,count.intValue(),hasEnd);	
		//输出
		setVariable(env, body, "promotions", promotions);
	}
	

	
}
