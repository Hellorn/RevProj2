package dev.teamname.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;
import dev.teamname.repositories.MealRepo;

@Component
@Service
public class MealServiceImpl implements MealService {
	@Autowired
	MealRepo mr;
	
	@Override
	public Meal addMeal(Meal meal) {
		// TODO Auto-generated method stub
		return mr.save(meal);
	}

	@Override
	public Meal updateMeal(Meal meal) {
		// TODO Auto-generated method stub
		return mr.save(meal);
	}

	@Override
	public Meal getMealById(int id) {
		// TODO Auto-generated method stub
		return mr.findById(id).get();
	}

	@Override
	public Set<Meal> getMealsLessThanCalorie(int Calories) {
		// TODO Auto-generated method stub
		return mr.findByCaloriesLessThan(Calories);
	}

	@Override
	public Set<Meal> getMealsByRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return mr.findByRestaurant(restaurant);
	}

	@Override
	public Set<Meal> getMealByCuisine(String cuisine) {
		// TODO Auto-generated method stub
		return mr.findByCuisine(cuisine);
	}
	

	@Override
	public Set<Meal> getMealByCuisineAndCost(String cuisine, double cost) {
		// TODO Auto-generated method stub
		return mr.findByCuisineAndCostLessThanEqual(cuisine, cost);
	}

	@Override
	public boolean deleteMeal(Meal meal) {
		// TODO Auto-generated method stub
		mr.delete(meal);
		if(!mr.findById(meal.getMid()).isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Set<Meal> getMealByCuisineAndCostAndCalories(String cuisine, int calories, double cost) {
		// TODO Auto-generated method stub
		return mr.findByCuisineAndCaloriesLessThanEqualAndCostLessThanEqual(cuisine, calories, cost);
	}

	@Override
	public Set<Meal> getAllMeals() {
		// TODO Auto-generated method stub
		return new HashSet<Meal>((Collection<? extends Meal>) mr.findAll());
	}

}
