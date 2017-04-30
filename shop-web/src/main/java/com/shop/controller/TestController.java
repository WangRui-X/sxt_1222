package com.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="test")
public class TestController {

	
	@GetMapping("{a}/{bc}/{efg}")
	public String test(@PathVariable Integer a,@PathVariable String bc,@PathVariable String efg){
		return " spring test  "+a+"-->"+bc+"-->"+efg;
	}
}
