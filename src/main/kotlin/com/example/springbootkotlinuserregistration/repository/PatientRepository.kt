package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional


interface PatientRepository : JpaRepository<Patient, Long> {
     fun save(patient: Patient): Patient
     fun findBypatientEmail(email:String) : Patient

     fun findBypatientPassword(password:String) : Patient
//     @Query
//          ("select * from registration.patient_table pat where pat.emailaddress = ?1 AND pat.password=?2")
//     fun findColBypatientEmailAndpatientPassword(email : String, password: String) : Patient

//     fun findByMailId(email : String): Optional<Patient>

//     @Query(
//          "SELECT c FROM Customer c WHERE (:name is null or c.name = :name) and (:email is null"
//                  + " or c.email = :email)"
//     )
//     fun findCustomerByNameAndEmail(@Param("name") name: String?, @Param("email") email: String?): List<Customer?>?

}