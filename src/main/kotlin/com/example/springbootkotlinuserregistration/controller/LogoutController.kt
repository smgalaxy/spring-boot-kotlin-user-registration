package com.example.springbootkotlinuserregistration.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
    @RequestMapping("/logout")
class LogoutController : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        print(">>> LogoutController >> goGet >>")
        val session = request.session
        session.removeAttribute("userName")
        session.invalidate()
        try {
            response.sendRedirect("index1.html")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
