package dev.teamname.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;
import dev.teamname.services.MealService;
import dev.teamname.services.RestaurantService;

@SpringBootTest
@Transactional
class MealTests {
	@Autowired
	MealService ms;
	@Autowired
	RestaurantService rs;
	
	@Test
	void testAddMeal() {
		Restaurant r1 = new Restaurant();
		r1 = rs.getRestaurantById(3);
		Meal m1 = new Meal();
		Meal m2 = new Meal();
		m1.setRestaurant(r1);
		m1.setName("Cookie");
		m1.setCalories(300);
		m1.setCost(2.5);
		m2.setRestaurant(r1);
		m2.setName("Ravioli");
		m2.setCalories(800);
		m2.setCost(8.5);
		m2.setCuisine("Italian");
		m1 = ms.addMeal(m1);
		m2 = ms.addMeal(m2);
		assert(m1.getMid() > 0);
		assert(m2.getMid() > 0);
		System.out.println("New entry " + m1);
		System.out.println("New entry " + m2);
	}

	@Test
	void testUpdateMeal() {
		Restaurant r1 = new Restaurant();
		r1 = rs.getRestaurantById(3);
		Meal m1 = new Meal();
		Meal m2 = new Meal();
		m1.setRestaurant(r1);
		m1.setName("Cookie");
		m1.setCalories(300);
		m1.setCost(2.5);
		m2.setRestaurant(r1);
		m2.setName("Ravioli");
		m2.setCalories(800);
		m2.setCost(8.5);
		m2.setCuisine("Italian");
		m1 = ms.updateMeal(m1);
		m2 = ms.updateMeal(m2);
		assert(m1.getMid() > 0);
		assert(m2.getMid() > 0);
		System.out.println("New entry " + m1);
		System.out.println("New entry " + m2);
	}

	@Test
	void testGetMealById() {
		int id1 = 13;
		int id2 = 2;
		int id3 = 3;
		Meal m1 = ms.getMealById(id1);
		Meal m2 = ms.getMealById(id2);
		Meal m3 = ms.getMealById(id3);
		System.out.println("Meal by id: " + m1);
		System.out.println("Meal by id: " + m2);
		System.out.println("Meal by id: " + m3);
		assertEquals(m1.getName(), "Salisbury Steak");
		assertEquals(m2.getName(), "Sushi");
		assertEquals(m3.getName(), "Gioza");
	}

	@Test
	void testGetMealsLessThanCalorie() {
		int cal1 = 10;
		int cal2 = 300;
		int cal3 = 2400;
		Set<Meal> m1 = ms.getMealsLessThanCalorie(cal1);
		Set<Meal> m2 = ms.getMealsLessThanCalorie(cal2);
		Set<Meal> m3 = ms.getMealsLessThanCalorie(cal3);
		assert(m1 != null && m1.size() > 0);
		assert(m2 != null && m2.size() > 0);
		assert(m3 != null && m3.size() > 0);
		System.out.println("Meals less than " + cal1 + " cals (" + m1.size() + " found): " + m1);
		System.out.println("Meals less than " + cal2 + " cals (" + m2.size() + " found): " + m2);
		System.out.println("Meals less than " + cal3 + " cals (" + m3.size() + " found): " + m3);

	}

	@Test
	void testGetMealsByRestaurant() {
		Restaurant r1 = rs.getRestaurantById(5);
		Restaurant r2 = rs.getRestaurantById(9);
		Set<Meal> meals1 = ms.getMealsByRestaurant(r1);
		Set<Meal> meals2 = ms.getMealsByRestaurant(r2);
		assert(meals1 != null && meals1.size() > 0);
		assert(meals2 != null && meals2.size() > 0);
		System.out.println(meals1.size() + " Meals found for " + r1.getName() 
					+ " Restaurant: " + meals1);
		System.out.println(meals2.size() + " Meals found for " + r2.getName()
					+ " Restaurant: " + meals2);
	}

	@Test
	void testGetMealByCuisine() {
		String cui1 = "Japanese";
		String cui2 = "Mexican";
		String cui3 = "";
		Set<Meal> m1 = ms.getMealByCuisine(cui1);
		Set<Meal> m2 = ms.getMealByCuisine(cui2);
		Set<Meal> m3 = ms.getMealByCuisine(cui3);
		
		assert(m1 != null && m1.size() > 0);
		assert(m2 != null && m2.size() > 0);
		assert(m3 != null && m3.size() > 0);
		System.out.println("Meals of '" + cui1 + "' cuisine (" + m1.size() + " found): " + m1);
		System.out.println("Meals of '" + cui2 + "' cuisine (" + m2.size() + " found): " + m2);
		System.out.println("Meals of '" + cui3 + "' cuisine (" + m3.size() + " found): " + m3);
	}

	@Test
	void testGetMealByCuisineAndCost() {
		String cui1 = "Japanese", cui2 = "Mexican", cui3 = "";
		double cost1 = 20, cost2 = 123, cost3 = 1;
		Set<Meal> m1 = ms.getMealByCuisineAndCost(cui1, cost1);
		Set<Meal> m2 = ms.getMealByCuisineAndCost(cui2, cost2);
		Set<Meal> m3 = ms.getMealByCuisineAndCost(cui3, cost3);
		
		assert(m1 != null && m1.size() > 0);
		assert(m2 != null && m2.size() > 0);
		assert(m3 != null && m3.size() > 0);
		System.out.println("Meals of '" + cui1 + "' cuisine costing $" + cost1 + " (" + m1.size() + " found): " + m1);
		System.out.println("Meals of '" + cui2 + "' cuisine costing $" + cost2 + " (" + m2.size() + " found): " + m2);
		System.out.println("Meals of '" + cui3 + "' cuisine costing $" + cost3 + " (" + m3.size() + " found): " + m3);
	}

	@Test
	void testDeleteMeal() {
		Meal m1 = new Meal();
		Meal m2 = new Meal();
		Meal m3 = new Meal();
		m1.setMid(17);
		m2.setMid(23);
		m3.setMid(27);
		assert(ms.deleteMeal(m1));
		assert(ms.deleteMeal(m2));
		assert(ms.deleteMeal(m3));
	}

	@Test
	void testGetMealByCuisineAndCostAndCalories() {
		String cui1 = "Japanese", cui2 = "";
		double cost1 = 20, cost2 = 1;
		int cal1 = 2000, cal2 = 1;
		Set<Meal> m1 = ms.getMealByCuisineAndCostAndCalories(cui1, cal1, cost1);
		Set<Meal> m2 = ms.getMealByCuisineAndCostAndCalories(cui2, cal2, cost2);
		
		assert(m1 != null && m1.size() > 0);
		assert(m2 != null && m2.size() > 0);
		System.out.println("Meals of '" + cui1 + "' cuisine with "
				+ cal1 + " calorie" + (cal1 == 1 ? "" : "s") + ", costing $"
				+ cost1 + " (" + m1.size() + " found): " + m1);
		System.out.println("Meals of '" + cui2 + "' cuisine with "
				+ cal2 + " calorie" + (cal2 == 1 ? "" : "s") + ", costing $"
				+ cost2 + " (" + m2.size() + " found): " + m2);
	}

	@Test
	void testGetAllMeals() {
		Set<Meal> meallist = ms.getAllMeals();
		assert(meallist != null && meallist.size() > 0);
		System.out.println("All meals (" + meallist.size() + ") found: " + meallist);
	}

}
