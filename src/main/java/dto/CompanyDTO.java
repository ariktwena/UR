/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Company;

/**
 *
 * @author Tweny
 */
public class CompanyDTO {

    private int id;
    private String companyName;

    public CompanyDTO() {
    }

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.companyName = company.getCompanyName();
    }

    public CompanyDTO(int id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public CompanyDTO(String companyName) {
        this.id = -1;
        this.companyName = companyName;
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

    @Override
    public String toString() {
        return "CompanyDTO{" + "id=" + id + ", companyName=" + companyName + '}';
    }

}
