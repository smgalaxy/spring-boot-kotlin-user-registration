package com.example.springbootkotlinuserregistration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinUserRegistrationApplication
	fun main(args: Array<String>) {
		runApplication<SpringBootKotlinUserRegistrationApplication>(*args)

	}
//	@Bean
//	fun bCryptPasswordEncoder() : BCryptPasswordEncoder {
//		return BCryptPasswordEncoder()
//	}

