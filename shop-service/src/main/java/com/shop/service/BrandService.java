package com.shop.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.Brand;
import com.shop.dao.BrandDao;

@Service
public class BrandService {
	
	@Resource
	private BrandDao brandDao;

	public List<Brand> findBrands(Integer productCategoryId, int count) {
		if(count<1){
			return Collections.emptyList();
		}
		List<Brand> brands=null;
		if(productCategoryId!=null){
			brands=brandDao.findBrandList(productCategoryId, count);
		}else{
			brands=brandDao.findBrandList(1, count);
		}
		return brands;
	}

}
