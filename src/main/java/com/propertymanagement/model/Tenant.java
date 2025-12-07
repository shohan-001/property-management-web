package com.propertymanagement.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenantID;
    private String name;
    private String contactInfo;
    private String assignedRoomID;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Bill> outstandingBills = new ArrayList<>();

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();

    public Tenant() {
    }

    public Tenant(String tenantID, String name, String contactInfo) {
        this.tenantID = tenantID;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAssignedRoomID() {
        return assignedRoomID;
    }

    public void setAssignedRoomID(String assignedRoomID) {
        this.assignedRoomID = assignedRoomID;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<Bill> getOutstandingBills() {
        return outstandingBills;
    }

    public void setOutstandingBills(List<Bill> outstandingBills) {
        this.outstandingBills = outstandingBills;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
