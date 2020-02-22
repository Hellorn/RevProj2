package dev.teamname.app;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.teamname.entities.Customer;
import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;
import dev.teamname.repositories.MealRepo;
import dev.teamname.services.CustomerService;
import dev.teamname.services.MealService;
import dev.teamname.services.RestaurantService;

@SpringBootTest
class Project2SpringApplicationTests {
//	@Autowired
//	MealRepo mr;
//	
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void getMealById() {
//		Meal meal = mr.findById(1).get();
//		System.out.println(meal);
//	};
	@Autowired
	MealService ms;
	@Autowired
	RestaurantService rs;
	@Autowired
	CustomerService cs;
	@Test
	public void getcustomerbyusername() {
	//	System.out.println(cs.login("Elie", "zer"));
		
	}
	
	@Test
	public void login() {
		Customer holder = cs.login("4rin", "tjrn");
		System.out.println(holder);
	}
	@Test
	public void successfullogin() {
		Customer holder = cs.login("Elie", "zer");
		System.out.println(holder);
	}
	@Test
	public void sucessfulrestaurantlogin() {
		Restaurant holder = rs.login("uncle", "ben");
		System.out.println(holder);
	}

	@Test 
	public void restaurantlogin() {
		Restaurant holder = rs.login("jrnjk", "etugiu5hi3uhu");
		System.out.println(holder);
	}
//	
//	@Test
//	void addMeal() {
//		
//		Meal meal = new Meal();
//		Restaurant restaurant = rs.getRestaurantById(1);
//		meal.setName("JUnitTest");
//		meal.setMid(0);
//		meal.setCalories(100);
//		meal.setCost(100);
//		meal.setRestaurant(restaurant);
//		meal.setCuisine("teiuhworignteo");
//		
//		ms.addMeal(meal);
//		System.out.println(meal);
//
//	}
//	@Test
//	void updateMeal() {
//		Meal meal = ms.getMealById(10);
//		Restaurant restaurant = rs.getRestaurantById(1);
//		meal.setName("UpdatedJUnit test");
//		meal.setRestaurant(rs.getRestaurantById(2));
//		ms.updateMeal(meal);
//		
//	}
//	@Test
//	void getRestaurantByAddress() {
//		System.out.println(rs.getRestaurantByAddress("update later"));
//	}
}
