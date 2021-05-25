package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Client;

@Repository (value = "LoginRepository")
public interface LoginRepository extends JpaRepository <Client, Integer>{
	
	//create new account
	Client save(Client client);
	
	//log in
	public Client findByEmailAndPassword(String email, String password); 
}
