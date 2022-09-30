package com.example.springbootkotlinuserregistration.bootstrap

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import com.example.springbootkotlinuserregistration.repository.PatientRepository
import com.example.springbootkotlinuserregistration.service.PasswordEncryptionService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class PatientLoader(
    val patientRepository: PatientRepository?,
    val passwordEncryptionService: PasswordEncryptionService
) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {

        val patient : Patient = Patient()
        patient.patientId = 111
        patient.patientFirstName = "Anil"
        patient.patientLastName = "Kulkarni"
        patient.patientEmail = "anil@gmail.com"
        //encrypting the password and storing in the DataBase
        patient.patientPassword = passwordEncryptionService.encryptPassword("Anil@123").toString()
        patientRepository?.save(patient)

    }

}