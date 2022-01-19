package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class micro1 {
	@GetMapping("/micro1")
	public String helloworld() {
		return "hello micro1";
	}
}
