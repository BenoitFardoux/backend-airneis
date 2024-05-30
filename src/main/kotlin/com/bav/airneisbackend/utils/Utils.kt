package com.bav.airneisbackend.utils

class Utils {
    companion object {
        fun isEmailValid(email: String): Boolean {
            val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\$".toRegex()
            return emailRegex.matches(email)
        }

        fun isCardNumberValid(cardNumber: String): Boolean {
            val cardNumberRegex = "^[0-9]{16}\$".toRegex()
            return cardNumberRegex.matches(cardNumber)
        }

        fun isVerificationNumberValid(verificationNumber: String): Boolean {
            val verificationNumberRegex = "^[0-9]{3}\$".toRegex()
            return verificationNumberRegex.matches(verificationNumber)
        }

        fun isPasswordValid(password: String): Boolean {
            val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$".toRegex()
            return passwordRegex.matches(password)
        }
    }
}