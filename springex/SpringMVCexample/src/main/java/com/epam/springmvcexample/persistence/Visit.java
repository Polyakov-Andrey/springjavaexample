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
@Table(name = "VISIT", schema = "NICK_T", catalog = "")
@Entity
@XmlRootElement(name = "visit")
public class Visit {

    @Id
    @Column(name = "ID_VISIT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
//    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_VISIT_SEQ", allocationSize=1)
    private long idVisit;

    @Column(name = "DATEOFVISIT")
    private Date dateofvisit;

    @Column(name = "COMPLAINT")
    private String complaint;

    @OneToMany(mappedBy = "visit")
    @XmlTransient
    private Collection<Anamnesis> anamnesises;

    @ManyToOne
    @JoinColumn(name = "ID_PAT", referencedColumnName = "ID_PAT", nullable = false)
    @XmlTransient
    private Patient patientByIdPat;



    public long getIdVisit() {
        return idVisit;
    }


    public Date getDateofvisit() {
        return dateofvisit;
    }

    public void setDateofvisit(Date dateofvisit) {
        this.dateofvisit = dateofvisit;
    }


    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit that = (Visit) o;

        if (idVisit != that.idVisit) return false;
        if (complaint != null ? !complaint.equals(that.complaint) : that.complaint != null) return false;
        if (dateofvisit != null ? !dateofvisit.equals(that.dateofvisit) : that.dateofvisit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idVisit ^ (idVisit >>> 32));
        result = 31 * result + (dateofvisit != null ? dateofvisit.hashCode() : 0);
        result = 31 * result + (complaint != null ? complaint.hashCode() : 0);
        return result;
    }


    public Collection<Anamnesis> getAnamnesises() {
        return anamnesises;
    }

    public void setAnamnesises(Collection<Anamnesis> anamnesisesByIdVisit) {
        this.anamnesises = anamnesisesByIdVisit;
    }


    public Patient getPatient() {
        return patientByIdPat;
    }

    public void setPatient(Patient patientByIdPat) {
        this.patientByIdPat = patientByIdPat;
    }


}
