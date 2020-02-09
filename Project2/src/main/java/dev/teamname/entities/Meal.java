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
@Table(name="MEAL")
public class Meal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="M_ID")
	private int mId;
	@Column(name="NAME")
	private String name;
	@Column(name="CALORIES")
	private int calories;
	@Column(name="CUISINE")
	private String cuisine;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "R_ID")
	private Restaurant restaurant;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
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
	@Override
	public String toString() {
		return "Meal [mId=" + mId + ", name=" + name + ", calories=" + calories + ", cuisine=" + cuisine + "]";
	}
	public Meal() {
		super();
	}
	
	
	
	
	
	
}
