package com.example.springbootkotlinuserregistration.service

import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class PasswordEncryptionService {

    fun encryptPassword(password: String) : String? {
        /* Plain-text password initialization. */
        var encryptedpassword: String? = null
        /* MessageDigest instance for MD5. */
        val m = MessageDigest.getInstance("MD5")

        /* Add plain-text password bytes to digest using MD5 update() method. */
        m.update(password.toByteArray())

        /* Convert the hash value into bytes */
        val bytes = m.digest()

        /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
        val s = StringBuilder()
        for (i in bytes.indices) {
            s.append(Integer.toString((bytes[i].toInt() and 0xff) + 0x100, 16).substring(1))


            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString()

            /* Display the unencrypted and encrypted passwords. */
            //println("Encrypted password using MD5: $encryptedpassword")
        }
        return encryptedpassword
    }
}