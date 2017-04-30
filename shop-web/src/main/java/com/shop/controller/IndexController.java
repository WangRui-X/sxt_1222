package com.shop.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.core.base.BaseController;

@Controller
public class IndexController extends BaseController{
	
	
	@RequestMapping("index")
	public String index(Model model){
		return "index";	
	}
}
