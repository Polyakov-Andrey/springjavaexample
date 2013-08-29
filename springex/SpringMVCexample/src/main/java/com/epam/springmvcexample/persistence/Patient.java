package com.epam.springmvcexample.persistence;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/17/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "PATIENT", schema = "NICK_T", catalog = "")
@Entity
@XmlRootElement(name = "patient")
public class Patient {



    @Id
    @Column(name = "ID_PAT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
//    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_PAT_SEQ", allocationSize=1)
     private long idPat;

    @Column(name = "INSURANCE_ID")
    private String insuranceId;


    @Column(name = "NAME_PATIENT")
    private String namePatient;

    @Column(name = "GENDER")
    private boolean gender;

    @Column(name = "DATE_BIRTH")
    private Date dateBirth;

    @Column(name = "DATE_REGISTRATION")
    private Date dateRegistration;


    @Column(name = "SOCIAL")
    private int social;

    @Column(name = "SOCIAL_ORDER")
    private String order;

    @XmlTransient
    @OneToMany(mappedBy = "patientByIdPat", fetch = FetchType.EAGER)
    private Collection<Visit> visits;

    @XmlTransient
    @OneToMany(mappedBy = "patient")
    private Collection<Payment> bills;


    public Patient(String insuranceId){
        this.insuranceId = insuranceId;
    };

    public Patient() {
        java.util.Date date= new java.util.Date();
       // dateBirth = new Timestamp(date.getTime());
       // dateRegistration = new Timestamp(date.getTime());
    }


    public long getIdPat() {
        return idPat;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId ) {
        this.insuranceId = insuranceId;
    }


    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }


//    public boolean isGender() {
//        return gender;
//    }

    public String getGender() {
        return gender?"F":"M";
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public Date getDateBirth() {
        return dateBirth;
    }



    public void setDateBirth(Date dateBirth) {

        this.dateBirth = dateBirth;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {

        this.dateRegistration = dateRegistration;
    }



    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    /*
    *
    * As for this particular entity, the best way is to implement equality is to make a check by business key
    * (e.g. medical insurance number)
    *
    * */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient that = (Patient) o;
        if (insuranceId != that.insuranceId) return false;
    //
    /*    if (idPat != that.idPat) return false;


        if (social != that.social) return false;
        if (gender != that.gender) return false;
        if (dateBirth != null ? !dateBirth.equals(that.dateBirth) : that.dateBirth != null) return false;

        if (dateRegistration != null ? !dateRegistration.equals(that.dateRegistration) : that.dateRegistration != null)
            return false;
        if (namePatient != null ? !namePatient.equals(that.namePatient) : that.namePatient != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
     */
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (insuranceId != null ? insuranceId.hashCode() : 0);
         /*int result = (int) (insuranceId.hashCode() ^ (insuranceId.hashCode() >>> 32));


        result = 31 * result + (namePatient != null ? namePatient.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
        result = 31 * result + (dateRegistration != null ? dateRegistration.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + social;*/
        return result;
    }


    public Collection<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Collection<Visit> visitsByIdPat) {
        this.visits = visitsByIdPat;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void addVisit(Visit visit){

        this.visits.add(visit);

    }

    public void deleteVisit (Visit visit){
        this.visits.remove(visit);

    }




}
