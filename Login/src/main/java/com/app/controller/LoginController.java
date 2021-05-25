package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Client;
import com.app.service.LoginService;

@CrossOrigin (origins = {"htpp://localhost:4200"})
@RequestMapping (path = "/login")
@RestController (value = "loginController")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping (path = "/create")
	public Client createAccount(@RequestBody Client client) {
		System.out.println(client);
		return this.loginService.createAccount(client);
	}
	
	@PostMapping (path = "/login")
	public Client login(String email, String password, HttpServletRequest request) {
		return this.loginService.login(email, password, request);
	}

}
