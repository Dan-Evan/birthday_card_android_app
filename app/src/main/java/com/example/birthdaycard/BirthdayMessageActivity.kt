package com.example.birthdaycard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BirthdayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_message)

        //Get the Intent that started this activity and extract the string
        val nameMessage = intent.getStringExtra("EXTRA_NAME")
        val birthMessage = intent.getStringExtra("EXTRA_BIRTH")
        val ageMessage = intent.getStringExtra("EXTRA_AGE")
        val horoscopeMessage = intent.getStringExtra("EXTRA_HOROSCOPE")
        val gemStone = intent.getStringExtra("EXTRA_GEMSTONE")


        //Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.displayName).apply {
            text = nameMessage
        }

        val  textView2 = findViewById<TextView>(R.id.displayDOB).apply {
            text = birthMessage
        }

        val  textView3 = findViewById<TextView>(R.id.displayAge).apply {
            text = ageMessage
        }

        val  textView4 = findViewById<TextView>(R.id.displayHoroscope).apply {
            text = horoscopeMessage
        }

        val  textView5 = findViewById<TextView>(R.id.displayGem).apply {
            text = gemStone
        }
    }
}