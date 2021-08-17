package com.example.fintech1_android

import android.os.Bundle
import androidx.compose.ui.*
import androidx.navigation.compose.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FintechApp()
        }
    }
}


@Composable
fun FintechApp() {
    Fintech1AndroidTheme {
        val navController = rememberNavController()
        Scaffold (
            modifier = Modifier
        ) {
            FintechNavHost(navController = navController, modifier = Modifier)
        }
    }
}


@Composable
fun FintechNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = FintechScreen.Landing.name,
        modifier = modifier
    ) {
        composable(FintechScreen.Landing.name) {
            Landing(navController)
        }
        composable(FintechScreen.Signup.name) {
            Signup(navController)
        }
        composable(FintechScreen.Login.name) {
            Login(navController)
        }
    }
}

@Composable
fun Landing(navController: NavHostController) {
    Column {
        Text("Flare Pay Merchants")

        Button(
            onClick = { navController.navigate("Signup") }
        ) {
            Text(text = "Signup")
        }

        Button(
            onClick = { navController.navigate("Login") }
        ) {
            Text(text = "Login")
        }

    }
}

@Composable
fun Signup(navController: NavHostController) {

    var text_email by remember { mutableStateOf("") }
    var text_password by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = text_email,
            onValueChange = { text_email = it },
            label = { Text("Email") }
        )
        OutlinedTextField(
            value = text_password,
            onValueChange = { text_password = it },
            label = { Text("Password") }
        )
    }

}


@Composable
fun Login(navController: NavHostController) {

    var text_email by remember { mutableStateOf("") }
    var text_password by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = text_email,
            onValueChange = { text_email = it },
            label = { Text("Email") }
        )
        OutlinedTextField(
            value = text_password,
            onValueChange = { text_password = it },
            label = { Text("Password") }
        )
    }

}
