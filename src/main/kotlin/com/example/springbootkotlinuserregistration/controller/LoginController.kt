package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.*
import com.example.springbootkotlinuserregistration.service.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*


@Controller
class LoginController (val patientService :PatientService?,
                       val loginService : LoginService,
                       val organisationService: OrganisationService,
                       val providerService: ProviderService,
                       val appointmentService: AppointmentService) {
    @GetMapping("/home")
    fun home() : String
    {
        return "home"
    }
    @GetMapping("/index")
    fun welcome(model: Model): String {
        val organisation = organisationService.getOrganisationDetails()
        model.addAttribute("organisation", organisation)
        model.addAttribute("user", LoginUser())
        return "index"
    }
    @RequestMapping("/about")
    fun aboutPage() : String{
        return "about"
    }
//    @RequestMapping("/department/cardiology")
//    fun showcardiodept(){
//        return ""
//    }
    @RequestMapping("/healthcheckup")
    fun addHealthCheckUp(model: Model) : String{
        model.addAttribute("hcpatient",HealthCheckupPatient())
        return "Healthcheckup"
    }
    @RequestMapping(value = ["/welcome"], method = [RequestMethod.POST])
    fun userlogin(@ModelAttribute user: LoginUser?, model: Model): String? {
        var verifiedUser: LoginUser? = LoginUser()
        val organisation : MutableList<Organisation> = organisationService.getOrganisationDetails()
        model.addAttribute("user", user)

        if ((user?.userType) == "patient") {
            verifiedUser = loginService.checkPatientLogin(user)
                println(" login credentials check after calling user verification in service : ${verifiedUser?.userName}")
                println("verified user after checking the DB : $verifiedUser")
            if(verifiedUser==null)
            {
                model.addAttribute("organisation",organisation)
                model.addAttribute("user",LoginUser())
                model.addAttribute("error","Invalid")
                return "index"
            }
            val listOfProviders : MutableList<Provider> = providerService.getAllProviders()
                println(">>>userlogin>>>>list of providers : ${listOfProviders.size}")
            model.addAttribute("providers",listOfProviders)
            val appointments = verifiedUser.let { appointmentService.getAppointmentByEmail(it.userEmail) }
                println(">>Login controller>>userlogin>>$appointments")
            model.addAttribute("appointments",appointments)
        } else if ((user?.userType) == "provider") {
            verifiedUser = loginService.checkProviderLogin(user)
            println(
                ">>method userlogin()  after checkProviderLogin(user) " +
                        "after calling user verification in service : $verifiedUser"
            )
            if(verifiedUser==null)
            {
                model.addAttribute("organisation",organisation)
                model.addAttribute("user",LoginUser())
                model.addAttribute("error","Invalid")
                return "index"
            }
            val provider: Provider = providerService.getByProviderEmail(verifiedUser.userEmail)!!
                println(">>Logincontroller >>userlogin>>providerId : $provider")
            val providerId = provider.providerId
                println(">>>>Logincontroller >>userlogin>>providerId : $providerId")
            val appointments = providerId.let { appointmentService.getAppointmentById(it) }
                println("appointment size >>> ${appointments.size}")
            model.addAttribute("appointments",appointments)
        }
        println("userLogin(LoginController) >> verifiedUser.usertype : ${verifiedUser?.userType} ")
        model.addAttribute("verifieduser", verifiedUser)

//        val listOfPatients : MutableList<Patient>? = patientService?.getAllPatients()
//        model.addAttribute("patientslist",listOfPatients)


        model.addAttribute("organisation",organisation)
        model.addAttribute("appointment",Appointment())
        return "loginsuccess"
    }
}
