package com.shop.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.ProductCateGory;
import com.shop.dao.ProductCateGoryDao;
@Service
public class ProductCateGoryService {
	
	@Resource
	private ProductCateGoryDao productCateGoryDao;
	
	//获取第一分类
	public List<ProductCateGory> findRootList(int count){
		if(count==0){
			count=6;
		}
		return productCateGoryDao.findRootList(count);
	}
	
	/**
	 * 获取子类分类
	 * @param count
	 * @param productCategoryId
	 * @return
	 */
	public List<ProductCateGory> findChildrenList(int count, Integer parentId) {
		if(count==0){
			count=3;
		}
		if(parentId==null){
			return Collections.emptyList();
		}
		 return productCateGoryDao.findChildrenList(count,parentId);
	}
}
