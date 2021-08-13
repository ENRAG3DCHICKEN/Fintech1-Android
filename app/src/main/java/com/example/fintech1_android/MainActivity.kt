package com.example.fintech1_android

import android.os.Bundle
import androidx.compose.ui.*
import androidx.navigation.compose.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            Landing()
        }
    }
}

@Composable
fun Landing() {
    Text("Hello World")
}