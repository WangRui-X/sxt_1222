package com.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.Navigation;
import com.shop.core.utils.AssertUtil;
import com.shop.dao.NavigationDao;

@Service
public class NavigationService {
	
	
	@Resource
	private NavigationDao navigationDao;
	
	/**
	 * 根据位置查询导航菜单数据
	 * @param position
	 * @return
	 */
	public List<Navigation> findByPosition(int position){
		//参数校验
		AssertUtil.isTrue(position<0, "请选择一个位置再查询");
		return navigationDao.findByPosition(position);
	}
}
