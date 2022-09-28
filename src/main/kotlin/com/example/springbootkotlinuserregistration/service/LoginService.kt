package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.LoginUser
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.stereotype.Service

@Service
class LoginService(
    var patientService: PatientService?,
    var providerService: ProviderService?,
    var converter: Converter?
    ) {

    fun checkPatientLogin(user: LoginUser): LoginUser? {

        println("user type : ${user.userType}")

//        val dbpatient: Patient? =
//            patientService?.getByPatientEmailAndPassword(user.userEmail, user.userPassword)
        val dbpatient: Patient? = patientService?.getByPatientEmail(user.userEmail)
        val dbpatient1: Patient? = patientService?.getBypatientPassword(user.userPassword)
        println("inside checkPatientLogin : after patient verification $dbpatient")

//        if(dbpatient!=null)
//            return converter?.copyPatientToLoginUser(dbpatient)

        if (dbpatient != null && dbpatient1 != null) {
            if (dbpatient == dbpatient1)
                return converter?.copyPatientToLoginUser(dbpatient)
        }
        return null
    }
    fun checkProviderLogin(user: LoginUser): LoginUser? {
        println("user type : ${user.userType}")

//        val dbprovider: Provider? =
//            providerService?.getByProviderEmailAndPassword(user.userEmail, user.userPassword)
        val dbprovider:Provider? = providerService?.getByProviderEmail(user.userEmail)
        val dbprovider1:Provider? = providerService?.getByProviderPassword(user.userPassword)
        println("inside checkPatientLogin : after patient verification $dbprovider")
        if ( dbprovider != null && dbprovider1 != null ) {
            if(dbprovider == dbprovider1)
                return converter?.copyProviderToLoginUser(dbprovider)
        }
        return null
    }
}