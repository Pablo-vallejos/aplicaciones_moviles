package com.example.myapplication

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


class MainActivity : AppCompatActivity() {
    private var player="p1"
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var resultado: TextView


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
        val btnReset = findViewById<Button>(R.id.btnReset)
        resultado = findViewById(R.id.resultado)

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

        btnReset.setOnClickListener {
            reset()
        }

    }
       private fun buttonClick(btn:Button){
            if (btn.text == "") {
                if (player == "p1") {
                    player = "p2"
                    btn.text = "X"
                } else {
                    player = "p1"
                    btn.text = "O"
                }
            }
           win()
        }

        fun win(){

            // HORIZONTALES
            if((b1.text == "X" && b2.text == "X" && b3.text == "X")
                ||(b4.text == "X" && b5.text == "X" && b6.text == "X")
                ||(b7.text == "X" && b8.text == "X" && b9.text == "X")
                // DIAGONALES
                ||(b1.text == "X" && b5.text == "X" && b9.text == "X")
                ||(b7.text == "X" && b5.text == "X" && b3.text == "X")
                //VERITACALES
                ||(b1.text == "X" && b4.text == "X" && b7.text == "X")
                ||(b2.text == "X" && b5.text == "X" && b8.text == "X")
                ||(b3.text == "X" && b6.text == "X" && b9.text == "X")
                ){
                toast("X GANO")
                disableButtons()
                resultado.text="X GANO"
            } else if (
                (b1.text == "O" && b2.text == "O" && b3.text == "O")
                ||(b4.text == "O" && b5.text == "O" && b6.text == "O")
                ||(b7.text == "O" && b8.text == "O" && b9.text == "O")
                // DIAGONALES
                ||(b1.text == "O" && b5.text == "O" && b9.text == "O")
                ||(b7.text == "O" && b5.text == "O" && b3.text == "O")
                // VERTICALES
                ||(b1.text == "O" && b4.text == "O" && b7.text == "O")
                ||(b2.text == "O" && b5.text == "O" && b8.text == "O")
                ||(b3.text == "O" && b6.text == "O" && b9.text == "O")
            ){
                toast("O GANO")
                disableButtons()
                resultado.text="O GANO"
            } else {
                if( b1.text != "" && b2.text != "" && b3.text != "" && b4.text != "" &&
                    b5.text != "" && b6.text != "" && b7.text != "" && b8.text != "" &&
                    b9.text != ""
                    )
                    toast("Empate")
                    resultado.text="Empataron"

            }
        }


        fun toast(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }

        fun reset(){
            b1.text = ""
            b2.text = ""
            b3.text = ""
            b4.text = ""
            b5.text = ""
            b6.text = ""
            b7.text = ""
            b8.text = ""
            b9.text = ""
            b1.isEnabled = true
            b2.isEnabled = true
            b3.isEnabled = true
            b4.isEnabled = true
            b5.isEnabled = true
            b6.isEnabled = true
            b7.isEnabled = true
            b8.isEnabled = true
            b9.isEnabled = true
        }

        fun disableButtons(){
            b1.isEnabled = false
            b2.isEnabled = false
            b3.isEnabled = false
            b4.isEnabled = false
            b5.isEnabled = false
            b6.isEnabled = false
            b7.isEnabled = false
            b8.isEnabled = false
            b9.isEnabled = false
        }
}