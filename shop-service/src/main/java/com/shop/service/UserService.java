package com.shop.service;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.core.base.exception.ParamException;
import com.shop.core.dto.UserDto;
import com.shop.core.model.User;
import com.shop.dao.UserDao;

import sun.util.logging.resources.logging;

@Service
public class UserService {
	

	@Autowired
	private UserDao userDao;
	
	private static Logger logger=LoggerFactory.getLogger(UserService.class);
	
	public Integer addUser(User user){
		//参数的校验
		if(StringUtils.isBlank(user.getUname())){
			throw new ParamException("用户名不能为空");
		}
	Integer count=userDao.addUser(user);
	Integer userId=user.getId();
	logger.info("受影响的行数count={},返回的主键值userId={}",count,userId);
		return userId;
	}
	
	
	public Integer updateUser(User user){
		Integer count=userDao.updateUser(user);
		logger.info("受影响的行数:count={}",count);
		return count;
	}
	
	public User queryUserById(Integer id){
		User user= userDao.queryUserById(id);
		logger.info("名字是uname{}", user.getUname());
		
		return user;
	}
	
	public Integer deleteUser(Integer id){
		Integer count=userDao.deleteUser(id);
		logger.info("受影响的行数:count=", count);
		return count;
	}
	
	public PageList<User> selectForPage(UserDto userDto){
		//构造PageBounds
		PageBounds pageBounds=userDto.toPageBounds();
		
		PageList<User> result=(PageList<User>)userDao.selectForPage(userDto.getUname(), pageBounds);
		
		logger.info("paginator:{}",result.getPaginator());
		return result;
	}
	
	
	
}
