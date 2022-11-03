package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.Appointment
import com.example.springbootkotlinuserregistration.service.AppointmentService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class AppointmentController(val appointmentService : AppointmentService) {
    @RequestMapping("/bookappointment")
    fun bookAnAppointment()  : String{
        println(">> AppointmentController>>bookAnAppointment")
        return "bookappointment"
    }
    @PostMapping("/saveappointment")
    fun fixAppointment(appointment : Appointment, model: Model)  : String{
        println("Inside >>AppointmentController>>fixAppointment")
        val fixedappointment = appointmentService.saveAppointment(appointment)
        println("fixed appointment : ${fixedappointment.appointmentName},${fixedappointment.email}")
        model.addAttribute("appointment",fixedappointment)
        return "loginsuccess"
    }
    @PutMapping("/appointment/{id}")
    fun editAppointment(@PathVariable patientId : Long) : String{
        println(">>>Inside AppointmentController >>editAppointment $patientId")
        return "index"
    }


}