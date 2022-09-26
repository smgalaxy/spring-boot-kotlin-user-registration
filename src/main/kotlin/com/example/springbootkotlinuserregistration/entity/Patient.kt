package com.example.springbootkotlinuserregistration.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "Patient_table")

data class Patient (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var patientId: Long = 0,
    @Column(name = "firstname")
    var patientFirstName: String = "",
    @Column(name = "lastname")
    var patientLastName: String = "",
    @Column(name = "password")
    var patientPassword: String = "",
    @Column(name = "emailaddress")
    var patientEmail:String = ""
)