package com.epam.springmvcexample.dao;

import com.epam.springmvcexample.persistence.Doctor;




/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/18/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public class DoctorDAO extends GenericDAO<Doctor> {
    @Override
    Class<Doctor> getEntityClass() {
        return Doctor.class;
    }
}
