package com.example.springbootkotlinuserregistration.controller

import com.example.springbootkotlinuserregistration.entity.LoginUser
import com.example.springbootkotlinuserregistration.entity.Patient
import com.example.springbootkotlinuserregistration.service.LoginService
import com.example.springbootkotlinuserregistration.service.PatientService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*


@Controller
class LoginController (val patientService :PatientService?, var loginService : LoginService) {

    @GetMapping("/home")
    fun home() = "home"

    @GetMapping("/patientlogin")
    fun enterLoginDetails(model: Model): String {
        model.addAttribute("patient", Patient())
        return "index"
    }

    @PostMapping("/patientlogin")
    fun loginValidation(@ModelAttribute patient: Patient, model: Model): String {

        model.addAttribute("patient", patient)
        println("Email id is ${patient.patientEmail}")
        println("Model values : $model")
        val dbpatient: Patient? = patientService?.getByPatientEmail(patient.patientEmail)
        println(dbpatient)
        val dbpatient1: Patient? = patientService?.getBypatientPassword(patient.patientPassword)
        println(dbpatient1)

        return if (dbpatient != null && dbpatient1 != null) {
            model.addAttribute("patient", dbpatient)
            "loginsuccess"
        } else {
            println("dbpatient: $dbpatient")
            "loginnotfound"
        }
    }

    @GetMapping("/patientregistrationform")
    fun patientRegistration(model: Model): String {
        model.addAttribute("patient", Patient())
        return "patientregistrationform"
    }

    @GetMapping("/welcome")
    fun welcome(model: Model): String {
        model.addAttribute("user", LoginUser())
        return "welcome"
    }

    @RequestMapping(value = ["/login"], method = [RequestMethod.POST])
    fun userlogin(@ModelAttribute user: LoginUser?, model: Model): String? {

        var verifiedUser : LoginUser? = null
        model.addAttribute("user", user)
        println("usertype -> ${user?.userType} username -> ${user?.userEmail} userpassword -> ${user?.userPassword}")
        if ((user?.userType) == "patient") {
            verifiedUser = loginService.checkPatientLogin(user) as LoginUser?

            println("inside login check after calling user verification in service : ${verifiedUser?.userName}")

        }
        else if((user?.userType) == "provider")
        {
           verifiedUser = loginService.checkProviderLogin(user)
            println(">>metd userlogin()  after checkProviderLogin(user) after calling user verification in service : $verifiedUser")
        }
        model.addAttribute("verifieduser",verifiedUser)
        return if(verifiedUser!=null)
            "loginsuccess"
        else
            "loginnotfound"


    }
}
//    @RequestMapping(value = ["/loginProcess"], method = [RequestMethod.POST])
//    fun loginProcess(@ModelAttribute("login") user : UserDto?, model: Model) : String {
//        model.addAttribute("user",user)
//        if (user != null) {
//            println("Hello${user.userEmail}\n${user.userPassword}")
//        }
//        return "Hi"
//    }

//    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
//    public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response,
//    @ModelAttribute("user") User user) {
//
//        userService.register(user);
//
//        return new ModelAndView("welcome", "firstname", user.getFirstname());
//    }
//}




