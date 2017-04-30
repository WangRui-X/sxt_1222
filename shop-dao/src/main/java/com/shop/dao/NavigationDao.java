package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shop.core.model.Navigation;

public interface NavigationDao {
	
	@Select("SELECT id, is_blank_target,`name`,url from xx_navigation WHERE position=#{position} ORDER BY orders")
	List<Navigation> findByPosition(@Param(value="position") Integer position);
}
