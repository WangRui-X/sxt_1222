package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shop.core.model.FriendLink;

public interface FriendLinkDao {
	
	@Select("SELECT id, logo, name, url from xx_friend_link limit #{count}")
	List<FriendLink> findFriendLinkList(@Param("count")int count);
	
	
}
