package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value="/test")   safdas
public class TestController {

	@RequestMapping(value="/")
	public String getHello(){
		return "hello word";
	}
}
