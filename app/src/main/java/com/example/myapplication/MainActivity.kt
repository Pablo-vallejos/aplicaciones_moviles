package com.example.myapplication

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


class MainActivity : AppCompatActivity() {
    private lateinit var tatetiBtn: Button
    private lateinit var puntajesBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Vincula el botón con el ID definido en el archivo XML
        tatetiBtn = findViewById<Button>(R.id.tatetiBtn)
        tatetiBtn.setOnClickListener {
            val intent = Intent(this, TaTeTi_Activity::class.java)
            startActivity(intent)
        }

        puntajesBtn = findViewById<Button>(R.id.puntajesBtn)
        puntajesBtn.setOnClickListener {
            val intent = Intent(this, Puntaje_Activity::class.java)
            startActivity(intent)
        }

    }
}

