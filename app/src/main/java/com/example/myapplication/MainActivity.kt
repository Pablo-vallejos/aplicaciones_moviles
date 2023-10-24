package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   var player="p1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Vincula el botón con el ID definido en el archivo XML
        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)
        val b3 = findViewById<Button>(R.id.b3)
        val b4 = findViewById<Button>(R.id.b4)
        val b5 = findViewById<Button>(R.id.b5)
        val b9 = findViewById<Button>(R.id.b9)
        val b6 = findViewById<Button>(R.id.b6)
        val b7 = findViewById<Button>(R.id.b7)
        val b8 = findViewById<Button>(R.id.b8)

        b1.setOnClickListener {
            buttonClick(b1)
        }

        b2.setOnClickListener {
            buttonClick(b2)
        }

        b3.setOnClickListener {
            buttonClick(b3)
        }

        b4.setOnClickListener {
            buttonClick(b4)
        }

        b5.setOnClickListener {
            buttonClick(b5)
        }

        b6.setOnClickListener {
            buttonClick(b6)
        }

        b7.setOnClickListener {
            buttonClick(b7)
        }

        b8.setOnClickListener {
            buttonClick(b8)
        }

        b9.setOnClickListener {
            buttonClick(b9)
        }


    }
       fun buttonClick(btn:Button){
            if (btn.text == "") {
                if (player == "p1") {
                    player = "p2"
                    btn.text = "X"
                } else {
                    player = "p1"
                    btn.text = "O"
                }
            }
        }
}