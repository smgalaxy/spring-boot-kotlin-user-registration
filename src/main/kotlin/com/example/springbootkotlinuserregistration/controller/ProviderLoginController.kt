package com.example.springbootkotlinuserregistration.controller


import com.example.springbootkotlinuserregistration.entity.Provider
import com.example.springbootkotlinuserregistration.service.ProviderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class ProviderLoginController (val providerService: ProviderService?) {


    @GetMapping("/providerlogin")
    fun enterLoginDetails(model: Model): String {
        model.addAttribute("provider", Provider())
        return "providerloginform"
    }

    @PostMapping("/providerlogin")
    fun loginValidation(@ModelAttribute provider: Provider, model: Model): String {
        model.addAttribute("provider", provider)
        println("Email id is ${provider.providerEmail}")
        //println("Model values : ${model.")
        val dbprovider: Provider? = providerService?.getByProviderEmail(provider.providerEmail)
        println("dbprovider : $dbprovider")
        val dbprovider1: Provider? = providerService?.getByProviderPassword(provider.providerPassword)
        println("dbprovider : $dbprovider1")
        return if (dbprovider != null && dbprovider1!=null){
            model.addAttribute("provider",dbprovider)
            "providerloginsuccess"
        }
        else {
            println("dbprovider: $dbprovider")
            "providerloginnotfound"
        }
    }
    @GetMapping("/providerregistrationform")
    fun providerRegistration(model: Model):String
    {
        model.addAttribute("provider",Provider())
        return "providerregistrationform"
    }

}