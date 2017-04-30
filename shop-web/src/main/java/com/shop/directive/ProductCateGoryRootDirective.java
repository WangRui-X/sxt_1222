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
import com.shop.service.NavigationService;
import com.shop.service.ProductCateGoryService;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class ProductCateGoryRootDirective extends BaseDirective{
	
	@Resource
	private ProductCateGoryService productCateGoryService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		// TODO Auto-generated method stub
		
		BigDecimal count=(BigDecimal)getParameter(params, "count");
		
		List<ProductCateGory> productCateGories=productCateGoryService.findRootList(count.intValue());
		
		//输出
		setVariable(env, body, "productCateGories", productCateGories);
		
		
	}
	

	
}
