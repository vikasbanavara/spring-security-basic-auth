package com.ty.springsecuritybasicauth.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/message")
	public String wish() {
		return "Good morning";
	}
}
