package dev.teamname.daos;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import dev.teamname.entities.Meal;
import dev.teamname.entities.Restaurant;
import dev.teamname.utils.HibernateUtil;

public class MealDAOImpl implements MealInterface {

	public Meal addMeal(Meal meal) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(meal);
		sess.getTransaction().commit();
		sess.close();
		return meal;
	}

	public Meal getMealById(Meal meal) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		Meal holder = sess.get(Meal.class, meal.getmId());
		sess.close();
		return holder;
	
		
	}

	public Set<Meal> getMealsByRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Meal.class);
		crit.add(Restrictions.like("rId", restaurant.getrId()));
		Set<Meal> meallist = new HashSet<Meal>(crit.list());
		return meallist;
	}

	public Meal updateMeal(Meal meal) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(meal);
		sess.getTransaction().commit();
		sess.close();
		return meal;
	}

	public boolean deleteMeal(Meal meal) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(meal);
		sess.getTransaction().commit();
		sess.close();
		return true;
	}

	
	
	
	
	
	
	
	
}
