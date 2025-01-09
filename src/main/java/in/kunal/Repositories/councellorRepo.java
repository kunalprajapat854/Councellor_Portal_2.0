package in.kunal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entities.Councellor;

public interface  councellorRepo extends JpaRepository<Councellor, Integer> {
	
// SELECT email, password FROM Councellor WHERE email:= email AND password:= password
	public Councellor findByNameAndPassword(String email, String password);

}
