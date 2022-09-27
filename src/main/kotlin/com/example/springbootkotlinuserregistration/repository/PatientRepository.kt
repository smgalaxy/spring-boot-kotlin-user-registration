package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.Patient
import org.springframework.data.jpa.repository.JpaRepository


interface PatientRepository : JpaRepository<Patient, Long> {
     fun save(patient: Patient): Patient
     fun findBypatientEmail(email:String) : Patient

     fun findBypatientPassword(password:String) : Patient
     fun findBypatientEmailAndpatientPassword(email : String, password: String) : Patient

//     fun findByMailId(email : String): Optional<Patient>

}