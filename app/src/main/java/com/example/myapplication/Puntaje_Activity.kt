package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Puntaje_Activity : AppCompatActivity() {

    private lateinit var homeBtnPuntaje: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntaje)


        homeBtnPuntaje = findViewById<Button>(R.id.homeBtnPuntaje)

        homeBtnPuntaje.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}