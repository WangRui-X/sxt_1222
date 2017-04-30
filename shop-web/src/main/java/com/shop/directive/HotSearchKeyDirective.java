package com.shop.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shop.core.base.exception.ResultInfo;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class HotSearchKeyDirective extends BaseDirective{
	
	@Resource
	private RestTemplate recompile;
	
	//从配置文件中读取
	@Value("${cache.domain}")
	private String cacheDomain;
	
	@Value("${url.hot.search}")
	private String urlHotSrarch;
	
	
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		
		/*ResultInfo resultInfo=recompile.getForObject(cacheDomain+urlHotSrarch, ResultInfo.class);
		
		List<String> result=(List<String>) resultInfo.getResult();*/
		List<String> result=new ArrayList<>();
		result.add("苹果");
		result.add("三星");
		result.add("索尼");
		result.add("华为");
		result.add("魅族");
		result.add("佳能");
		result.add("尼康");
		result.add("美的");
		result.add("格力");
		setVariable(env, body, "keywords", result);
	}

}
