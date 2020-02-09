package dev.teamname.daos;

import dev.teamname.entities.Restaurant;

public interface RestaurantInterface {
	
	//CRUD
	//CREATE
	public Restaurant addRestaurant(Restaurant restaurant);
	//READ
	public Restaurant getRestaurantById(Restaurant restaurant);
	public Restaurant getRestaurantByUsername(String username);
	//UPDATE
	public Restaurant updateRestaurant(Restaurant restaurant);
	//DELETE
	public boolean deleteRestaurant(Restaurant restaurant);
	
	
	
}
