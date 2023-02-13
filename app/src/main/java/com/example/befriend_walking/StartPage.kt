package com.example.befriend_walking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.content.Context
import android.content.SharedPreferences

class StartPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)

        val userData: SharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        Handler().postDelayed({
            val txtName = userData.getString("name", null)

            if (txtName == null) {
                val intent = Intent(this, InputPage1::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainPage::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}

