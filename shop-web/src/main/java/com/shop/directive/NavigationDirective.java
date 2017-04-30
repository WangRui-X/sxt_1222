package com.shop.directive;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.core.model.Navigation;
import com.shop.service.NavigationService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
@SuppressWarnings("rawtypes")
public class NavigationDirective extends BaseDirective {
	
	@Autowired
	private NavigationService navigationService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
			TemplateDirectiveBody body)
	throws TemplateException, IOException {
		
		BigDecimal position =  (BigDecimal) getParameter(params,"position");// 获取参数
		if (position == null) {
			position = new BigDecimal(0);
		}
		List<Navigation> navigations = navigationService.findByPosition(position.intValue());
		
		// 输出
		setVariable(env, body, "navigations", navigations);
	}
	
}
