package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.repository.PatientRepository


import org.springframework.stereotype.Service


@Service
class PatientService(var patientRepository : PatientRepository){
    //,var bCryptPasswordEncoder: BCryptPasswordEncoder
    fun addPatient(patient: Patient) : Patient?{
//        patient.patientPassword = bCryptPasswordEncoder.encode(patient.patientPassword)
//        print("Inside patient service : ${patient.patientPassword}")
        return patientRepository.save(patient)

    }
    fun getByPatientEmail(email: String): Patient? {
        return patientRepository.findBypatientEmail(email)
    }

//    @Autowired
//    private val passwordEncoder: PasswordEncoder? = null
//
//    @Throws(EmailExistsException::class)
//    fun registerNewUserAccount(accountDto: UserDto): User? {
//        if (emailExist(accountDto.getEmail())) {
//            throw EmailExistsException(
//                "There is an account with that email adress:" + accountDto.getEmail()
//            )
//        }
//        val user = User()
//        user.setFirstName(accountDto.getFirstName())
//        user.setLastName(accountDto.getLastName())
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()))
//        user.setEmail(accountDto.getEmail())
//        user.setRole(Role(Integer.valueOf(1), user))
//        return repository.save(user)
//    }
}

