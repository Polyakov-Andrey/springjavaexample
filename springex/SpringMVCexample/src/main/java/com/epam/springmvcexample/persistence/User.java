package com.epam.springmvcexample.persistence;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 7/15/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "USERS", schema = "NICK_T", catalog = "")
@Entity
@XmlRootElement(name = "user")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
//    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_USER_SEQ", allocationSize=1)
    private long idUser;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;

    @OneToOne
    @JoinColumn(name = "ID_DOC", referencedColumnName = "ID_DOCTOR", nullable = false)
    @XmlTransient
    private Doctor doctor;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
