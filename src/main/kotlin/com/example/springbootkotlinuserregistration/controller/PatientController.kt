package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.HealthCheckupPatient
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import com.example.springbootkotlinuserregistration.service.HealthCheckupService
import com.example.springbootkotlinuserregistration.service.PatientService
import com.example.springbootkotlinuserregistration.service.ProviderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class PatientController (val patientService: PatientService?,
                         val providerService: ProviderService,
                         val hcpatientService : HealthCheckupService) {

    @RequestMapping("/register/patient")
    fun newPatient(model: Model): String? {

        var providerslist : List<Provider> = providerService.getAllProviders()
        for ( provider in providerslist)
        {
            println(">>>> PatientController>>>newpatient ${provider.providerName}")
        }
        model.addAttribute("providers",providerslist)

        model.addAttribute("patient", Patient())
        return "patientregistrationform"
    }

    @RequestMapping(value = ["/patient"], method = [RequestMethod.POST])
    fun savePatient(patient: Patient, model: Model): Any {
        if (patientService?.existsByUserEmail(patient.patientEmail)!! >0) {
            model.addAttribute("patient",Patient())
            model.addAttribute("errorMessage","User Already Exists!")
            return "patientregistrationform"
        }
        else {
            patientService?.addPatient(patient)
            model.addAttribute("errorMessage",null)
            return "loginregistrationsuccess"
        }

    }
    @PostMapping("/hcpatient")
    fun addHealthCheckupEntity(model: Model,hcpatient: HealthCheckupPatient) : String
    {
        hcpatientService.addHcPatient(hcpatient)
        return "Healthcheckupsuccess"
    }
}
