package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import org.springframework.stereotype.Service
import com.example.springbootkotlinuserregistration.repository.ProviderRepository

@Service
class ProviderService (val providerRepository: ProviderRepository){

    fun addProvider(provider: Provider): Provider? {
        return providerRepository.save(provider)
    }
    fun getByProviderEmail(email: String): Provider {
        return providerRepository.findByproviderEmail(email)
    }

    fun getAllProviders(): MutableIterable<Provider>? {
        return providerRepository.findAll()
    }

    fun updateProvider(patient: Provider): Provider {
        return providerRepository.save(patient)
    }

    fun deleteProvider(provider: Provider): Unit? {
        return providerRepository.delete(provider)
    }


}