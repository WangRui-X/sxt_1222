package com.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.core.model.User;
import com.shop.service.UserService;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	
	@Resource
	private UserService userService;
	
	
	@PutMapping(value="addUser")
	public Map<String, Object> addUser(User user){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("resultCode", 200);
		map.put("msg", "操作成功");
		
		Integer userId=userService.addUser(user);
		map.put("userId", userId);
		return map;
	}
	
	@GetMapping(value="updateUser")
	public Map<String, Object> updateUser(User user){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("resultCode", 200);
		map.put("msg", "操作成功");
		Integer count=userService.updateUser(user);
		map.put("受影响行数", count);
		return map;
	}
	
	@PutMapping(value="queryUserById")
	public Map<String, Object> queryUserById(Integer id){
		User user= userService.queryUserById(id);
		Map<String, Object> map=new HashMap<>();
		map.put("resultCode", 200);
		map.put("msg", "success");
		map.put("result", user);
		return map;
	}
	
	@RequestMapping(value="deleteUser",method=RequestMethod.POST)
	public Map<String, Object> deleteUser(Integer id){
		Integer count=userService.deleteUser(id);
		Map<String, Object> map=new HashMap<>();
		map.put("resultCode", 200);
		map.put("msg", "操作成功");
		map.put("受影响的行数", count);
		return map;
	}
	
	
	
}
