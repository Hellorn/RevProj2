package dev.teamname.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.teamname.entities.Restaurant;
import dev.teamname.repositories.RestaurantRepo;
@Component
@Service
public class RestaurantServiceImpl implements RestaurantService{
	@Autowired
	RestaurantRepo rr;
	@Override
	public Restaurant getRestaurantById(int id) {
		// TODO Auto-generated method stub
		return rr.findById(id).get();
	}

	@Override
	public Restaurant getRestaurantByName(String name) {
		// TODO Auto-generated method stub
		return rr.findByName(name);
	}

	@Override
	public Restaurant getRestaurantByUsername(String username) {
		// TODO Auto-generated method stub
		return rr.findByUsername(username);
	}

	@Override
	public Restaurant login(String username, String password) {
		// TODO Auto-generated method stub
		Restaurant holder =  rr.findByUsername(username);
		if(holder.getPassword().contentEquals(password)) {
			return holder;
		}
		else {
			return null;
		}
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return rr.save(restaurant);
	
	}

	@Override
	public boolean removeRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		rr.delete(restaurant);
		if(!rr.findById(restaurant.getRid()).isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return rr.save(restaurant);
	}

	@Override
	public Set<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		Set<Restaurant> restaurants = new HashSet<Restaurant>((Collection<? extends Restaurant>) rr.findAll());
		return restaurants;
	}

	@Override
	public Set<Restaurant> getRestaurantByCuisine(String cuisine) {
		// TODO Auto-generated method stub
		return rr.findByCuisine(cuisine);
	}

	@Override
	public Restaurant getRestaurantByAddress(String address) {
		// TODO Auto-generated method stub
		return rr.findByAddress(address);
	}

}
