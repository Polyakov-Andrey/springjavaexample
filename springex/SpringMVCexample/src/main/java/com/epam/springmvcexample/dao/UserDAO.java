package com.epam.springmvcexample.dao;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.springmvcexample.persistence.User;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 7/15/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */


public class UserDAO extends GenericDAO<User>{

//    @PersistenceContext(unitName="Clinic")
//    private EntityManager em;

    @Override
    Class<User> getEntityClass() {
        return User.class;
    }

//    public User findByName(String name){
//    	try{
//        String q = "from User where userName = :id";
//        Query query = em.createQuery(q);
//        query.setParameter("id", name);
//        return (User) query.getSingleResult();}
//    	catch (NoResultException e) {
//    		return null;
//    	}
//
//    }



}
