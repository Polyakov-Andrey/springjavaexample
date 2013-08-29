package persistence;



import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.epam.springmvcexample.persistence.Anamnesis;
import com.epam.springmvcexample.persistence.Patient;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;



/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 6/17/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "PAYMENT", schema = "NICK_T", catalog = "")
@Entity
@XmlRootElement(name = "payment")
public class Payment {
    @Id
    @Column(name = "ID_PAYMENT")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_PAY_SEQ", allocationSize=1)
    private long idPayment;

    @Column(name = "ISSUED")
    private Date issued;

    @Column(name = "PAID")
    private Date paid;



    @Column(name = "PRICE")
    private double price;


    @ManyToOne
    @JoinColumn(name = "ID_CONDITION", referencedColumnName = "ID_ANAM", nullable = false)
    @XmlTransient
    private Anamnesis anamnesis;



    @ManyToOne
    @JoinColumn(name = "ID_PAT", referencedColumnName = "ID_PAT", nullable = false)
    @XmlTransient
    private Patient patient;



    public long getIdPayment() {
        return idPayment;
    }


    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }


    public Date getPaid() {
        return paid;
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }

    public double getPrice() {
        return price;
    }




    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment that = (Payment) o;

      //  if (idPayment != that.idPayment) return false;
        if (issued != null ? !issued.equals(that.issued) : that.issued != null) return false;
        if (paid != null ? !paid.equals(that.paid) : that.paid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        // int result = (int) (idPayment ^ (idPayment >>> 32));
        int result = 1;
        result = 31 * result + (issued != null ? issued.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Anamnesis anamnesisByIdCondition) {
        this.anamnesis = anamnesisByIdCondition;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
