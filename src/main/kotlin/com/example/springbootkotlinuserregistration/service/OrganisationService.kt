package com.example.springbootkotlinuserregistration.service

import com.example.springbootkotlinuserregistration.entity.Organisation
import com.example.springbootkotlinuserregistration.repository.OrganisationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganisationService(val organisationRepository: OrganisationRepository) {
    fun addOrganisation(organisation: Organisation){
        organisationRepository.save(organisation)
    }

    fun getOrganisationDetails() : MutableList<Organisation> {

      return organisationRepository.findAll()
    }
}