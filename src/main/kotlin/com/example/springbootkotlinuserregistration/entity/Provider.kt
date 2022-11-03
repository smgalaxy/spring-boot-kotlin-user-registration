package com.example.springbootkotlinuserregistration.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table (name = "Provider_table")
class Provider (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="provider_id")
    var providerId: Long = 0,
    @Column(name = "emailaddress")
    @NotNull
    var providerEmail:String = "",
    @Column(name = "providername")
    @NotNull
    var providerName: String = "",
    @Column
    @NotNull
    var providerType : String = "",
    @Column(name = "password")
    @NotNull
    var providerPassword: String = ""


//    @OneToMany
//    @JoinColumn(name="patient_id")
//    var patients : List<Patient>


//    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY,
//    cascade = arrayOf(CascadeType.ALL)
//    )
    //@OneToMany(mappedBy = "provider", cascade = [CascadeType.ALL])
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "patient_provider",
//        joinColumns = arrayOf(JoinColumn(name = "patient_id")),
//        inverseJoinColumns = arrayOf(JoinColumn(name = "provider_id"))
//    )

//    @ManyToOne
//    @JoinColumn(name = "organisation_id")
//    var organisationId : Int = 101
) {
    override fun toString(): String {
        return "Provider(providerId=$providerId, providerEmail='$providerEmail', providerName='$providerName', providerType='$providerType', providerPassword='$providerPassword')"
    }
}