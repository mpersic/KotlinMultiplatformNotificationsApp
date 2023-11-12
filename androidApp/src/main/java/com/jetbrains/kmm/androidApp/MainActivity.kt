package com.jetbrains.kmm.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.jetbrains.kmm.shared.Greeting
import com.jetbrains.kmm.shared.Calculator
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import com.jetbrains.androidApp.R

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = LocalNotificationService(applicationContext)
        setContent {
            Box (modifier = Modifier.fillMaxSize()){
                Button(onClick = {
                    service.showNotification(Counter.value)
                }) {
                    Text(text = "Hello ${greet()}")
                }
            }
        }
    }
}
