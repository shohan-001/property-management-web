package com.propertymanagement.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propertyID;
    private String address;
    private String propertyType;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Tenant> tenantList = new ArrayList<>();

    public Property() {
    }

    public Property(String propertyID, String address, String propertyType) {
        this.propertyID = propertyID;
        this.address = address;
        this.propertyType = propertyType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public List<Tenant> getTenantList() {
        return tenantList;
    }

    public void setTenantList(List<Tenant> tenantList) {
        this.tenantList = tenantList;
    }
}
