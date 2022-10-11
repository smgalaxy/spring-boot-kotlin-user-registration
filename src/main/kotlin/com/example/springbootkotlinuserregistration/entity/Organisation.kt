package com.example.springbootkotlinuserregistration.entity

import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Component
import javax.persistence.*
import kotlin.reflect.typeOf

@Entity
@Table(name = "organisation_tbl")
class Organisation(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var organisationId : Long = 0,
    @Column(name = "organisation_name")
    @NotNull
    var organisationName : String = "",
    @Column(name = "organisation_email")
    @NotNull
    var organisationEmail : String = "",

    @Column(name = "organisation_address")
    @NotNull
    var organisationAddress : String ="",

//    @OneToMany(mappedBy = "organisation", cascade = [CascadeType.ALL])
//    var providers : List<Provider> = mutableListOf(),
//    @OneToMany(mappedBy = "organisation", cascade = [CascadeType.ALL])
//    var patients : List<Patient> = mutableListOf()
)


