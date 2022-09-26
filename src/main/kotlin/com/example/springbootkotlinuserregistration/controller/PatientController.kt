package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.service.PatientService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class PatientController (val patientService: PatientService?) {

    @RequestMapping("/patient/new")
    fun newPatient(model: Model): String? {
        model.addAttribute("patient", Patient())
        return "patientregistrationform"
    }

    @RequestMapping(value = ["/patient"], method = [RequestMethod.POST])
    fun savePatient(patient: Patient): String? {

        patientService?.addPatient(patient)
        return "success"
    }

}
