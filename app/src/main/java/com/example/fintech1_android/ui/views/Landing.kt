package com.example.fintech1_android.ui.views

import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.fintech1_android.ui.firebase.SignupUser
import com.example.fintech1_android.ui.firebase.LoginUser

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
fun Signup(navController: NavHostController, context: ComponentActivity) {

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
        Button(
            onClick = { SignupUser(context, text_email, text_password) }
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun Login(navController: NavHostController, context: ComponentActivity) {

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
        Button(
            onClick = { LoginUser(context, text_email, text_password) }
        ) {
            Text("Submit")
        }
    }
}
