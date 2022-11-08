package com.example.birthdaycard

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    private lateinit var textName: EditText
    private lateinit var textBirth: TextView
     private lateinit var buttonG: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName = findViewById(R.id.editTextViewName)
        textBirth = findViewById(R.id.TextViewDOB)
        buttonG = findViewById(R.id.gen)
    }

    //function that is fun when you select on DOB view
    fun selectDate(view: View){
        val c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)

        //set CalenderDialog
        val calenderDialog = DatePickerDialog(this, {
                _, year, month, dayOfMonth ->
            cDay = dayOfMonth
            cMonth = month
            cYear = year

            buttonG.setOnClickListener {
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                val ageCal = currentYear - cYear

                val name = textName.text.toString()
                val dateOfBirth = textBirth.text.toString()
                val age = ageCal.toString()
                val horoscope = findHoroscope(cDay, cMonth, cYear)
                val gem = findGem(cMonth)

                val intent = Intent(this, BirthdayMessageActivity::class.java).apply {
                    putExtra("EXTRA_NAME", name)
                    putExtra("EXTRA_BIRTH", dateOfBirth)
                    putExtra("EXTRA_AGE", age)
                    putExtra("EXTRA_HOROSCOPE", horoscope)
                    putExtra("EXTRA_GEMSTONE", gem)

                }

                startActivity(intent)
            }
            textBirth.text = "$cDay/${cMonth + 1}/$cYear"
        }, cYear, cMonth, cDay)
       calenderDialog.show()
    }

}

fun findHoroscope(day: Int, month: Int, birthYear: Int): String {
    var num = birthYear

    if (month == 0 && day < 21) {
        num--
    }

    val zodiac = when (num % 12) {
        0 -> "Monkey"
        1 -> "Rooster"
        2 -> "Dog"
        3 -> "Pig"
        4 -> "Rat"
        5 -> "Ox"
        6 -> "Tiger"
        7 -> "Rabbit"
        8 -> "Dragon"
        9 -> "Snake"
        10 -> "Horse"
        else -> "Sheep"
    }

    return zodiac
}

fun findGem(month: Int): String {
    val gemstone = when (month) {
        0 -> "Garnet"
        1 -> "Amethyst"
        2 -> "Aquamarine, Bloodstone"
        3 -> "Diamond, Rock Crystal"
        4 -> "Emerald, Chrysoprase"
        5 -> "Pearl, Moonstone"
        6 -> "Ruby, Carnelian"
        7 -> "Peridot, Sardonyx"
        8 -> "Sapphire, Lapis Lazuli"
        9 -> "Opal"
        10 -> "Topaz, Citrine"
        else -> "Tanzanite, Turquoise"
    }
    return gemstone
}

