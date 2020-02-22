package dev.teamname.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.teamname.entities.Customer;
import dev.teamname.services.CustomerService;
import pojo.loginobject;
@Component
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	CustomerService cs;

	@ResponseBody
	@RequestMapping(value="/addcustomer",method=RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) {
		return cs.addCustomer(customer);
	}

	@ResponseBody
	@RequestMapping(value="/getcustomer",method=RequestMethod.GET)
	public Customer getCustomerById(@RequestParam int id) {
		return cs.getCustomerById(id);
	}

	@ResponseBody
	@RequestMapping(value="/getcustomerbyusername",method=RequestMethod.GET)
	public Customer getCustomerByUsername(@RequestParam String username) {
		return cs.getCustomerByUsername(username);
	}

	@ResponseBody
	@RequestMapping(value="/logincustomer",method=RequestMethod.POST)
	public Customer login(@RequestBody loginobject loginInfo) {
		Customer holder = cs.login(loginInfo.getUsername(), loginInfo.getPassword());
		
		return cs.login(loginInfo.getUsername(),loginInfo.getPassword());
	}
	
	@ResponseBody
	@RequestMapping(value="/updatecustomer",method=RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return cs.updateCustomer(customer);
	}
	
	@ResponseBody
	@RequestMapping(value="/deletecustomer",method=RequestMethod.DELETE)
	public boolean deleteCustomer(@RequestBody Customer customer) {
		return cs.deleteCustomer(customer);
		
	}
	
	public Customer addMealToHistory(Customer customer) {
		//NEEDS TO BE WORKED ON.
		return null;
	}
	
	
}
