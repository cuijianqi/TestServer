package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserDao;
import com.example.demo.pojo.UserPojo;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao iUserDao;
	@Override
	public UserPojo getUserInfo(int id) {
		// TODO Auto-generated method stub
		UserPojo up = new UserPojo();
		try {
			up = iUserDao.getUserInfo(id);
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("id 为："+id+"的用户信息数据库查询失败！！！");
			
			e.printStackTrace();
		}
		return up;
	}

	
}
