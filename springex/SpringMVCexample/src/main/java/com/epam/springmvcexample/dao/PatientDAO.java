package com.epam.springmvcexample.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.springmvcexample.persistence.Patient;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/17/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */

public class PatientDAO extends GenericDAO<Patient> {
	
    @PersistenceContext(unitName="Clinic")
    private EntityManager em;


    @Override
    Class<Patient> getEntityClass() {
        return Patient.class;  //To change body of implemented methods use File | Settings | File Templates.
    }
    
    
    public Patient findByInsurance(String name){
        String q = "from Patient where insuranceId = :id";
        Query query = em.createQuery(q);
        query.setParameter("id", name);
        
        return (Patient) query.getSingleResult();

    }
    
    
    
}
