package com.example.springbootkotlinuserregistration.bootstrap

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import com.example.springbootkotlinuserregistration.repository.PatientRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class PatientLoader(val patientRepository: PatientRepository?) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {

        val patient : Patient = Patient()
        patient.patientId = 111
        patient.patientFirstName = "Anil"
        patient.patientLastName = "Kulkarni"
        patient.patientEmail = "anil@gmail.com"
        patient.patientPassword = "1234"
        patientRepository?.save(patient)

    }

}