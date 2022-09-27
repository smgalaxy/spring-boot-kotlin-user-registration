package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider

import org.springframework.data.repository.CrudRepository


interface ProviderRepository : CrudRepository<Provider, Long> {
    fun save(provider: Provider): Provider
    fun findByproviderEmail(email:String) : Provider
    fun findByproviderPassword(password:String) : Provider

    fun findByproviderEmailAndproviderPassword(email: String,password: String) : Provider
}