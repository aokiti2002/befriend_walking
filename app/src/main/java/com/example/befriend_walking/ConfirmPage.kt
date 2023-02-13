package com.example.befriend_walking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.content.Context
import android.content.ContentValues
import android.content.Intent
import android.widget.TextView
import android.widget.ImageButton

class ConfirmPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm)

        val userData: SharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val editor = userData.edit()

        val txtName = intent.getStringExtra("name")
        val txtPass = intent.getStringExtra("password")
        val txtAge = intent.getStringExtra("age")
        val txtGender = intent.getStringExtra("gender")
        val txtHobby = intent.getStringExtra("hobby")

        val txt1 = findViewById<TextView>(R.id.confirm_txt2)
        val txt2 = findViewById<TextView>(R.id.confirm_txt4)
        val txt3 = findViewById<TextView>(R.id.confirm_txt6_1)
        val txt4 = findViewById<TextView>(R.id.confirm_txt6_2)
        val txt5 = findViewById<TextView>(R.id.confirm_txt8)

        txt1.text = txtName
        txt2.text = txtPass
        txt3.text = txtAge
        txt4.text = txtGender
        txt5.text = txtHobby

        val goBack = findViewById<ImageButton>(R.id.confirm_btn1_1)
        goBack.setOnClickListener {
            finish()
        }

        val goNext = findViewById<ImageButton>(R.id.confirm_btn1_2)
        goNext.setOnClickListener {

            editor.putString("name", txtName)
            editor.putString("password", txtPass)
            editor.putString("age", txtAge)
            editor.putString("gender", txtGender)
            editor.putString("hobby", txtHobby)
            editor.putString("latitude", "0.0")
            editor.putString("longitude", "0.0")

            editor.apply()

            val i = Intent(this, MainPage::class.java)
            startActivity(i)
        }
    }
}