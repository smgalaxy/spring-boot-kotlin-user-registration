package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.LoginUser
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.stereotype.Service

@Service
class LoginService(
    var patientService: PatientService?,
    var providerService: ProviderService?,
    var converter: Converter?,
    var passwordEncoderService: PasswordEncryptionService
    ) {

    fun checkPatientLogin(user: LoginUser): LoginUser? {
        var encryptedPassword = passwordEncoderService.encryptPassword(user.userPassword)
        println("checkPatientLogin>>> encrpted password before hitting db $encryptedPassword")
        val dbpatient : Patient? =
            encryptedPassword?.let { patientService?.getByPatientEmailAndPassword(user.userEmail, it) }
        // val dbpatient : Patient? =
        // encryptedPassword?.let { patientService?.getByPatientEmailAndPassword(user.userEmail, it) }
        println("inside checkPatientLogin : after patient verification $dbpatient")
        if(dbpatient!=null)
            return converter?.copyPatientToLoginUser(dbpatient)
        println("Loginservice : checkPatientLogin : user type : ${user.userType}")
        return null
    }
    fun checkProviderLogin(user: LoginUser): LoginUser? {
        var encryptedPassword = passwordEncoderService.encryptPassword(user.userPassword)
        println("checkProviderLogin>>> encrpted password before hitting db $encryptedPassword")
        val dbprovider: Provider? =
            encryptedPassword?.let { providerService?.getByProviderEmailAndProviderPassword(user.userEmail, it) }

        println("inside checkPatientLogin : after provider verification $dbprovider")
        if ( dbprovider != null) {
                return converter?.copyProviderToLoginUser(dbprovider)
        }
        return null
    }
}