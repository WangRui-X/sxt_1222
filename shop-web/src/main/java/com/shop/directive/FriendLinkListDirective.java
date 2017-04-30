package com.shop.directive;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shop.core.model.FriendLink;
import com.shop.service.FriendLinkService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class FriendLinkListDirective extends BaseDirective{
	
	@Resource
	private FriendLinkService friendLinkService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		
		BigDecimal count=(BigDecimal) getParameter(params, "count");
		List<FriendLink> friendLinks=friendLinkService.findFriendLinkList(count.intValue());
		setVariable(env, body, "friendLinks", friendLinks);
	}

}
