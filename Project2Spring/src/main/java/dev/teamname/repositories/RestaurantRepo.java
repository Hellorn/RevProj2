package dev.teamname.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.teamname.entities.Restaurant;
@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant,Integer>{

	
	public Restaurant findByName(String name);
	public Restaurant findByUsername(String username);
	public Set<Restaurant> findByCuisine(String cuisine);
	
}
