package dev.teamname.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.teamname.entities.Customer;
import dev.teamname.entities.Restaurant;
import dev.teamname.repositories.RestaurantRepo;
import dev.teamname.services.RestaurantService;

@SpringBootTest
@Transactional
class RestaurantTests {
	@Autowired
	RestaurantService rs;
//	
//	@Test
//	void testGetRestaurantById() {
//		int id = 2;
//		int id2= 5;
//		Restaurant r1 = rs.getRestaurantById(id);
//		Restaurant r2 = rs.getRestaurantById(id2);
//		System.out.println("Test by id: " + r1);
//		System.out.println("Test by id: " + r2);
//		assertEquals(r1.getUsername(), "MacnCheese4Lyfe");
//		assertEquals(r1.getPassword(), "123");
//		assertEquals(r2.getUsername(), "Yama");
//		assertEquals(r2.getPassword(), "san");
//	}
//
//	@Test
//	void testGetRestaurantByName() {
//		String name1 = "Elevate";
//		String name2 = "Benny's pizza";
//		Restaurant r1 = rs.getRestaurantByName(name1);
//		Restaurant r2 = rs.getRestaurantByName(name2);
//		System.out.println("Test by name " + r1);
//		System.out.println("Test by name " + r2);
//		assertEquals(r1.getUsername(), "Beef");
//		assertEquals(r1.getPassword(), "steak");
//		assertEquals(r2.getUsername(), "uncle");
//		assertEquals(r2.getPassword(), "ben");
//	}
//
//	@Test
//	void testGetRestaurantByUsername() {
//		String user1 = "Yama";
//		String user2 = "Beef";
//		Restaurant r1 = rs.getRestaurantByUsername(user1);
//		Restaurant r2 = rs.getRestaurantByUsername(user2);
//		System.out.println("Test by username " + r1);
//		System.out.println("Test by username " + r2);
//		assertEquals(r1.getName(), "Yama's");
//		assertEquals(r1.getCuisine(), "Japanese");
//		assertEquals(r2.getName(), "Elevate");
//		assertEquals(r2.getCuisine(), "Japanese");
//	}
//
//	@Test
//	void testLogin() {
//		int id1 = 5, id2 = 9;
//		String user1 = "Yama", pass1 = "san";
//		String user2 = "Beef", pass2 = "steak";
//		Restaurant r1 = rs.login(user1, pass1);
//		Restaurant r2 = rs.login(user2, pass2);
//		assertEquals(r1.getRid(), id1);
//		assertEquals(r2.getRid(), id2);
//	}
//
//	@Test
//	void testAddRestaurant() {
//		Restaurant r1 = new Restaurant();
//		Restaurant r2 = new Restaurant();
//		r1.setName("Steam Dream");
//		r1.setUsername("Cloudy");
//		r1.setPassword("rainy");
//		r1.setCuisine("Health");
//		r2.setName("Tasty Test");
//		r2.setUsername("Spaghetti");
//		r2.setPassword("meatballs");
//		
//		Restaurant new1 = rs.addRestaurant(r1);
//		Restaurant new2 = rs.addRestaurant(r2);
//		assertTrue(r1.getRid() > 0);
//		assertEquals(new1.getUsername(), r1.getUsername());
//		assertEquals(new1.getPassword(), r1.getPassword());
//		assertEquals(new2.getUsername(), r2.getUsername());
//		assertEquals(new2.getPassword(), r2.getPassword());
//	}
//
//	@Test
//	void testRemoveRestaurant() {
//		Restaurant r1 = new Restaurant();
//		Restaurant r2 = new Restaurant();
//		Restaurant r3 = new Restaurant();
//		r1.setRid(1);
//		r2.setRid(8);
//		r3.setRid(10);
//		assertTrue(rs.removeRestaurant(r1));
//		assertTrue(rs.removeRestaurant(r2));
//		assertTrue(rs.removeRestaurant(r3));
//	}
//
//	@Test
//	void testUpdateRestaurant() {
//		Restaurant r1 = new Restaurant();
//		Restaurant r2 = new Restaurant();
//		r1.setName("Steam Dream");
//		r1.setUsername("Cloudy");
//		r1.setPassword("rainy");
//		r1.setCuisine("Health");
//		r2.setName("Tasty Test");
//		r2.setUsername("Spaghetti");
//		r2.setPassword("meatballs");
//		
//		Restaurant new1 = rs.updateRestaurant(r1);
//		Restaurant new2 = rs.updateRestaurant(r2);
//		assertTrue(r1.getRid() > 0);
//		assertEquals(new1.getUsername(), r1.getUsername());
//		assertEquals(new1.getPassword(), r1.getPassword());
//		assertEquals(new2.getUsername(), r2.getUsername());
//		assertEquals(new2.getPassword(), r2.getPassword());
//	}
//
//	@Test
//	void testGetAllRestaurants() {
//		Set<Restaurant> r1 = rs.getAllRestaurants();
//		assertTrue(r1 != null && r1.size() > 0);
//		System.out.println("Number of restaurants: " + r1.size());
//		System.out.println(r1);
//	}
//
//	@Test
//	void testGetRestaurantByCuisine() {
//		String cui1= "American";
//		String cui2 = "Japanese";
//		Set<Restaurant> r1 = rs.getRestaurantByCuisine(cui1);
//		Set<Restaurant> r2 = rs.getRestaurantByCuisine(cui2);
//		
//		System.out.println("Test by cuisine " + r1);
//		System.out.println("Test by cuisine " + r2);
//		assertTrue(r1.size() > 0);
//		assertTrue(r2.size() > 0);
//	}
//
//	@Test
//	void testGetRestaurantByAddress() {
//		String add1 = "458 High St, Morgantown, WV 26505";
//		String add2 = "500 Koehler Drive";
//		try {
//		Restaurant r1 = rs.getRestaurantByAddress(add1);
//		assertTrue(r1.getRid() == 3);
//		System.out.println("Test by address: " + r1);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//		Restaurant r2 = rs.getRestaurantByAddress(add2);
//		assertTrue(r2.getRid() == 9);
//		System.out.println("Test by address: " + r2);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}

}
