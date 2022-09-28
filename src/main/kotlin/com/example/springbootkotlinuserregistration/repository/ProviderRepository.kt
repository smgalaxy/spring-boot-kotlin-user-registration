package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import org.springframework.data.repository.CrudRepository


interface ProviderRepository : JpaRepository<Provider, Long> {
    fun save(provider: Provider): Provider
    fun findByproviderEmail(email:String) : Provider?
    fun findByproviderPassword(password:String) : Provider?
//    @Query
//        ("select * from registration.provider_table pro where pro.emailaddress = ?1 AND pro.password=?2")
//    fun findColByproviderEmailAndproviderPassword(email: String,password: String) : Provider
}