package com.example.springbootkotlinuserregistration.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "Patient_table")
class Patient (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
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

//    @ManyToOne
//    @JoinColumn(name = "provider_id")
//    var provider: Provider

//    @ManyToOne(cascade = [CascadeType.ALL])
//    @JoinColumn(name = "organisation_id")
//    var organisationId: Organisation = Organisation()
) {
    override fun toString(): String {
        return "Patient(patientId=$patientId, patientFirstName='$patientFirstName', patientLastName='$patientLastName', patientPassword='$patientPassword', patientEmail='$patientEmail')"
    }
}