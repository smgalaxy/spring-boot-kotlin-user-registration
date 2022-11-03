package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.HealthCheckupPatient
import com.example.springbootkotlinuserregistration.repository.HCPatientRepository
import org.springframework.stereotype.Service

@Service
class HealthCheckupService (val hcpatientRepository: HCPatientRepository){
    fun addHcPatient(hcpatient : HealthCheckupPatient)
    {
        hcpatientRepository.save(hcpatient)
    }
}
