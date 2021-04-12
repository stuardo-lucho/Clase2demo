package com.example.clase3demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ClaseB {

    //nuevo comentario

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipperid;
    @Column(nullable = false)
    private String nombreDeCompania;
    private String phone;

    public int getShipperid() {
        return shipperid;
    }

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
