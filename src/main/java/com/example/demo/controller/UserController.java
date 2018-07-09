package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.UserPojo;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IUserService iUserService;
	@RequestMapping(value="/userInfo/{id}")
	public String getUserInfo(@PathVariable("id") int id){
		UserPojo up = iUserService.getUserInfo(id);
		if(null==up||"".equals(up)){
			return "id为"+id+"的客户信息不存在！！！";
		}
		return up.toString();
	}
}
