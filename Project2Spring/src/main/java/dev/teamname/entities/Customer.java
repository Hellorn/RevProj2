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
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="C_ID")
	private int cid;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="customermeal",
	joinColumns= {@JoinColumn(name="C_ID")},inverseJoinColumns= {@JoinColumn(name="M_ID")})
	private Set<Meal> meals = new HashSet<Meal>();
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", username=" + username + ", password=" + password + "]";
	}
	public Customer() {
		super();
	}
	
	
	
	
	
	
	
	
}
