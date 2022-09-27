package com.example.springbootkotlinuserregistration.entity

import org.jetbrains.annotations.NotNull
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
    @NotNull
    var patientFirstName: String = "",
    @Column(name = "lastname")
    @NotNull
    var patientLastName: String = "",
    @Column(name = "password")
    @NotNull
    var patientPassword: String = "",
    @Column(name = "emailaddress")
    @NotNull
    var patientEmail:String = ""
)