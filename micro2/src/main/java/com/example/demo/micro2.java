package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class micro2 {
	@GetMapping("/micro2")
	public String helloworld() {
		return "hello micro2";
	}	
}
