package com.shop.directive;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shop.core.model.Brand;
import com.shop.service.BrandService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class BrandListDirective extends BaseDirective{
	
	@Resource
	private BrandService brandDirective;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		
		Integer productCategoryId=(Integer) getParameter(params, "productCategoryId");
		BigDecimal count=(BigDecimal) getParameter(params, "count");
		
		List<Brand> brands=brandDirective.findBrands(productCategoryId,count.intValue());
		
		setVariable(env, body, "brands", brands);
	}

}
