package com.example.fintech1_android

import android.os.Bundle
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

//        Scaffold (
//            FintechNavHost(navController, modifier = Modifier)
//        )

        Text("Hello World")
    }
}


//@Composable
//fun FintechNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
//    NavHost(
//        navController = navController,
//        modifier = modifier
//    ) {
//        Text("Hello World")
//    }
//
//
//}