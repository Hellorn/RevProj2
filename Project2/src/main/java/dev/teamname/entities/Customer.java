package dev.teamname.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="C_ID")
	private int Cid;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="CALORIES")
	private int calories;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CUSTOMER_MEAL",
	joinColumns= {@JoinColumn(name="C_ID")},inverseJoinColumns= {@JoinColumn(name="M_ID")})
	private Set<Meal> meals = new HashSet<Meal>();
	
	
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	@Override
	public String toString() {
		return "Customer [Cid=" + Cid + ", username=" + username + ", password=" + password + ", calories=" + calories
				+ "]";
	}
	public Customer() {
		super();
	}
	public Set<Meal> getMeals() {
		return meals;
	}
	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
	} 
	
	
	
	
}
