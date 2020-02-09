package dev.teamname.daos;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import dev.teamname.entities.Restaurant;
import dev.teamname.utils.HibernateUtil;

public class RestaurantDAOImpl implements RestaurantInterface{

	public Restaurant addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(restaurant);
		sess.getTransaction().commit();
		sess.close();
		return restaurant;
	}

	public Restaurant getRestaurantById(Restaurant restaurant) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		Restaurant holder = sess.get(Restaurant.class, restaurant.getrId());
		sess.close();
		return holder;
	}

	public Restaurant getRestaurantByUsername(String username) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Restaurant.class);
		crit.add(Restrictions.like("username", username));
		return (Restaurant)crit.list().get(0);
	}

	public Restaurant updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(restaurant);
		sess.getTransaction().commit();
		sess.close();
		return restaurant;
	}

	public boolean deleteRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.remove(restaurant);
		sess.getTransaction().commit();
		sess.close();
		return true;
	}

}
