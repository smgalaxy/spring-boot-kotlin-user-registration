package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.stereotype.Service
import com.example.springbootkotlinuserregistration.repository.ProviderRepository

@Service
class ProviderService (val providerRepository: ProviderRepository,
                       val passwordEncryptionService: PasswordEncryptionService,
                       val patientService: PatientService){

    fun addProvider(provider: Provider): Provider? {
        val encryptedPassword = passwordEncryptionService.encryptPassword(provider.providerPassword).toString()
        println("encrypted password: ${encryptedPassword}")
        provider.providerPassword = encryptedPassword
        return providerRepository.save(provider)

    }
    fun existsByUserEmail(userEmail : String): Int {
        return providerRepository.existsByProviderEmail(userEmail)
    }
    fun addPatientToProvider(id : Long,email: String){
        //providerRepository.addPatientById(id,email)
    }
    fun getAllProviders() : MutableList<Provider>
    {
        return providerRepository.findAll()
    }
    fun getByProviderEmail(email: String): Provider? {
        return providerRepository.findByproviderEmail(email)
    }
    fun getByProviderPassword(password: String): Provider? {
        return providerRepository.findByproviderPassword(password)
    }

    fun getByProviderEmailAndProviderPassword(email: String,password: String) : Provider?{
        return providerRepository.findByProviderEmailAndProviderPassword(email,password)
    }
//    fun getByProviderEmailAndPassword(email: String,password: String):Provider?{
//        return providerRepository.findColByproviderEmailAndproviderPassword(email, password)
//    }
//    fun getAllProviders(): MutableIterable<Provider>? {
//        return providerRepository.findAll()
//    }
//
//    fun updateProvider(provider: Provider): Provider {
//        return providerRepository.save(provider)
//    }
//
//    fun deleteProvider(provider: Provider): Unit? {
//        return providerRepository.delete(provider)
//    }


}