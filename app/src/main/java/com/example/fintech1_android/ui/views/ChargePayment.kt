package com.example.fintech1_android.ui.views

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.google.firebase.components.Component
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.CompoundBarcodeView

@Composable
fun ChargePayment(navController: NavHostController) {
    Row {

        Button(
            onClick = { navController.navigate("QR_Pay") }
        ) {
            Text(text = "QR Pay")
        }

        Button(
            onClick = { navController.navigate("Face_Pay") }
        ) {
            Text(text = "FacePay")
        }

    }
}




@Composable
fun QR_Pay(navController: NavHostController, homeActivity: ComponentActivity) {
    Button(
        onClick = {
            IntentIntegrator(homeActivity).initiateScan()
        },
        modifier = Modifier
    ) {
        Text(text = "Scan QR")
    }
}














@Composable
fun Face_Pay(navController: NavHostController) {
    Text("Hello World - 2")
}

