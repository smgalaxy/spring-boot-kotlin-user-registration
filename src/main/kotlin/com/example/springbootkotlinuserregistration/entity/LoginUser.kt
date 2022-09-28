package com.example.springbootkotlinuserregistration.entity

import org.springframework.stereotype.Component

@Component
 class LoginUser(
    var userName : String = "",
    var userEmail:String = "",
    var userPassword : String = "",
    var userType: String = ""
    )
