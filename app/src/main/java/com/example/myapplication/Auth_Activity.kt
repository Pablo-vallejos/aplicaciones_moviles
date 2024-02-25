package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent;
class Auth_Activity : AppCompatActivity() {

    private lateinit var SignUpButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var PassEditText: EditText
    private lateinit var LoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        emailEditText   = findViewById(R.id.emailEditText)
        PassEditText    = findViewById(R.id.PassEditText)
        SignUpButton    = findViewById(R.id.SignUpButton)
        LoginButton    = findViewById(R.id.LoginButton)

        setup()
    }

    private fun setup(){

        title = "autenticacion"

        SignUpButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() && PassEditText.text.isNotEmpty())
            {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    emailEditText.text.toString(),PassEditText.text.toString())
                    .addOnCompleteListener{

                if (it.isSuccessful){
                    showHome(it.result.user?.email ?: "", ProviderType.BASIC)
                }else{
                    showAlert()
                }

            }

        }}

        LoginButton.setOnClickListener{
            val email = emailEditText.text.toString()
            val password = PassEditText.text.toString()

            if(emailEditText.text.isNotEmpty() && PassEditText.text.isNotEmpty())
            {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {

                        if (it.isSuccessful){
                    showHome(it.result.user?.email ?: "", ProviderType.BASIC)
                }else{
                    showAlert()
                }

            }

        }}
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

}