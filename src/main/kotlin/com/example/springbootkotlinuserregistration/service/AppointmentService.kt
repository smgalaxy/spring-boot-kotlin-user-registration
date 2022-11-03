package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.Appointment
import com.example.springbootkotlinuserregistration.repository.AppointmentRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AppointmentService(val appointmentRepository: AppointmentRepository)
{
    fun saveAppointment(appointment: Appointment): Appointment {
        return appointmentRepository.save(appointment)
    }

    fun getProviderID(userEmail: String) : Long{
        println(">>> inside AppointmentService>>> getProviderID : ${appointmentRepository.findIdOfTheProvider(userEmail)}")
        return appointmentRepository.findIdOfTheProvider(userEmail)
    }
    fun getAppointmentByEmail(userEmail: String): MutableList<Appointment>
    {
        return appointmentRepository.findByEmail(userEmail)
    }

    fun getAppointmentById(id: Long) : MutableList<Appointment>{
        return appointmentRepository.findAllByProviderId(id)
    }
}