package dev.teamname.daos;

import dev.teamname.entities.Customer;

public interface CustomerInterface {

	//CRUD
	
	//CREATE
	public Customer addCustomer(Customer customer);
	
	
	//READ
	public Customer getCustomerById(Customer customer);
	public Customer getCustomerByUsername(String username);
	//UPDATE
	public Customer updateCustomer(Customer customer);
	//DELETE
	public boolean removeCustomer(Customer customer);
	
	
	
	
}
