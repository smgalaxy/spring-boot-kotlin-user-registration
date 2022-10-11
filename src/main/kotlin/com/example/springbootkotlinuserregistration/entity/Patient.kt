package com.example.springbootkotlinuserregistration.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "Patient_table")
class Patient (
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
    var patientEmail:String = "",

    @Column(name = "Problem_type")
    @NotNull
    var patientProblem : String = ""
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "provider_id", nullable = false)
//

    //    var provider: Provider? = Provider()

//    @ManyToOne(cascade = [CascadeType.ALL])
//    @JoinColumn(name = "organisation_id")
//    var organisationId: Organisation = Organisation()
)