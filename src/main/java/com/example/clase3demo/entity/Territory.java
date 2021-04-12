package com.example.clase3demo.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="territories")
public class Territory {

    @Id
    @Column(nullable = false)
    private String territoryid;
    @Column(nullable = false)
    private String territorydescription;
    @Column(nullable = false)
    private int regionid;

    public String getTerritoryid() {
        return territoryid;
    }

    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }

    public String getTerritorydescription() {
        return territorydescription;
    }

    public void setTerritorydescription(String territorydescription) {
        this.territorydescription = territorydescription;
    }

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }
}
