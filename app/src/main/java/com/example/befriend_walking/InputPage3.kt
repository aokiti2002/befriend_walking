package com.example.befriend_walking

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.content.Intent
import android.widget.Button
import android.widget.ImageButton

class InputPage3  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_3)

        val userData: SharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        val txtName = intent.getStringExtra("name")
        val txtPass = intent.getStringExtra("password")
        val txtAge = intent.getStringExtra("age")
        val txtGender = intent.getStringExtra("gender")
        var txtHobby = ""

        val btn1 = findViewById<Button>(R.id.input3_btn1_1)
        val btn2 = findViewById<Button>(R.id.input3_btn1_2)
        val btn3 = findViewById<Button>(R.id.input3_btn2_1)
        val btn4 = findViewById<Button>(R.id.input3_btn2_2)

        btn1.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.button_green)
            btn2.setBackgroundResource(R.drawable.input_button)
            btn3.setBackgroundResource(R.drawable.input_button)
            btn4.setBackgroundResource(R.drawable.input_button)

            txtHobby = btn1.text.toString()
        }

        btn2.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.input_button)
            btn2.setBackgroundResource(R.drawable.button_green)
            btn3.setBackgroundResource(R.drawable.input_button)
            btn4.setBackgroundResource(R.drawable.input_button)

            txtHobby = btn2.text.toString()
        }

        btn3.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.input_button)
            btn2.setBackgroundResource(R.drawable.input_button)
            btn3.setBackgroundResource(R.drawable.button_green)
            btn4.setBackgroundResource(R.drawable.input_button)

            txtHobby = btn3.text.toString()
        }

        btn4.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.input_button)
            btn2.setBackgroundResource(R.drawable.input_button)
            btn3.setBackgroundResource(R.drawable.input_button)
            btn4.setBackgroundResource(R.drawable.button_green)

            txtHobby = btn4.text.toString()
        }

        val goBack = findViewById<ImageButton>(R.id.input3_btn3_1)
        goBack.setOnClickListener {
            finish()
        }

        val goNext = findViewById<ImageButton>(R.id.input3_btn3_2)
        goNext.setOnClickListener {
            startActivity(
                Intent(this, ConfirmPage::class.java).apply {
                    putExtra("name", txtName)
                    putExtra("password", txtPass)
                    putExtra("age", txtAge)
                    putExtra("gender", txtGender)
                    putExtra("hobby", txtHobby)
                }
            )
        }
    }
}