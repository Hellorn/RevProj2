package dev.teamname.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.teamname.entities.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer>{

	public Customer findByUsername(String username);
	
	
	
	
	
	
	
}
