package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class TestController {

	@RequestMapping(value="/hello")
	public String getHello(){
		System.out.println("test");
		return "hello word";
	}
}
