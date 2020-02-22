package dev.teamname.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.teamname.entities.Customer;
import dev.teamname.entities.Meal;
import dev.teamname.repositories.CustomerRepo;

@Component
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo cr;
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
		
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return cr.findByUsername(username);
	}

	@Override
	public Customer login(String username, String password) {
		// TODO Auto-generated method stub
		Customer holder = cr.findByUsername(username);
		
		if(holder != null) {
			if(holder.getPassword().contentEquals(password)) {
				return holder;
				}
			
			return null;
		}
		else {
			return null;
		}
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cr.save(customer);
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer);
		cr.delete(customer);
		
		if(!cr.findById(customer.getCid()).isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return cr.save(customer);
	}

	@Override
	public Meal addMealToHistory(Customer customer, Meal meal) {
		// TODO Auto-generated method stub
		//NOTE: NOT SURE IF NEEDED OR IF CAN BE DONE IN CONTROLLER
		return null;
	}

}
