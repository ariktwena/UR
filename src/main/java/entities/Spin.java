/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
@Table(name = "spin")
@NamedQueries({
    @NamedQuery(name = "Spin.deleteAllRows", query = "DELETE from Spin"),})
public class Spin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fieldNumbers")
    private int fieldNumbers;
    @Column(name = "arcSize")
    private double arcSize;
    @Column(name = "top")
    private int top;
    @Column(name = "offSet")
    private double offSet;
    @Column(name = "rotate")
    private double rotate;
    @Column(name = "resultNumber")
    private int resultNumber;
    @Column(name = "resultName")
    private String resultName;
    @Column(name = "resultValue")
    private double resultValue;
    @Column(name = "date")
    private LocalDate date;

    //***************Many to One****************
    @ManyToOne
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
    //***************************************************************

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

    public Spin() {
    }

    public Spin(int fieldNumbers) {
        this.fieldNumbers = fieldNumbers;
        this.arcSize = (2 * Math.PI) / fieldNumbers;
        this.top = findTop(fieldNumbers);
        this.offSet = findOffSet(fieldNumbers, this.arcSize);
        this.rotate = Math.floor(Math.random() * 900) + 500;
        this.resultNumber = findResultNumber(this.arcSize, this.top, this.offSet, this.rotate, fieldNumbers);
        this.resultName = "";
        this.resultValue = -1;
        this.player = null;
        this.wheel = null;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFieldNumbers() {
        return fieldNumbers;
    }

    public void setFieldNumbers(int fieldNumbers) {
        this.fieldNumbers = fieldNumbers;
    }

    public double getArcSize() {
        return arcSize;
    }

    public void setArcSize(int fieldNumbers) {
        this.arcSize = (2 * Math.PI) / fieldNumbers;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int fieldNumbers) {
        this.top = findTop(fieldNumbers);
    }

    public double getOffSet() {
        return offSet;
    }

    public void setOffSet(int fieldNumbers) {
        this.offSet = findOffSet(fieldNumbers, this.arcSize);
    }

    public double getRotate() {
        return rotate;
    }

    public void setRotate() {
        this.rotate = Math.floor(Math.random() * 900) + 500;
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(int fieldNumbers) {
        this.resultNumber = findResultNumber(this.arcSize, this.top, this.offSet, this.rotate, fieldNumbers);
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public void setResultName(ArrayList<Field> fields) {
        this.resultName = fields.get(this.resultNumber).getPrizeName();
    }

    public double getResultValue() {
        return resultValue;
    }

    public void setResultValue(int resultValue) {
        this.resultValue = resultValue;
    }

    public void setResultValue(ArrayList<Field> fields) {
        this.resultValue = fields.get(this.resultNumber).getPrizeValue();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    private int findTop(int fieldNumbers) {
        if (fieldNumbers == 9) {
            return 7;
        } else if (fieldNumbers == 8) {
            return 6;
        } else if (fieldNumbers <= 7 && fieldNumbers > 4) {
            return fieldNumbers - 1;
        } else if (fieldNumbers == 4) {
            return fieldNumbers - 1;
        } else {
            return fieldNumbers;
        }
    }

    private double findOffSet(int fieldNumbers, double arcSize) {
        if (fieldNumbers == 9) {
            return Math.PI / 2 - arcSize * 2;
        } else if (fieldNumbers == 8) {
            return 0;
        } else if (fieldNumbers <= 7 && fieldNumbers > 4) {
            return Math.PI / 2 - arcSize;
        } else if (fieldNumbers == 4) {
            return 0;
        } else {
            return Math.PI / 2;
        }
    }

    private int findResultNumber(double arcSize, int top, double offSet, double rotate, int fieldNumbers) {
        double netRotation = ((rotate % 360) * Math.PI) / 180;
        System.out.println("NetRotation: " + netRotation);
        double travel = netRotation + offSet;
        System.out.println("Travle: " + travel);
        int count = top + 1;
        System.out.println(count);

        while (travel > 0) {
            System.out.println("---");
            System.out.println(count);
            System.out.println(travel);
            travel = travel - arcSize;
            System.out.println(travel);
            System.out.println("---");
            count--;
        }

        int result;
        if (count >= 0) {
            result = count;
        } else {
            result = fieldNumbers + count;
        }

        return result;
    }

    @Override
    public String toString() {
        return "Spin{" + "id=" + id + ", fieldNumbers=" + fieldNumbers + ", arcSize=" + arcSize + ", top=" + top + ", offSet=" + offSet + ", rotate=" + rotate + ", resultNumber=" + resultNumber + ", resultName=" + resultName + ", resultValue=" + resultValue + ", date=" + date + ", player=" + player + ", wheel=" + wheel + '}';
    }

}
