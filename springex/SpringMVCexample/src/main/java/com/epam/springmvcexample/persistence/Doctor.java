package com.epam.springmvcexample.persistence;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/17/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "DOCTOR", schema = "NICK_T", catalog = "")
@Entity
@XmlRootElement(name = "doctor")
public class Doctor {

    @Id
    @Column(name = "ID_DOCTOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
//    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_DOCTOR_SEQ", allocationSize=1)
    private long idDoctor;

    @Column(name = "NAME_DOCTOR")
    private String nameDoctor;

    @Column(name = "SPECIAIZATION")
    private String speciaization;

    @Column(name = "SCHEDULE")
    private String schedule;

    @XmlTransient
    @OneToMany(mappedBy = "doctor")
    private Collection<Anamnesis> anamnesisesByIdDoctor;

    @XmlTransient
    @OneToOne(mappedBy = "doctor")
    private User user;


    public long getIdDoctor() {
        return idDoctor;
    }



    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }


    public String getSpeciaization() {
        return speciaization;
    }

    public void setSpeciaization(String speciaization) {
        this.speciaization = speciaization;
    }


    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor that = (Doctor) o;

        if (idDoctor != that.idDoctor) return false;
        if (nameDoctor != null ? !nameDoctor.equals(that.nameDoctor) : that.nameDoctor != null) return false;
        if (schedule != null ? !schedule.equals(that.schedule) : that.schedule != null) return false;
        if (speciaization != null ? !speciaization.equals(that.speciaization) : that.speciaization != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idDoctor ^ (idDoctor >>> 32));
        result = 31 * result + (nameDoctor != null ? nameDoctor.hashCode() : 0);
        result = 31 * result + (speciaization != null ? speciaization.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        return result;
    }


    public Collection<Anamnesis> getAnamnesisesByIdDoctor() {
        return anamnesisesByIdDoctor;
    }

    public void setAnamnesisesByIdDoctor(Collection<Anamnesis> anamnesisesByIdDoctor) {
        this.anamnesisesByIdDoctor = anamnesisesByIdDoctor;
    }
}
