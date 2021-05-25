package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "client", schema = "zoo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	@Id
	@Column (name = "id", nullable = false)
	private int id;
	
	@Column (name = "first_name")
	private String firstName;
	
	@Column (name = "last_name")
	private String lastName;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "password")
	private String password;
	
}
