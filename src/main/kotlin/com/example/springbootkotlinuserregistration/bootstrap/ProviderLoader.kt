package com.example.springbootkotlinuserregistration.bootstrap

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
        var provider : Provider = Provider()
        provider.providerName = "Apollo Hospitals-Chennai"
        provider.providerId = 100
        provider.providerPassword = passwordEncryptionService.encryptPassword("Apollo@2022").toString()
        provider.providerEmail = "apollochennai@apollohospitals.com"
        providerRepository?.save(provider)

        var provider1 : Provider = Provider()
        provider1.providerName = "Dr.Praful Dogre"
        provider1.providerId = 200
        provider1.providerPassword = passwordEncryptionService.encryptPassword("Praful@2022").toString()
        provider1.providerEmail = "prashanthd@mail.com"
        providerRepository?.save(provider1)
    }

}