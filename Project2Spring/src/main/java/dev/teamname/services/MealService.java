package dev.teamname.services;

import java.util.List;
import java.util.Set;

import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;

public interface MealService {

	public Meal addMeal(Meal meal);
	public Meal updateMeal(Meal meal);
	public Meal getMealById(int id);
	public Set<Meal> getMealsLessThanCalorie(int Calories);
	public Set<Meal> getMealsByRestaurant(Restaurant restaurant);
	public Set<Meal> getMealByCuisine(String cuisine);
	public Set<Meal> getMealByCuisineAndCost(String cuisine, double cost);
	public Set<Meal> getMealByCuisineAndCostAndCalories(String cuisine, int calories, double cost);
	public Set<Meal> getAllMeals();
	public boolean deleteMeal(Meal meal);
	
	
	
	
}
