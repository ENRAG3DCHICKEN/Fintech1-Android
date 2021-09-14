package com.example.fintech1_android.ui.firebase

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import android.content.SharedPreferences
import androidx.activity.ComponentActivity


fun LoadTransactionsHistory(context: ComponentActivity){

    // Pull Current User UID from Firebase Auth
    val preferences: SharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
    val CurrentUserUID = preferences.getString("CurrentUserUID", "")

    // Instantiate an instance of the Firestore DB Client
    val db = Firebase.firestore

    // Pull Data from Firestore
    db.collection("Admin").document(CurrentUserUID!!).collection("Sales")
        .addSnapshotListener { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            val cities = ArrayList<String>()
            for (doc in value!!) {
                doc.getString("name")?.let {
                    cities.add(it)
                }
            }
            Log.d(TAG, "Current cites in CA: $cities")
        }

}
