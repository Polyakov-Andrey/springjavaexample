package com.epam.springmvcexample.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.springmvcexample.persistence.Anamnesis;
import com.epam.springmvcexample.persistence.Visit;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/18/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */

public class AnamnesisDAO extends GenericDAO<Anamnesis> {
//    @PersistenceContext(unitName="Clinic")
//    private EntityManager em;

    @Override
    Class<Anamnesis> getEntityClass() {
        return Anamnesis.class;
    }

//    public Collection<Anamnesis> findByVisit(Visit visit) {
//
//        String q = "from Anamnesis where visit = :id";
//        Query query = em.createQuery(q);
//        query.setParameter("id", visit);
//        return (Collection<Anamnesis>) query.getResultList();
//
//    }

}
