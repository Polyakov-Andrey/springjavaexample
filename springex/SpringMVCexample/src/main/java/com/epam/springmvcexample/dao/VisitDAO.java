package com.epam.springmvcexample.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.springmvcexample.dao.GenericDAO;
import com.epam.springmvcexample.persistence.Anamnesis;
import com.epam.springmvcexample.persistence.Patient;
import com.epam.springmvcexample.persistence.Visit;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/18/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */


public class VisitDAO extends GenericDAO<Visit> {

    @PersistenceContext(unitName="Clinic")
    private EntityManager em;

    @Override
    Class<Visit> getEntityClass() {
        return Visit.class;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public Collection<Visit> findByPatient(Patient patient) {

        String q = "from Visit where patientByIdPat = :id";
        Query query = em.createQuery(q);
        query.setParameter("id", patient);
        return (Collection<Visit>) query.getResultList();

    }

    public Collection<Anamnesis> findByVisit(Visit v) {
        String q = "from Anamnesis where visit = :id";
        Query query = em.createQuery(q);
        query.setParameter("id", v);
        return (Collection<Anamnesis>) query.getResultList();

    }

}
