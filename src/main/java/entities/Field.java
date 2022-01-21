/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Tweny
 */
@Entity
@Table(name = "field")
@NamedQueries({
    @NamedQuery(name = "Field.deleteAllRows", query = "DELETE from Field"),})
public class Field implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "prizeName", length = 255, nullable = false, unique = false)
    private String prizeName;
    @Column(name = "prizeValue", length = 255, nullable = false, unique = false)
    private int prizeValue;

    //***************Many to One****************
    @ManyToOne
    private Wheel wheel;

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Wheel getWheel() {
        return wheel;
    }
    //***************************************************************

    public Field() {
    }

    public Field(String prizeName, int prizeValue) {
        this.prizeName = prizeName;
        this.prizeValue = prizeValue;
        this.wheel = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(int prizeValue) {
        this.prizeValue = prizeValue;
    }

}
