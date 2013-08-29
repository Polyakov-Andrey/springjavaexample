package com.epam.springmvcexample.persistence;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/17/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "ANAMNESIS", schema = "NICK_T", catalog = "")
@Entity
@XmlRootElement(name = "anamnesis")
public class Anamnesis {

    @Id
    @Column(name = "ID_ANAM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
//    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_ANAM_SEQ", allocationSize=1)
    private long idAnamnesis;

    @Column(name = "COND")
    private String condition;

    @Column(name = "DATE_DIAGNOSIS")
    private Date dateDiagnosis;

    @Column(name = "CURE")
    private String cure;

    @ManyToOne
    @JoinColumn(name = "ID_DOCTOR", referencedColumnName = "ID_DOCTOR", nullable = false)
    @XmlTransient
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "ID_VISIT", referencedColumnName = "ID_VISIT", nullable = false)
    @XmlTransient
    private Visit visit;


//    @OneToMany(mappedBy = "anamnesis")
//    private Collection<Payment> payments;
//


    public long getIdAnamnesis() {
        return idAnamnesis;
    }




    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


    public Date getDateDiagnosis() {
        return dateDiagnosis;
    }

    public void setDateDiagnosis(Date dateDiagnosis) {
        this.dateDiagnosis = dateDiagnosis;
    }


    public String getCure() {
        return cure;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anamnesis that = (Anamnesis) o;

        if (idAnamnesis != that.idAnamnesis) return false;
        if (condition != null ? !condition.equals(that.condition) : that.condition != null) return false;
        if (cure != null ? !cure.equals(that.cure) : that.cure != null) return false;
        if (dateDiagnosis != null ? !dateDiagnosis.equals(that.dateDiagnosis) : that.dateDiagnosis != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAnamnesis ^ (idAnamnesis >>> 32));
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (dateDiagnosis != null ? dateDiagnosis.hashCode() : 0);
        result = 31 * result + (cure != null ? cure.hashCode() : 0);
        return result;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctorByIdDoctor) {
        this.doctor = doctorByIdDoctor;
    }


    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visitByIdVisit) {
        this.visit = visitByIdVisit;
    }


//    public Collection<Payment> getPayments() {
//        return payments;
//    }
//
//    public void setPayments(Collection<Payment> paymentsByIdCondition) {
//        this.payments = paymentsByIdCondition;
//    }
}
