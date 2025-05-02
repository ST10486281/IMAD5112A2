package com.example.imad5112a2

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FlashcardTest {

    @Test
    fun testFirstQuestionDisplayed() {
        val scenario = ActivityScenario.launch(Flashcard::class.java)

        scenario.onActivity { activity ->
            val questionTextView = activity.findViewById<TextView>(R.id.questionTextView)
            assertTrue(questionTextView.text.contains("Nelson Mandela"))
        }
    }
}
