package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.LoginUser
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.stereotype.Service

@Service
class LoginService(
    var patientService: PatientService?,
    var providerService: ProviderService?,
    var converter: Converter
) {

    fun checkPatientLogin(user: LoginUser): LoginUser? {

        println("user type : ${user.userType}")

        val dbpatient: Patient? = patientService?.getByPatientEmailAndPassword(user.userEmail, user.userPassword)
        println("inside checkPatientLogin : after patient verification $dbpatient")

        if (dbpatient != null) {
            return converter.copyPatientToLoginUser(dbpatient, user)
        }
        return null
    }

    fun checkProviderLogin(user: LoginUser): LoginUser? {
        println("user type : ${user.userType}")

        val dbprovider: Provider? = providerService?.getByProviderEmailAndPassword(user.userEmail, user.userPassword)
        println("inside checkPatientLogin : after patient verification $dbprovider")
        if (dbprovider != null) {
            return converter.copyProviderToLoginUser(dbprovider, user)
        }
        return null
    }
}