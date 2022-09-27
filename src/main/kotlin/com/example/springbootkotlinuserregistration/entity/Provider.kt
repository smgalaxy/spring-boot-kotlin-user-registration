package com.example.springbootkotlinuserregistration.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table (name = "Provider_table")
data class Provider (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var providerId: Long = 0,
    @Column(name = "emailaddress")
    @NotNull
    var providerEmail:String = "",
    @Column(name = "providername")
    @NotNull
    var providerName: String = "",
    @Column(name = "password")
    @NotNull
    var providerPassword: String = ""

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//    name = "users_roles",
//    joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
//    inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
//    )
//    var List<Patient> patient = new ArrayList<>();
//    @OneToMany(mappedBy="providerId")
   // var patients listof<Patient>;
)