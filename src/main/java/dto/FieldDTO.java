/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Field;

/**
 *
 * @author Tweny
 */
public class FieldDTO {

    private int id;
    private String prizeName;
    private int prizeValue;

    public FieldDTO() {
    }

    public FieldDTO(Field field) {
        this.id = field.getId();
        this.prizeName = field.getPrizeName();
        this.prizeValue = field.getPrizeValue();
    }

    public FieldDTO(String prizeName, int prizeValue) {
        this.id = -1;
        this.prizeName = prizeName;
        this.prizeValue = prizeValue;
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

    @Override
    public String toString() {
        return "FieldDTO{" + "id=" + id + ", prizeName=" + prizeName + ", prizeValue=" + prizeValue + '}';
    }

}
