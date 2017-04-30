package com.shop.directive;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shop.core.model.Goods;
import com.shop.service.GoodsService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;


@Component
public class GoodListDirective extends BaseDirective{
	
	@Resource
	private GoodsService goodsService;

	@SuppressWarnings("unused")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		//获取参数
		Integer productCategoryId=1;
		
		try {
			productCategoryId=(Integer) getParameter(params, "productCategoryId");
		} catch (Exception e) {
			BigDecimal productCategoryIdBd=(BigDecimal) getParameter(params, "productCategoryId");
			if(productCategoryIdBd!=null){
				productCategoryId=productCategoryIdBd.intValue();
			}
		}
		if(productCategoryId==null){
			productCategoryId=1;
		}
		
		BigDecimal tagId=(BigDecimal) getParameter(params, "tagId");
		BigDecimal count=(BigDecimal) getParameter(params, "count");
		
		//查询数据
		List<Goods> goods=goodsService.findGoodList(tagId.intValue(), count.intValue(), productCategoryId);
		
		//输出数据
		setVariable(env, body, "goods", goods);
	}

}
