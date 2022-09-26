package com.example.springbootkotlinuserregistration.bootstrap

import com.example.springbootkotlinuserregistration.entity.Provider
import com.example.springbootkotlinuserregistration.repository.ProviderRepository
import com.example.springbootkotlinuserregistration.service.ProviderService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class ProviderLoader(val providerRepository: ProviderRepository?) : ApplicationListener<ContextRefreshedEvent>{
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        var provider : Provider = Provider()
        provider.providerName = "Apollo Hospitals-Chennai"
        provider.providerId = 100
        provider.providerPassword = "abc"
        provider.providerEmail = "apollochennai@apollohospitals.com"
        providerRepository?.save(provider)

        var provider1 : Provider = Provider()
        provider1.providerName = "Dr.Prashanth Dogre"
        provider1.providerId = 200
        provider1.providerPassword = "1345"
        provider1.providerEmail = "prashanthd@mail.com"
        providerRepository?.save(provider1)
    }

}