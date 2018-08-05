package com.example.root.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val src_lat = findViewById<View>(R.id.src_lat) as EditText
        val src_long = findViewById<View>(R.id.src_long) as EditText
        val dest_lat = findViewById<View>(R.id.dest_lat) as EditText
        val dest_long = findViewById<View>(R.id.dest_long) as EditText
        val submit = findViewById<View>(R.id.submit) as Button
        val text = findViewById<View>(R.id.result) as TextView
        submit.setOnClickListener {
            if (src_lat.text.equals("") || src_long.text.equals("") || dest_lat.text.equals("") || dest_long.text.equals("")) {
                Toast.makeText(this@MainActivity, "Please fill value in all fields",
                        Toast.LENGTH_LONG).show()
            } else {
                val dist = distance(java.lang.Double.parseDouble(src_lat.text.toString()), java.lang.Double.parseDouble(src_long.text.toString()), java.lang.Double.parseDouble(dest_lat.text.toString()), java.lang.Double.parseDouble(dest_long.text.toString()))
                text.text = "The distance between the points is :$dist km"
            }
        }

    }

    private fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val theta = lon1 - lon2
        var dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta))
        dist = Math.acos(dist)
        dist = rad2deg(dist)
        dist = dist * 60.0 * 1.1515
        return dist
    }

    private fun deg2rad(deg: Double): Double {
        return deg * Math.PI / 180.0
    }

    private fun rad2deg(rad: Double): Double {
        return rad * 180.0 / Math.PI
    }
}
