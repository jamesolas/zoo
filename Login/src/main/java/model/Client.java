package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "client")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	@Id
	@Column (name = "clientid", nullable = false)
	private int clientId;
	
	@Column (name = "client_fist_name")
	private String clientFirstName;
	
	@Column (name = "client_last_name")
	private String clientLastName;
	
	@Column (name = "client_email")
	private String clientEmail;
	
	@Column (name = "client_password")
	private String clientPassword;
	
}
