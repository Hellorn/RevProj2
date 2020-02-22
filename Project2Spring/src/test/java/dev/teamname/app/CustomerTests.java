package dev.teamname.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import dev.teamname.entities.Customer;
import dev.teamname.repositories.CustomerRepo;
import dev.teamname.services.CustomerService;
import dev.teamname.services.CustomerServiceImpl;

@SpringBootTest
@Transactional
class CustomerTests {
//	@Autowired
//	CustomerRepo cr;
//	
//	@Autowired
//	CustomerService cs;
//
//	@Test
//	void testGetCustomerById() {
//		int id = 2;
//		int id2= 6;
//		Customer c = cr.findById(id).get();
//		Customer c2= cr.findById(id2).get(); 
//		assertEquals(c.getUsername(),"Elie");
//		assertEquals(c.getPassword(),"zer");
//		assertEquals(c2.getUsername(),"Rica");
//		assertEquals(c2.getPassword(),"rdo");
//		
//	}
//
//	@Test
//	void testGetCustomerByUsername() {
//		String un1 = "Elie";
//		String un2 = "Rica";
//		
//		Customer c1 = cr.findByUsername(un1);
//		Customer c2 = cr.findByUsername(un2);
//		assertEquals(c1.getCid(), 2);
//		assertEquals(c1.getPassword(), "zer");
//		assertEquals(c2.getCid(), 6);
//		assertEquals(c2.getPassword(), "rdo");
//	}
//
//	@Test
//	void testLogin() {
//		int id1 = 2, id2 = 6;
//		String user1 = "Elie", pass1 = "zer";
//		String user2 = "Rica", pass2 = "rdo";
//		Customer c1 = cs.login(user1, pass1);
//		Customer c2 = cs.login(user2, pass2);
//		assertEquals(c1.getCid(), id1);
//		assertEquals(c2.getCid(), id2);
//	}
//
//	@Test
//	void testAddCustomer() {
//		Customer c1 = new Customer();
//		Customer c2 = new Customer();
//		c1.setUsername("Sa");
//		c1.setPassword("rah");
//		c2.setUsername("Ste");
//		c2.setPassword("vens");
//		
//		Customer new1 = cs.addCustomer(c1);
//		Customer new2 = cs.addCustomer(c2);
//		
//		assertEquals(new1.getUsername(), c1.getUsername());
//		assertEquals(new1.getPassword(), c1.getPassword());
//		assertEquals(new2.getUsername(), c2.getUsername());
//		assertEquals(new2.getPassword(), c2.getPassword());
//		System.out.println(new1);
//		System.out.println(new2);
//	}
//
//	@Test
//	void testDeleteCustomer() {
//		Customer c1 = new Customer();
//		Customer c2 = new Customer();
//		Customer c3 = new Customer();
//		c1.setCid(2);
//		c2.setCid(6);
//		c3.setCid(10);
//		assertTrue(cs.deleteCustomer(c1));
//		assertTrue(cs.deleteCustomer(c2));
//		assertTrue(cs.deleteCustomer(c3));
//	}
//
//	@Test
//	void testUpdateCustomer() {
//		Customer c1 = new Customer();
//		Customer c2 = new Customer();
//		c1.setUsername("Sa");
//		c1.setPassword("rah");
//		c2.setUsername("Ste");
//		c2.setPassword("vens");
//		
//		Customer new1 = cs.updateCustomer(c1);
//		Customer new2 = cs.updateCustomer(c2);
//		
//		assertEquals(new1.getUsername(), c1.getUsername());
//		assertEquals(new1.getPassword(), c1.getPassword());
//		assertEquals(new2.getUsername(), c2.getUsername());
//		assertEquals(new2.getPassword(), c2.getPassword());
//		System.out.println(new1);
//		System.out.println(new2);
//	}
//
//	

}
