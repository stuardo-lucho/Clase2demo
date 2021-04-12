package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "territories")
public class Territory {

    @Id
    private String territoryid;

    @Column(nullable = false)
    private String territorydescription;

    @Column(nullable = false)
    private String regionid;



    public String getTerritorydescription() {
        return territorydescription;
    }

    public void setTerritorydescription(String territorydescription) {
        this.territorydescription = territorydescription;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getTerritoryid() {
        return territoryid;
    }

    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }
}