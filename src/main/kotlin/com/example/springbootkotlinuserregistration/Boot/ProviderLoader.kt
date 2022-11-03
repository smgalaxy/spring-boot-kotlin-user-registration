package com.example.springbootkotlinuserregistration.bootstrap

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import com.example.springbootkotlinuserregistration.repository.ProviderRepository
import com.example.springbootkotlinuserregistration.service.PasswordEncryptionService
import com.example.springbootkotlinuserregistration.service.ProviderService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class ProviderLoader(
    val providerRepository: ProviderRepository?,
    val passwordEncryptionService: PasswordEncryptionService
    ) : ApplicationListener<ContextRefreshedEvent>{
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        val provider: Provider = Provider()
        provider.providerName = "Dr.Arul"
        provider.providerId = 100
        provider.providerPassword = passwordEncryptionService.encryptPassword("Arul@2022").toString()
        provider.providerEmail = "aruld@gmail.com"
        provider.providerType = "Cardiologist"
        //providerRepository?.save(Provider(101,"aruld@gmail.com",
          //  "Dr.Arul","Cardiologists"),Patient())
        providerRepository?.save(provider)


        provider.providerName = "Dr.Praful Dogre"
        provider.providerId = 200
        provider.providerPassword = passwordEncryptionService.encryptPassword("Praful@2022").toString()
        provider.providerEmail = "prafuld@mail.com"
        provider.providerType = "Ophthalmologist"
        providerRepository?.save(provider)

        provider.providerName = "Dr.Shiv kumar"
        provider.providerId = 210
        provider.providerPassword = passwordEncryptionService.encryptPassword("ShivKumar@2022").toString()
        provider.providerEmail = "shivkdr@gmail.com"
        provider.providerType = "Orthopaedics"
        providerRepository?.save(provider)
    }


}