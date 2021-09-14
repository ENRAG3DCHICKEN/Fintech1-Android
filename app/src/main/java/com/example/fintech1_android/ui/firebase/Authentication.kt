package com.example.fintech1_android.ui.firebase

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.SharedPreferences




fun SignupUser(navController: NavHostController, context: ComponentActivity, email: String, password: String) {

    lateinit var auth: FirebaseAuth

    // Initialize Firebase Auth
    auth = Firebase.auth

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(context) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(ContentValues.TAG, "createUserWithEmail:success")

                navController.navigate("ChargePayment")

                // Save the current user in Shared Preferences with key "CurrentUser"
                val preferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("CurrentUserUID", auth.currentUser?.uid)
                editor.commit()

            } else {
                // If sign in fails, display a message to the user.
                Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(context, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }

        }
}

fun LoginUser(navController: NavHostController, context: ComponentActivity, email: String, password: String) {

    lateinit var auth: FirebaseAuth

    // Initialize Firebase Auth
    auth = Firebase.auth

    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(context) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser

                navController.navigate("ChargePayment")

                // Save the current user in Shared Preferences with key "CurrentUser"
                val preferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("CurrentUserUID", auth.currentUser?.uid)
                editor.commit()

            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)
                Toast.makeText(context, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }
}