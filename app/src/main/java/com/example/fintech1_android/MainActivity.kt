package com.example.fintech1_android
import com.example.fintech1_android.ui.views.*

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.*
import androidx.navigation.compose.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.fintech1_android.ui.theme.Fintech1AndroidTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.zxing.integration.android.IntentIntegrator


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FintechApp(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun FintechApp(context: ComponentActivity) {

    Fintech1AndroidTheme {
        val navController = rememberNavController()
        Scaffold (
            modifier = Modifier
        ) {
            FintechNavHost(navController = navController, context = context, modifier = Modifier)
        }
    }
}


@Composable
fun FintechNavHost(navController: NavHostController, context: ComponentActivity, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = FintechScreen.Landing.name,
        modifier = modifier
    ) {
        composable(FintechScreen.Landing.name) {
            Landing(navController)
        }
        composable(FintechScreen.Signup.name) {
            Signup(navController, context)
        }
        composable(FintechScreen.Login.name) {
            Login(navController, context)
        }
        composable(FintechScreen.ChargePayment.name) {
            ChargePayment(navController)
        }
        composable(FintechScreen.QR_Pay.name) {
            QR_Pay(navController, context)
        }
        composable(FintechScreen.Face_Pay.name) {
            Face_Pay(navController)
        }
    }
}

