package com.example.demo.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserDao;
import com.example.demo.pojo.UserPojo;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
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
			
			logger.error("id 为："+id+"的用户信息数据库查询失败！！！");
			
			e.printStackTrace();
		}
		return up;
	}
	@Override
	public List<UserPojo> getAllUserInfo() {
		// TODO Auto-generated method stub
		List<UserPojo> userList = iUserDao.getAllUserInfo();
		return userList;
	}
	@Override
	public void delUserInfo(int id) {
		// TODO Auto-generated method stub
		iUserDao.delUserInfo(id);
	}
	
}
