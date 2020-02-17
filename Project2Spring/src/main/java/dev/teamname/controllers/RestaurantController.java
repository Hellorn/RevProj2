package dev.teamname.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import dev.teamname.entities.Restaurant;
import dev.teamname.services.RestaurantService;
import pojo.loginobject;

@Component
@Controller
@CrossOrigin("http://localhost:9999")
public class RestaurantController {
	@Autowired
	RestaurantService rs;
	
	@ResponseBody
	@RequestMapping(value="/addrestaurant",method = RequestMethod.POST)
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return rs.addRestaurant(restaurant);
	}
	
	@ResponseBody
	@RequestMapping(value="/updaterestaurant",method=RequestMethod.PUT)
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
		return rs.updateRestaurant(restaurant);
	}
	
	@ResponseBody
	@RequestMapping(value="/getallrestaurants",method=RequestMethod.GET)
	public Set<Restaurant> getAllRestaurants() {
		return rs.getAllRestaurants();
	}
	
	@ResponseBody
	@RequestMapping(value="/getrestaurantsbycuisine",method=RequestMethod.GET)
	public Set<Restaurant> getRestaurantByCuisine(@RequestParam String cuisine){
		return rs.getRestaurantByCuisine(cuisine);
		
	}
	@ResponseBody
	@RequestMapping(value="/getrestaurantbyid", method=RequestMethod.GET)
	public Restaurant getRestaurantById(@RequestParam int id) {
		return rs.getRestaurantById(id);
	}
	@ResponseBody
	@RequestMapping(value="/getrestaurantbyname/query",method=RequestMethod.GET)
	public Restaurant getRestaurantByName(@RequestParam String name) {
		return rs.getRestaurantByName(name);
	}
	@ResponseBody
	@RequestMapping(value="/getrestaurantbyusername",method=RequestMethod.GET)
	public Restaurant getRestaurantByUsername(@RequestParam String username) {
		return rs.getRestaurantByUsername(username);
	}
	@ResponseBody
	@RequestMapping(value="/loginrestaurant",method=RequestMethod.POST)
	public Restaurant loginRestaurant(@RequestBody loginobject loginInfo) {
		
		return rs.login(loginInfo.getUsername(),loginInfo.getPassword());
	}
	
	
	@ResponseBody
	@RequestMapping(value="/deleterestaurant",method=RequestMethod.DELETE)
	public boolean deleteRestaurantById(@RequestBody Restaurant restaurant) {
		return rs.removeRestaurant(restaurant);
	}
	
	
	
	
}
