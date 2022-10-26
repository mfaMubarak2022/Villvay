package com.villvay.consumerservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Company {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Company_Id")
    private Integer companyId;

    @Column(name = "Company_Name")
    private String companyName;

    @Column(name = "Company_Address")
    private String companyAddress;

    @Column(name = "Company_Location")
    private String companyLocation;

    @Column(name = "Company_Phone")
    private String companyPhone;

    @Column(name = "Company_Email")
    private String companyEmail;


}
