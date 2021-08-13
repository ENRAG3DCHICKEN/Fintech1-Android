package com.example.fintech1_android

import android.view.SurfaceControl
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

enum class FintechScreen() {
    Landing(
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
                AccountProfile.name -> AccountProfile
                ChargePayment.name -> ChargePayment
                TransactionHistory.name -> TransactionHistory
                null -> Landing
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}

