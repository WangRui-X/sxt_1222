package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="hello")
public class HelloController {
	
	
//	@PostMapping(value="index")
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String hello(){
		return "hello world";
	}
}
