package dev.teamname.daos;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import dev.teamname.entities.Customer;
import dev.teamname.entities.Meal;
import dev.teamname.utils.HibernateUtil;

public class CustomerDAOImpl implements CustomerInterface {

	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(customer);
		sess.getTransaction().commit();
		sess.close();
		return customer;
		
	}

	public Customer getCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		Customer holder = sess.get(Customer.class, customer.getCid());
		return holder;
	}

	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Customer.class);
		crit.add(Restrictions.like("username", username));
		return (Customer)crit.list().get(0);
	}

	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(customer);
		sess.getTransaction().commit();
		sess.close();
		return customer;
	}

	public boolean removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(customer);
		sess.getTransaction().commit();
		sess.close();
		return true;
	}

	
	
	
	
	
	
	
	
}
