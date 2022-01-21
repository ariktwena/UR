/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tweny
 */
@Entity
@Table(name = "wheel")
@NamedQueries({
    @NamedQuery(name = "Wheel.deleteAllRows", query = "DELETE from Wheel"),})
public class Wheel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "wheelName")
    private String wheelName;

    //***************One to Many****************
    @OneToMany(mappedBy = "wheel", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ArrayList<Field> fields;

    public void addField(Field field) {
        if (field != null) {
            field.setWheel(this);
            this.fields.add(field);
        }
    }

    public ArrayList<Field> getFields() {
        return fields;
    }
    //*****************************************

    //***************Many to One****************
    @ManyToOne
    private Company company;

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }
    //***************************************************************

    //***************One to Many****************
    @OneToMany(mappedBy = "wheel", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ArrayList<Spin> spins;

    public void addSpin(Spin spin) {
        if (spin != null) {
            spin.setWheel(this);
            this.spins.add(spin);
        }
    }

    public ArrayList<Spin> getSpins() {
        return spins;
    }
    //*****************************************

    public Wheel() {
    }

    public Wheel(String wheelName) {
        this.wheelName = wheelName;
        this.fields = new ArrayList<>();
        this.company = null;
        this.spins = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWheelName() {
        return wheelName;
    }

    public void setWheelName(String wheelName) {
        this.wheelName = wheelName;
    }

    @Override
    public String toString() {
        return "Wheel{" + "id=" + id + ", wheelName=" + wheelName + ", fields=" + fields + ", company=" + company + '}';
    }

}
