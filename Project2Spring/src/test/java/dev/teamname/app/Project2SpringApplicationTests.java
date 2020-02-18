package dev.teamname.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;
import dev.teamname.repositories.MealRepo;
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
	@Test
	void updateMeal() {
		Meal meal = ms.getMealById(10);
		Restaurant restaurant = rs.getRestaurantById(1);
		meal.setName("UpdatedJUnit test");
		meal.setRestaurant(rs.getRestaurantById(2));
		ms.updateMeal(meal);
		
	}
}
