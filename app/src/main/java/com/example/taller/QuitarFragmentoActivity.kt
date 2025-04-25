package com.example.taller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.widget.TextView
import android.widget.Button

class QuitarFragmentoActivity : AppCompatActivity() {

    private lateinit var inputTexto: TextInputLayout
    private lateinit var usernameField: TextInputEditText
    private lateinit var resultadoTextView: TextView
    private lateinit var eliminarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quitarfragmento)

        inputTexto = findViewById(R.id.inputTexto)
        usernameField = findViewById(R.id.username_field)
        resultadoTextView = findViewById(R.id.instrucciones)  // Se reutiliza el TextView para mostrar el resultado
        eliminarButton = findViewById(R.id.salida_olvido2)  // Asignamos el botón

        eliminarButton.setOnClickListener {
            val inputText = usernameField.text.toString()
            val result = quitarFragmento(inputText)
            resultadoTextView.text = result
        }
    }

    private fun quitarFragmento(cadena: String): String {
        // Validar si la cadena contiene al menos dos "h"
        if (cadena.count { it == 'h' } < 2) {
            return "Error: La cadena debe tener al menos dos 'h'."
        }

        // Encontrar las posiciones de la primera y la última 'h'
        val firstH = cadena.indexOf('h')
        val lastH = cadena.lastIndexOf('h')

        // Si la primera 'h' y la última 'h' son la misma, no hay nada que cortar
        if (firstH == lastH) {
            return cadena // Si solo hay dos letras h y no hay caracteres entre ellas, no cambiamos nada
        }

        // Crear la nueva cadena
        val newString = cadena.substring(0, firstH) + cadena.substring(lastH + 1)

        // Si el resultado es vacío o solo contiene espacios, lo validamos
        return if (newString.trim().isEmpty()) {
            "Error: No se puede eliminar todo el contenido."
        } else {
            newString
        }
    }
}
