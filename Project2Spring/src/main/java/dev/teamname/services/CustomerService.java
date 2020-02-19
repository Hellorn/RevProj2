package dev.teamname.services;

import dev.teamname.entities.Customer;
import dev.teamname.entities.Meal;

public interface CustomerService {

	public Customer getCustomerById(int id);
	public Customer getCustomerByUsername(String username);
	public Customer login(String username, String password);
	public Customer addCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Meal addMealToHistory(Customer customer, Meal meal);
	
	
	
}
