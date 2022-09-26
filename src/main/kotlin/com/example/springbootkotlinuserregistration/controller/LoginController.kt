package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.service.PatientService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class LoginController (val patientService :PatientService?) {

    @GetMapping("/home")
    fun home() = "home"

    @GetMapping("/patientlogin")
    fun enterLoginDetails(model: Model): String {
        model.addAttribute("patient", Patient())
        return "index"
    }

    @PostMapping("/patientlogin")
    fun loginValidation(@ModelAttribute patient: Patient, model: Model): String {
        model.addAttribute("patient", patient)
        println("Email id is ${patient.patientEmail}")
       //println("Model values : ${model.")
        val dbpatient: Patient? = patientService?.getByPatientEmail(patient.patientEmail)
        println(dbpatient)
        
        return if (dbpatient != null)
            "loginsuccess"
        else {
            println("dbpatient: $dbpatient")
            "loginnotfound"
        }
    }
    @GetMapping("/patientregistrationform")
    fun patientRegistration(model: Model):String
    {
        model.addAttribute("patient",Patient())
        return "patientregistrationform"
    }

}