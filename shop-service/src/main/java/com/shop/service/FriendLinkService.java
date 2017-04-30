package com.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.FriendLink;
import com.shop.dao.FriendLinkDao;

@Service
public class FriendLinkService {
	
	@Resource
	private FriendLinkDao friendLinkDao;
	
	public List<FriendLink> findFriendLinkList(int count) {
		List<FriendLink> friendLinks=friendLinkDao.findFriendLinkList(count);
		return friendLinks;
	}
}
