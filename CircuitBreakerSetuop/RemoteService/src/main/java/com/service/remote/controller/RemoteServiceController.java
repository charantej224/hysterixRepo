package com.service.remote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.remote.model.UserModel;

@RestController
public class RemoteServiceController {

	
	@GetMapping("/tenSecondsDelay")
	public UserModel getTenSecondsDelay() throws InterruptedException {
		Thread.sleep(10 * 1000);
		UserModel user =  new UserModel();
		user.setUserName("Something");
		user.setDelayTime("10");
		return user;
	}
	
	
	@GetMapping("/twentySecondsDelay")
	public UserModel getTwentySecondsDelay() throws InterruptedException {
		Thread.sleep(20 * 1000);
		UserModel user =  new UserModel();
		user.setUserName("Something");
		user.setDelayTime("20");
		return user;
	}
	
	
}
