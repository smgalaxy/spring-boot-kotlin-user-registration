package com.example.springbootkotlinuserregistration.Boot

import com.example.springbootkotlinuserregistration.entity.Organisation
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.repository.OrganisationRepository
import com.example.springbootkotlinuserregistration.repository.PatientRepository
import com.example.springbootkotlinuserregistration.service.PasswordEncryptionService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component


@Component
class OrganisationLoader(
    val organisationRepository: OrganisationRepository?
) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {

        val organisation : Organisation = Organisation()
        organisation.organisationId = 101
        organisation.organisationName = "BlueStone Hospitals"
        organisation.organisationEmail = "blustonehospitals@gmail.com"
        organisation.organisationAddress = "100,Greams Road,Chennai-82"
        organisationRepository?.save(organisation)

    }

}