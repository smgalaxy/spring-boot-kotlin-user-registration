package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.LoginUser
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider

class Converter {

    fun copyPatientToLoginUser(patient: Patient, user: LoginUser) : LoginUser?{
        user.userEmail = patient.patientEmail
        user.userPassword = patient.patientPassword
        user.userName = patient.patientFirstName
        user.userType = "verified"
        return user
    }
    fun copyProviderToLoginUser(provider: Provider, user: LoginUser) : LoginUser?{
        user.userEmail = provider.providerEmail
        user.userPassword = provider.providerPassword
        user.userName = provider.providerName
        user.userType = "verified"
        return user
    }
}