package com.example.imad5112a2

import android.content.Intent
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScoreTest {

    @Test
    fun testScoreCalculationAndDisplay() {
        val intent = Intent(Intent.ACTION_MAIN).apply {
            setClassName(
                "com.example.imad5112a2",
                "com.example.imad5112a2.Score"
            )
            putExtra("questions", arrayOf(
                "Q1", "Q2", "Q3", "Q4", "Q5"
            ))
            putExtra("answers", booleanArrayOf(true, false, true, true, false)) // 3 correct
        }

        val scenario = ActivityScenario.launch<Score>(intent)

        scenario.onActivity { activity ->
            val scoreTextView = activity.findViewById<TextView>(R.id.scoreTextView)
            assertTrue(scoreTextView.text.contains("3 / 5"))
        }
    }
}
