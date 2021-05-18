package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Client;

@Repository
public interface LoginRepository extends JpaRepository <Client, Integer>{
	Client save(Client client);
}
