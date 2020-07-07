package com.project.springdemo.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springdemo.entity.Customer;

@Repository
public class CUstomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// @Transactional // to let spring to manage start and end transaction
	// we delete @transactional when we added @Service
	@Override
	public List<Customer> getCustomers() {

		// get the current hb session

		Session currentSession = sessionFactory.getCurrentSession();

		// create query... sort by lastname

		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get the result list
		List<Customer> customers = theQuery.getResultList();

		// return the result

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// getthe current hb session

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer); // saveOrUpadte method is one of the hb magic it does itself. checks
													// if primarykey empty then save else update

		// save the customer

	}

	@Override
	public Customer getCustomer(int theId) {
		// get the current hb sesion
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve /read from db using primary key

		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hb sesion
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		
		Query theQuery= currentSession.createQuery("delete from Customer where id=:customerId");
		  	
		
				theQuery.setParameter("customerId", theId);
				theQuery.executeUpdate();
		

		
		
		
	}

}
