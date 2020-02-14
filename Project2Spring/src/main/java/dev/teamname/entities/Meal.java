package dev.teamname.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="meal")
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="M_ID")
	private int mid;
	@Column(name="NAME")
	private String name;
	@Column(name="CALORIES")
	private int calories;
	@Column(name="CUISINE")
	private String cuisine;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "R_ID")
	private Restaurant restaurant;
	@Column(name="COST")
	private double cost;
	
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Meal() {
		super();
	}
	@Override
	public String toString() {
		return "Meal [mid=" + mid + ", name=" + name + ", calories=" + calories + ", cuisine=" + cuisine
				+ ", restaurant=" + restaurant.getName() + ", cost=" + cost + "]";
	}
	
	
	
}
