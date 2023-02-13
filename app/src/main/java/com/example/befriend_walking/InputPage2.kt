package com.example.befriend_walking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageButton

class InputPage2  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_2)

        val txtName = intent.getStringExtra("name")
        val txtPass = intent.getStringExtra("password")
        var txtAge = ""
        var txtGender = ""

        val btn1 = findViewById<Button>(R.id.input2_btn1_1)
        val btn2 = findViewById<Button>(R.id.input2_btn1_2)
        val btn3 = findViewById<Button>(R.id.input2_btn1_3)
        val btn4 = findViewById<Button>(R.id.input2_btn1_4)
        val btn5 = findViewById<Button>(R.id.input2_btn2_1)
        val btn6 = findViewById<Button>(R.id.input2_btn2_2)
        val btn7 = findViewById<Button>(R.id.input2_btn2_3)

        btn1.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.button_green)
            btn2.setBackgroundResource(R.drawable.input_button)
            btn3.setBackgroundResource(R.drawable.input_button)
            btn4.setBackgroundResource(R.drawable.input_button)

            txtAge = btn1.text.toString()
        }

        btn2.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.input_button)
            btn2.setBackgroundResource(R.drawable.button_green)
            btn3.setBackgroundResource(R.drawable.input_button)
            btn4.setBackgroundResource(R.drawable.input_button)

            txtAge = btn2.text.toString()
        }

        btn3.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.input_button)
            btn2.setBackgroundResource(R.drawable.input_button)
            btn3.setBackgroundResource(R.drawable.button_green)
            btn4.setBackgroundResource(R.drawable.input_button)

            txtAge = btn3.text.toString()
        }

        btn4.setOnClickListener {
            btn1.setBackgroundResource(R.drawable.input_button)
            btn2.setBackgroundResource(R.drawable.input_button)
            btn3.setBackgroundResource(R.drawable.input_button)
            btn4.setBackgroundResource(R.drawable.button_green)

            txtAge = btn4.text.toString()
        }

        btn5.setOnClickListener {
            btn5.setBackgroundResource(R.drawable.button_green)
            btn6.setBackgroundResource(R.drawable.input_button)
            btn7.setBackgroundResource(R.drawable.input_button)

            txtGender = btn5.text.toString()
        }

        btn6.setOnClickListener {
            btn5.setBackgroundResource(R.drawable.input_button)
            btn6.setBackgroundResource(R.drawable.button_green)
            btn7.setBackgroundResource(R.drawable.input_button)

            txtGender = btn6.text.toString()
        }

        btn7.setOnClickListener {
            btn5.setBackgroundResource(R.drawable.input_button)
            btn6.setBackgroundResource(R.drawable.input_button)
            btn7.setBackgroundResource(R.drawable.button_green)

            txtGender = btn7.text.toString()
        }

        val goBack = findViewById<ImageButton>(R.id.input2_btn3_1)
        goBack.setOnClickListener {
            finish()
        }

        val goNext = findViewById<ImageButton>(R.id.input2_btn3_2)
        goNext.setOnClickListener {
            startActivity(
                Intent(this, InputPage3::class.java).apply {
                    putExtra("name", txtName)
                    putExtra("password", txtPass)
                    putExtra("age", txtAge)
                    putExtra("gender", txtGender)
                }
            )
        }
    }
}