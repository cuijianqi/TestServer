package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.UserPojo;

//@Repository
public interface IUserDao {

	UserPojo getUserInfo(int id);
}
