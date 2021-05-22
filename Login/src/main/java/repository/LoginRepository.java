package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Client;

@Repository
public interface LoginRepository extends JpaRepository <Client, Integer>{
	
	//create new account
	Client save(Client client);
	
	//log in
	public Client findbyEmailAndPassword(String email, String password); 
}
