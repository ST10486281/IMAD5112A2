package com.example.imad5112a2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Find the Start button by its ID
        val startButton = findViewById<Button>(R.id.startButton)

        // Log when the app starts
        Log.d("MainActivity", "App started - Welcome screen displayed")

        // Set a click listener on the Start button
        startButton.setOnClickListener {
            // Log that the button was clicked
            Log.d("MainActivity", "Start button clicked")

            // Create an Intent to go to the Flashcard screen
            val intent = Intent(this, Flashcard::class.java)
            startActivity(intent)

            // Log that the intent was sent
            Log.d("MainActivity", "Navigating to Flashcard activity")
        }

    }
}