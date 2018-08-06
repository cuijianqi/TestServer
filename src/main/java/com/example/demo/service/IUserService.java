package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.UserPojo;

public interface IUserService {

	public UserPojo getUserInfo(int id);
	
	public List<UserPojo> getAllUserInfo();
	
	public void delUserInfo(int id);
	
}
