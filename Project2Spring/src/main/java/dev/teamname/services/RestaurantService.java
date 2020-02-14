package dev.teamname.services;


import java.util.Set;

import dev.teamname.entities.Restaurant;

public interface RestaurantService  {

	public Restaurant getRestaurantById(int id);
	public Restaurant getRestaurantByName(String name);
	public Restaurant getRestaurantByUsername(String username);
	public Set<Restaurant> getAllRestaurants();
	public Set<Restaurant> getRestaurantByCuisine(String cuisine);
	public Restaurant login(String username, String password);
	public Restaurant addRestaurant(Restaurant restaurant);
	public boolean removeRestaurant(Restaurant restaurant);
	public Restaurant updateRestaurant(Restaurant restaurant);
	
	
}
