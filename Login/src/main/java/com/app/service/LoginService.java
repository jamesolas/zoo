package com.app.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Client;
import com.app.repository.LoginRepository;

@Service (value = "LoginService")
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public Client createAccount(Client client) {
		return this.loginRepository.save(client);
	}
	
	public Client login(String email, String password, HttpServletRequest request) {
		Client client= this.loginRepository.findByEmailAndPassword(email, password);
		if(client != null) {
			HttpSession session = request.getSession();
			session.setAttribute("client", client);
			return client;
		}else {
			return null;
		}
	}
	
}
