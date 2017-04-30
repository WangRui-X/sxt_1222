package com.shop.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shop.core.model.User;

@Mapper()
public interface UserDao {
	
	@Insert("insert into user (uname,pwd,location,nation) values(#{uname},#{pwd},#{location},#{nation})")
	//插入返回主键值
	@Options(useGeneratedKeys=true,keyProperty="id")
	Integer addUser(User user);
	
	@Update("update user set uname=#{uname},pwd=#{pwd},location=#{location},nation=#{nation}  where id=#{id}")
	Integer updateUser(User user);
	
	@Select("select * from user where id=#{id}")
	User queryUserById(Integer id);
	
	@Delete("delete from user where id=#{id}")
	Integer deleteUser(Integer id);
	
	@Select("select * from user")
	List<User> queryUsersByParams();
	
	@Select("select * from user")
	List<User> selectForPage(@Param("uname")String uname,PageBounds pageBounds);
}
