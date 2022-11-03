package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.Appointment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AppointmentRepository : JpaRepository<Appointment, Long> {
    fun findByEmail(email : String): MutableList<Appointment>
    @org.springframework.lang.Nullable
    @Query (value = "SELECT provider_id FROM registration.appointment WHERE email = ?1" , nativeQuery = true)
    fun findIdOfTheProvider(email: String) : Long
    @org.springframework.lang.Nullable
    @Query(value = "Select * from registration.appointment where provider_id = ?1", nativeQuery = true)
    fun findAllByProviderId(id: Long): MutableList<Appointment>
}