package com.example.fintech1_android

import android.view.SurfaceControl
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

enum class FintechScreen() {
    Landing(
    ),
    Signup(
    ),
    Login(
    ),
    AccountProfile(
    ),
    ChargePayment(
    ),
    TransactionHistory(
    );

    companion object {
        fun fromRoute(route: String?): FintechScreen =
            when (route?.substringBefore("/")) {
                Landing.name -> Landing
                Signup.name -> Signup
                Login.name -> Login
                AccountProfile.name -> AccountProfile
                ChargePayment.name -> ChargePayment
                TransactionHistory.name -> TransactionHistory
                null -> Landing
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}

