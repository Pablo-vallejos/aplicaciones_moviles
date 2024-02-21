package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class Auth_Activity : AppCompatActivity() {

    private lateinit var SignUpButton: Button
    private lateinit var puntajesBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setup()
    }

    private fun setup(){

        title = "autenticacion"

        SignUpButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() && PassEditText.text.isNotEmpty())
            {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    emailEditText.text.toString(),PassEditText.text.toString())
                    .addOnCompleteListener{}

                if (it.isSuccessful){
                    showHome(it.result.user.email ?: "", ProviderType.BASIC)
                }else{
                    showAlert()
                }

            }

        }

        LoginButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() && PassEditText.text.isNotEmpty())
            {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    emailEditText.text.toString(),PassEditText.text.toString())
                    .addOnCompleteListener{}

                if (it.isSuccessful){
                    showHome(it.result.user.email ?: "", ProviderType.BASIC)
                }else{
                    showAlert()
                }

            }

        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType){
        val homeIntent = Intent(this, MainActivity::class.java){
            putExtra("emal", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)

    }

}