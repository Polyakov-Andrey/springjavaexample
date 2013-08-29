package com.epam.springmvcexample.enums;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 7/16/13
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Order {
    Normal("Student", 1), Child("Child",0.5), Student( "Student", 0.8), Pensionary ("Pensionary", 0.7), Disabled("Disabled", 0.3);

    String label;
    double coeff;


    Order(String label, double coeff) {
        this.coeff= coeff;
    }

    public String getLabel() {
        return label;
    }

    public double getCoeff() {
        return coeff;
    }
}
