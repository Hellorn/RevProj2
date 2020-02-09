package dev.teamname.daos;

import java.util.Set;

import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;

public interface MealInterface {

	//Create
	public Meal addMeal(Meal meal);
	//Read
	public Meal getMealById(Meal meal);
	public Set<Meal> getMealsByRestaurant(Restaurant restaurant);
	//Update
	public Meal updateMeal(Meal meal);
	//Delete
	public boolean deleteMeal(Meal meal);
	
	
}
