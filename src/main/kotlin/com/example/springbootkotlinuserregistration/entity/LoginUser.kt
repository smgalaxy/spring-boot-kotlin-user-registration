package com.example.springbootkotlinuserregistration.entity


data class LoginUser(
    var userName : String = "",
    var userEmail:String = "",
    var userPassword : String = "",
    var userType: String = ""
    )
