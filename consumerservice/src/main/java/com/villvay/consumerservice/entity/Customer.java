package com.villvay.consumerservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Customer_Id")
    private Integer customerId;

    @Column(name = "Customer_Name")
    private String customerName;

    @Column(name = "Customer_Address")
    private String customerAddress;

    @Column(name = "Customer_Phone")
    private String customerPhone;

    @Column(name = "Customer_Email")
    private String customerEmail;

    @ManyToOne
    @JoinColumn(name = "Company")
    private Company company;
}
