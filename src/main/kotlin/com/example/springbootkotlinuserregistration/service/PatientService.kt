package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.repository.PatientRepository


import org.springframework.stereotype.Service
import java.util.*


@Service
class PatientService(var patientRepository : PatientRepository) {
    //,var bCryptPasswordEncoder: BCryptPasswordEncoder
    fun addPatient(patient: Patient): Patient? {
//        patient.patientPassword = bCryptPasswordEncoder.encode(patient.patientPassword)
//        print("Inside patient service : ${patient.patientPassword}")
        return patientRepository.save(patient)

    }

    fun getByPatientEmail(email: String): Patient {
        return patientRepository.findBypatientEmail(email)
    }

    fun getBypatientPassword(password: String): Patient {
        return patientRepository.findBypatientPassword(password)
    }
//    fun getByPatientEmailAndPassword(email : String, password: String) : Patient?{
//        return patientRepository.findColBypatientEmailAndpatientPassword(email,password)
//    }
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


