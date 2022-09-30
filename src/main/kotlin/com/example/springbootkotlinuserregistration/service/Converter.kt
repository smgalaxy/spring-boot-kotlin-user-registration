package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.LoginUser
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.stereotype.Service

@Service
class Converter(val user: LoginUser) {

    fun copyPatientToLoginUser(patient: Patient) : LoginUser{
        user.userEmail = patient.patientEmail
        user.userPassword = patient.patientPassword
        user.userName = patient.patientFirstName
        user.userType = "patient"
        return user
    }
    fun copyProviderToLoginUser(provider: Provider) : LoginUser?{
        user.userEmail = provider.providerEmail
        user.userPassword = provider.providerPassword
        user.userName = provider.providerName
        user.userType = "provider"
        return user
    }
}