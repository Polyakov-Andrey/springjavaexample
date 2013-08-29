package com.epam.springmvcexample.dao;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.springmvcexample.persistence.Anamnesis;
import com.epam.springmvcexample.persistence.Patient;

import persistence.Payment;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/18/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */

public class PaymentDAO extends GenericDAO<Payment> {


    @PersistenceContext(unitName="Clinic")
    private EntityManager em;

    @Override
    Class<Payment> getEntityClass() {
        return Payment.class;
    }

    public Collection<Payment> findByPatient(Patient patient) {
        String q = "from Payment where patient = :id";
        Query query = em.createQuery(q);
        query.setParameter("id", patient);
        return (Collection<Payment>) query.getResultList();

    }

    public Collection<Payment> findByAnam(Anamnesis anamnesis) {
        String q = "from Payment where anamnesis = :id";
        Query query = em.createQuery(q);
        query.setParameter("id", anamnesis);
        return (Collection<Payment>) query.getResultList();

    }

    public Collection<Payment> findPending() {
        String q = "from Payment where paid = null";
        Query query = em.createQuery(q);
        return (Collection<Payment>) query.getResultList();

    }
}
