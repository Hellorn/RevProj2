package dev.teamname.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;
@Repository
public interface MealRepo extends CrudRepository<Meal,Integer>{
	public Set<Meal> findByCaloriesLessThan(int calories);
	public Set<Meal> findByCostLessThanEqual(double cost);
	public Set<Meal> findByCuisine(String cuisine);
	//public Set<Meal> findByCuisineContains(String[] cuisines);
	//public Set<Meal> findByCuisineContains(List<String> cuisines);
	public Set<Meal> findByCaloriesLessThanEqualAndCostLessThanEqual(int calories, double cost);
	public Set<Meal> findByRestaurant(Restaurant restaurant);
	public Set<Meal> findByCuisineAndCaloriesLessThanEqualAndCostLessThanEqual(String cuisine, int calories, double cost);
	public Set<Meal> findByCuisineAndCostLessThanEqual(String cuisine, double cost);
}
