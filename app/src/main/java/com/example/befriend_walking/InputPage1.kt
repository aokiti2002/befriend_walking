package com.example.befriend_walking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class InputPage1  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_1)

        val txtName = findViewById<EditText>(R.id.input1_edit1)

        val random = (1000..9999).random()
        val txtPass = findViewById<TextView>(R.id.input1_txt5)
        txtPass.text = random.toString()

        val goNext = findViewById<ImageButton>(R.id.input1_btn1)
        goNext.setOnClickListener {
            startActivity(
                Intent(this, InputPage2::class.java).apply {
                    putExtra("name", txtName.text.toString())
                    putExtra("password", txtPass.text.toString())
                }
            )
        }
    }
}