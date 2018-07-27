package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.UserPojo;
import com.example.demo.service.IUserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/user")
public class UserController {

	Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	@Autowired
	private IUserService iUserService;
	
	@ApiOperation(value="获取用户", notes="")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer" ,paramType="path")
	@RequestMapping(value="/userInfo/{id}")
	public String getUserInfo(@PathVariable("id") int id){
		logger.info("进入getUserInfo"+id);
		UserPojo up = iUserService.getUserInfo(id);
		logger.info(up);
		if(null==up||"".equals(up)){
			logger.info("id为"+id+"的客户信息不存在！！！");
			return "id为"+id+"的客户信息不存在！！！";
		}
		return up.toString();
	}
	
	@ApiOperation(value="获取用户列表", notes="")
	@RequestMapping(value="/allUserInfo")
	public String getAllUserInfo(){
		logger.info("进入getAllUserInfo");
		List<UserPojo> upList = iUserService.getAllUserInfo();
		logger.info(upList);
		if(null==upList||upList.size()<0){
			logger.info("客户信息不存在！！！");
			return "客户信息不存在！！！";
		}
		return upList.toString();
	}
	
	@ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer" ,paramType="path")
	@RequestMapping(value="/delUserInfo/{id}")
	public void delUserInfo(@PathVariable("id") int id){
		logger.info("进入delUserInfo"+id);
		iUserService.delUserInfo(id);
	}
}
