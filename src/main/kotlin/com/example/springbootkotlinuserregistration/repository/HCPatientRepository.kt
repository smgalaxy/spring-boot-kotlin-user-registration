package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.HealthCheckupPatient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HCPatientRepository : JpaRepository<HealthCheckupPatient,Long> {
}