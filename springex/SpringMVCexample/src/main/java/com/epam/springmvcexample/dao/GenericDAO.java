package com.epam.springmvcexample.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/17/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public abstract class GenericDAO<T> {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clinic");
//    EntityManager em;

	@Autowired
	private SessionFactory sessionFactory;


    public void create(T t) {
    	sessionFactory.getCurrentSession().save(t);
    }

    public Collection<T> findAll() {
    	
        Criteria criteria = sessionFactory.
        	      getCurrentSession().
        	      createCriteria(this.getEntityClass());
        	    return (Collection<T>) criteria.list();



        }





    @SuppressWarnings("unchecked")
    public T findById(long id) {

        return (T) sessionFactory.
        	      getCurrentSession().
        	      get(this.getEntityClass(), id);

    }



//    public void update(T t) {
//
//            em.merge(t);
//
//
//    }
//
//
//
//    public void delete(T t) {
//
//            em.remove(em.merge(t));
//    }


 

    abstract Class<T> getEntityClass();


}
