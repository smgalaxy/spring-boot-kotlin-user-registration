package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.LoginUser
import com.example.springbootkotlinuserregistration.entity.Organisation
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.service.LoginService
import com.example.springbootkotlinuserregistration.service.OrganisationService
import com.example.springbootkotlinuserregistration.service.PatientService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*


@Controller
class LoginController (val patientService :PatientService?,
                       val loginService : LoginService,
                       val organisationService: OrganisationService) {
    @GetMapping("/index")
    fun welcome(model: Model): String {
        val organisations = organisationService.getOrganisationDetails()
        model.addAttribute("organisations", organisations)
        model.addAttribute("user", LoginUser())
        return "index"
    }

    @RequestMapping(value = ["/welcome"], method = [RequestMethod.POST])
    fun userlogin(@ModelAttribute user: LoginUser?, model: Model): String? {

        var verifiedUser: LoginUser? = LoginUser()
        model.addAttribute("user", user)

        if ((user?.userType) == "patient") {
            verifiedUser = loginService.checkPatientLogin(user)
            println(" login credentials check after calling user verification in service : ${verifiedUser?.userName}")
        } else if ((user?.userType) == "provider") {
            verifiedUser = loginService.checkProviderLogin(user)
            println(
                ">>method userlogin()  after checkProviderLogin(user) " +
                        "after calling user verification in service : $verifiedUser"
            )
        }
        println("userLogin(LoginController) >> verifiedUser.usertype : ${verifiedUser?.userType} ")
        model.addAttribute("verifieduser", verifiedUser)
        val listOfPatients : MutableList<Patient>? = patientService?.getAllPatients()
        model.addAttribute("patientslist",listOfPatients)
        val organisation : MutableList<Organisation> = organisationService.getOrganisationDetails()
        model.addAttribute("organisation",organisation)
        return "loginsuccess"
    }
}
//    @GetMapping("/home")
//    fun home() = "home"
//
//    @GetMapping("/patientlogin")
//    fun enterLoginDetails(model: Model): String {
//        model.addAttribute("patient", Patient())
//        return "index"
//    }
//
//    @PostMapping("/patientlogin")
//    fun loginValidation(@ModelAttribute patient: Patient, model: Model): String {
//
//        model.addAttribute("patient", patient)
//        println("Email id is ${patient.patientEmail}")
//        println("Model values : $model")
//        val dbpatient: Patient? = patientService?.getByPatientEmail(patient.patientEmail)
//        println(dbpatient)
//        val dbpatient1: Patient? = patientService?.getBypatientPassword(patient.patientPassword)
//        println(dbpatient1)
//
//        return if (dbpatient != null && dbpatient1 != null) {
//            model.addAttribute("patient", dbpatient)
//            "loginsuccess"
//        } else {
//            println("dbpatient: $dbpatient")
//            "loginnotfound"
//        }
//    }
//
//    @GetMapping("/patientregistrationform")
//    fun patientRegistration(model: Model): String {
//        model.addAttribute("patient", Patient())
//        return "patientregistrationform"
//    }



