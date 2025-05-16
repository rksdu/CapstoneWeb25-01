package com.example.capstoneWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
