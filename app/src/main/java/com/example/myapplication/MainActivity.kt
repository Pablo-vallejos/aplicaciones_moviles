package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


class MainActivity : AppCompatActivity() {
    private lateinit var tatetiBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Vincula el botón con el ID definido en el archivo XML
        tatetiBtn = findViewById<Button>(R.id.tatetiBtn)

        tatetiBtn.setOnClickListener {
            val intent = Intent(this, TaTeTi_Activity::class.java)
            startActivity(intent)
        }
    }
}

