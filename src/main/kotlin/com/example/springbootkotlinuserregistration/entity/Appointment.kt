package com.example.springbootkotlinuserregistration.entity

import org.hibernate.Hibernate
import org.jetbrains.annotations.NotNull
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name = "appointment")
 class Appointment(
    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
     var patientId: Long = 0,

    @Column(name = "name")
    @NotNull
     var appointmentName : String = "",

    @Column(name = "email")
    @NotNull
     var email:String = "",

    @Column(name="date")
    @NotNull
     var date:String = "",

    @Column(name = "time")
    @NotNull
     var time : String = "",

    @Column(name="description")
    @NotNull
     var description : String = "",

    @Column(name = "regtime")
    @Transient
     var regtime : String = "",

    @Column(name = "provider_id")
    @NotNull
    var providerId: Long = 0

    )