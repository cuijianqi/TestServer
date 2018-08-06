package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.UserPojo;

//@Repository
public interface IUserDao {

	UserPojo getUserInfo(int id);
	
	List<UserPojo> getAllUserInfo();
	
	void delUserInfo(int id);
	
}
