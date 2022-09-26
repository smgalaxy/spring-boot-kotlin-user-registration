package com.example.springbootkotlinuserregistration.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table (name = "Provider_table")
data class Provider (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var providerId: Long = 0,
    @Column(name = "emailaddress")
    var providerEmail:String = "",
    @Column(name = "providername")
    var providerName: String = "",
    @Column(name = "password")
    var providerPassword: String = ""

//    @OneToMany(mappedBy="providerId")
//    var patients list<Patient>;
)