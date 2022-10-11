package com.example.springbootkotlinuserregistration.repository

import com.example.springbootkotlinuserregistration.entity.Organisation
import org.springframework.data.jpa.repository.JpaRepository

interface OrganisationRepository : JpaRepository<Organisation, Long> {
    fun save(organisation: Organisation) : Organisation
    override fun findAll(): MutableList<Organisation>
}