package com.example.demo.pojo;

public class UserPojo {

	private int id;
	private String userName;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", userName=" + userName + ", age=" + age + "]";
	}
	
}
