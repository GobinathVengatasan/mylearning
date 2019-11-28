package com.ing.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class AccountServiceController {

	@GetMapping("/account")
	public String welcome() {		
		return "Gobinath V";
	}

}
