package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.Organisation
import com.example.springbootkotlinuserregistration.service.OrganisationService
import org.hibernate.mapping.List
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class OrganisationController(val organisationService: OrganisationService) {

    fun addOrganisation()
    {
        organisationService.addOrganisation(Organisation())
    }

    @GetMapping("/organisation")
    fun getOrganisationDetails(model: Model) : String{
        print(">>>Inside organisation controller")
        val organisations = organisationService.getOrganisationDetails()

        model.addAttribute("organisations",organisations)
        return "showorganisation"
    }
}