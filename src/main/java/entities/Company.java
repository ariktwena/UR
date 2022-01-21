/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tweny
 */
@Entity
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.deleteAllRows", query = "DELETE from Company"),})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 255, nullable = false, unique = false)
    private String companyName;

    //***************One to Many****************
    @OneToMany(mappedBy = "company", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ArrayList<Wheel> wheels;

    public void addWheel(Wheel wheel) {
        if (wheel != null) {
            wheel.setCompany(this);
            this.wheels.add(wheel);
        }
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }
    //*****************************************

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.wheels = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
