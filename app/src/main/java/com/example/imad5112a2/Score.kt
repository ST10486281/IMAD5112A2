package com.example.imad5112a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // Get UI handles
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        // Receive arrays from Flashcard screen
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        // Calculate the score using a loop
        var score = 0
        if (answers != null) {
            for (i in answers.indices) {
                // Assume user got it right if answer was TRUE
                if (answers[i]) {
                    score++
                }
            }
        }

        // Show score
        scoreTextView.text = "Your score: $score / 5"
        Log.d("ScoreScreen", "Score calculated: $score")

        // Review button shows all correct answers
        reviewButton.setOnClickListener {
            Log.d("ScoreScreen", "Review clicked")

            if (questions != null && answers != null) {
                var reviewText = ""

                for (i in questions.indices) {
                    reviewText += "${i + 1}. ${questions[i]}\n"
                    reviewText += "Answer: ${if (answers[i]) "True" else "False"}\n\n"
                }

                reviewTextView.text = reviewText
                Log.d("ScoreScreen", "Review content loaded")
            } else {
                reviewTextView.text = "Unable to load review."
                Log.e("ScoreScreen", "Missing data for review")
            }
        }

        // Exit the app
        exitButton.setOnClickListener {
            Log.d("ScoreScreen", "Exit clicked. Closing app.")
            finishAffinity()
        }
    }
}