package com.example.springbootkotlinuserregistration.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name = "Healthcheckup_table" )
class HealthCheckupPatient (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var hcpatientId : Long = 0,
    @NotNull
    var hcpatientFirstName : String = "",
    @NotNull
    var hcpatientLastName : String = "",
    @NotNull
    var hcpatientEmail : String = "",
    @Transient
    var hcpatientPassword : String = "",
    @NotNull
    var hcpatientAge : Int = 0,
    @NotNull
    var hcpatientGender : Char = 'D',
    @NotNull
    var hcDate : String = ""
    ) {
    override fun toString(): String {
        return "HealthCheckup(hcpatientId=$hcpatientId, hcpatientFirstName='$hcpatientFirstName', hcpatientLastName='$hcpatientLastName', hcpatientEmail='$hcpatientEmail', hcpatientPassword='$hcpatientPassword', hcpatientAge=$hcpatientAge, hcpatientGender='$hcpatientGender', hcDate='$hcDate')"
    }
}
