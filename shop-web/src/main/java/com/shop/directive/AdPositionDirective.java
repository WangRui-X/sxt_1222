package com.shop.directive;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.alibaba.fastjson.JSON;
import com.shop.core.model.AdPosition;
import com.shop.core.model.Navigation;
import com.shop.core.model.ProductCateGory;
import com.shop.core.model.Promotion;
import com.shop.service.AdPositionService;
import com.shop.service.NavigationService;
import com.shop.service.ProductCateGoryService;
import com.shop.service.PromotionService;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class AdPositionDirective extends BaseDirective{
	
	@Resource
	private AdPositionService adPositionService;
	
	@Resource
	private FreeMarkerConfigurer freemarkerConfig;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		
		BigDecimal id=(BigDecimal) getParameter(params, "id");
		
		AdPosition adPosition=adPositionService.findAdById(id.intValue());
		
		String template=adPosition.getTemplate();
		
		//输出
		if(body==null){
			//将模版内容和数据进行绑定输出
			Template temp=new Template("adTemplate", 
					new StringReader(template),freemarkerConfig.getConfiguration());
			Map<String, Object> dataModel=new HashMap<>();
			dataModel.put("adPosition", adPosition);
			temp.process(dataModel, env.getOut());
		}else{
			setVariable(env, body, "adPosition", adPosition);
		}
		
	}
	

	
}
