package com.example.befriend_walking

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.main.bottom_navigation

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val navController = findNavController(R.id.nav_host_fragment)
        setupWithNavController(bottom_navigation, navController)
    }

    override fun onResume() {
        super.onResume()

        val userData: SharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val editor = userData.edit()

        val latitude = userData.getString("latitude","NoData")
        val longitude = userData.getString("longitude", "NoData")

        Toast.makeText(
            this, "${latitude}\n${longitude}", Toast.LENGTH_SHORT
        ).show()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        } else {
            fusedLocation()
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            fusedLocation()
        } else {
            val toast = Toast.makeText(
                this,
                "これ以上なにもできません", Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }

    private fun fusedLocation() {

        val userData: SharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val editor = userData.edit()

        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        // 最後に確認された位置情報を取得
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        fusedLocationClient.lastLocation.addOnSuccessListener {
            if (it != null) {

                editor.putString("latitude", it.latitude.toString())
                editor.putString("longitude", it.longitude.toString())

                editor.apply()

            } else {
                val request = LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                    .setInterval(500)
                    .setFastestInterval(300)

                fusedLocationClient
                    .requestLocationUpdates(
                        request,
                        object : LocationCallback() {
                            override fun onLocationResult(result: LocationResult) {

                                editor.putString("latitude", it?.latitude.toString())
                                editor.putString("longitude", it?.longitude.toString())

                                editor.apply()

                                fusedLocationClient.removeLocationUpdates(this)
                            }
                        },
                        null
                    )
            }
        }
    }
}