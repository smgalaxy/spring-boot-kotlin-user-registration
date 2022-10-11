package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.Organisation
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.entity.Provider
import com.example.springbootkotlinuserregistration.service.OrganisationService
import org.springframework.web.bind.annotation.*
import com.example.springbootkotlinuserregistration.service.ProviderService
import org.aspectj.apache.bcel.classfile.Module.Provide
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

@Controller
class ProviderController (val providerService: ProviderService?,
                          val organisationService: OrganisationService) {
    @RequestMapping("/register/provider")
    fun newProvider(model: Model): String? {
        model.addAttribute("provider", Provider())
        return "providerregistrationform"
    }

    @RequestMapping(value = ["/provider"], method = [RequestMethod.POST])
    fun saveProvider(provider: Provider, model:Model): String? {
        providerService?.addProvider(provider)
        val organisations : MutableList<Organisation> = organisationService.getOrganisationDetails()
        model.addAttribute("organisations",organisations)
        return "providerregistrationsuccess"
    }
    @PutMapping("/link/{id}")
    fun linkPatientToProvider(@PathVariable id: Long){
        println("Id value  = $id}")
    }
//    @PostMapping("/provider")
//    fun savePatient(@RequestBody provider: Provider): Provider? {
//        //println("inside add patient")
//        return providerService?.addProvider(provider)
//    }
//
//    @GetMapping("/provider")
//    fun getPatients(): MutableIterable<Provider>? {
//        return providerService?.getAllProviders()
//    }
//    @PutMapping("/provider")
//    fun updatePatient(@RequestBody provider: Provider) : Provider? {
//        return providerService?.updateProvider(provider)
//    }
//    @DeleteMapping("/provider")
//    fun deletePatient(@RequestBody provider: Provider): Unit? {
//        return providerService?.deleteProvider(provider)
//    }

}
