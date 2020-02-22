package dev.teamname.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;
import dev.teamname.services.MealService;
import dev.teamname.services.RestaurantService;

@Component
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MealController {
	@Autowired
	MealService ms;
	@Autowired
	RestaurantService rs;
	

	@ResponseBody
	@RequestMapping(value="/addmeal", method = RequestMethod.POST)
	public Meal createMeal(@RequestBody Meal meal) {
		return ms.addMeal(meal);
		
	}
	@ResponseBody
	@RequestMapping(value="/getmealbycostandcalories")
	public Set<Meal> getMealByCostAndCalories(@RequestParam double cost, int calories) {
		return ms.getMealByCostAndCalories(cost, calories);
	}
	
	@ResponseBody
	@RequestMapping(value="/getmealsbyrestaurant",method=RequestMethod.GET)
	public Set<Meal> getMealByRestaurant(@RequestParam Restaurant restaurant){
		return ms.getMealsByRestaurant(restaurant);
	}
	
	@ResponseBody
	@RequestMapping(value="/getmealbycriteria",method=RequestMethod.GET)
	public Set<Meal> getMealByCuisineCaloriesAndCost(@RequestParam String cuisine, int calories, double cost){
		return ms.getMealByCuisineAndCostAndCalories(cuisine, calories, cost);
	}
	
	@ResponseBody
	@RequestMapping(value="/getmealbycuisine",method=RequestMethod.GET)
	public Set<Meal> getMealByCuisine(@RequestParam String cuisine){
		return ms.getMealByCuisine(cuisine);
	
	}
	
	@ResponseBody
	@RequestMapping(value="/getmealbyid",method=RequestMethod.GET)
	public Meal getMealById(@RequestParam int id){
		System.out.println("ENTERED GETMEALBYID HTTP REQUEST");
		return ms.getMealById(id);
		
	}

	@ResponseBody
	@RequestMapping(value="/getmealbyrestaurantid",method=RequestMethod.GET)
	public Set<Meal> getmealsbyrestaurantid(@RequestParam int id){
		Restaurant restaurant = rs.getRestaurantById(id);
		return getMealByRestaurant(restaurant);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/deletemeal",method=RequestMethod.DELETE)
	public boolean deleteMeal(@RequestBody Meal meal) {
		return ms.deleteMeal(meal);
	}

	@ResponseBody
	@RequestMapping(value="/getallmeals",method=RequestMethod.GET)
	public Set<Meal> getAllMeals(){
		return ms.getAllMeals();
	}
	
	
	
}
