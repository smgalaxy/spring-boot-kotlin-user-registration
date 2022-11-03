package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProviderRepository : JpaRepository<Provider, Long> {
    fun save(provider: Provider): Provider
    @Query("select count(*)\n" +
            "from registration.provider_table \n" +
            "where emailaddress = ?1", nativeQuery = true)
    fun existsByProviderEmail(emailAddress:String) : Int
    override fun findAll() : MutableList<Provider>
    fun findByproviderEmail(email:String) : Provider?
    fun findByproviderPassword(password:String) : Provider?
    fun findByProviderEmailAndProviderPassword(email: String,password: String) : Provider?

//    @Modifying
//    @Query("UPDATE registration.Provider_table pro SET pro.patient_id = ?1 WHERE pro.emailaddress=?2")
     //fun addPatientById(id : Long,email:String)
//    @Query
//        ("select * from registration.provider_table pro where pro.emailaddress = ?1 AND pro.password=?2")
//    fun findColByproviderEmailAndproviderPassword(email: String,password: String) : Provider
}