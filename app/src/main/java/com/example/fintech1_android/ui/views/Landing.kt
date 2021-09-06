package com.example.fintech1_android.ui.views

import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.fintech1_android.ui.firebase.SignupUser
import com.example.fintech1_android.ui.firebase.LoginUser

@Composable
fun Landing(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Flare Pay Merchants",
            modifier = Modifier.padding(25.dp)
        )

        Button(
            modifier = Modifier.padding(25.dp),
            onClick = { navController.navigate("Signup") }
        ) {
            Text(text = "Signup")
        }

        Button(
            modifier = Modifier.padding(25.dp),
            onClick = { navController.navigate("Login") }
        ) {
            Text(text = "Login")
        }

        //TEST
//        Button(
//            onClick = { navController.navigate("ChargePayment") }
//        ) {
//            Text(text = "Charge Payment")
//        }
    }

}


@Composable
fun Signup(navController: NavHostController, context: ComponentActivity) {

    var text_email by remember { mutableStateOf("") }
    var text_password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.padding(25.dp),
            value = text_email,
            onValueChange = { text_email = it },
            label = { Text("Email") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(25.dp),
            value = text_password,
            onValueChange = { text_password = it },
            label = { Text("Password") }
        )
        Button(
            modifier = Modifier.padding(25.dp),
            onClick = { SignupUser(navController, context, text_email, text_password) }
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun Login(navController: NavHostController, context: ComponentActivity) {

    var text_email by remember { mutableStateOf("") }
    var text_password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.padding(25.dp),
            value = text_email,
            onValueChange = { text_email = it },
            label = { Text("Email") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(25.dp),
            value = text_password,
            onValueChange = { text_password = it },
            label = { Text("Password") }
        )
        Button(
            modifier = Modifier.padding(25.dp),
            onClick = { LoginUser(navController, context, text_email, text_password) }
        ) {
            Text("Submit")
        }
    }
}
