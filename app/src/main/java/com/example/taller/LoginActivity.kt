package com.example.taller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameField = findViewById(R.id.username_field)
        passwordField = findViewById(R.id.password_field)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            val email = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login exitoso (simulado)", Toast.LENGTH_SHORT).show()

                // Redirigir a la siguiente pantalla
                val intent = Intent(this, DosMitadesActivity::class.java)
                startActivity(intent)
                finish() // Opcional: para que no puedan volver al login con el botón "Atrás"
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
