package com.learn.microservices.restfulservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello")
	public String helloWorld()
	{
		return "hello world";
	}
	
	
	//hell-world/path-variable/sam
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name)
	{
		return new HelloWorldBean(String.format ("hello world, %s", name));
	}
	
	

}
