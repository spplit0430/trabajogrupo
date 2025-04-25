package com.example.taller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class DosMitadesActivity : AppCompatActivity() {

    private lateinit var inputTexto: TextInputEditText
    private lateinit var resultadoTexto: TextView
    private lateinit var btnProcesar: Button
    private lateinit var textoError: TextView  // NUEVO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dosmitades)

        inputTexto = findViewById(R.id.username_field)
        resultadoTexto = findViewById(R.id.resultado)
        btnProcesar = findViewById(R.id.btnProcesar)
        textoError = findViewById(R.id.textoError) // NUEVO

        // Navegación de los botones
        val navItem2 = findViewById<TextView>(R.id.nav_item_2)
        val navItem3 = findViewById<TextView>(R.id.nav_item_3)

        navItem2.setOnClickListener {
            // Redirigir a otra actividad (ejemplo: DosPalabrasActivity)
            val intent = Intent(this, DosPalabrasActivity::class.java)
            startActivity(intent)
        }

        navItem3.setOnClickListener {
            // Redirigir a otra actividad (ejemplo: QuitarFragmentoActivity)
            val intent = Intent(this, QuitarFragmentoActivity::class.java)
            startActivity(intent)
        }

        btnProcesar.setOnClickListener {
            try {
                val input = inputTexto.text.toString().trim()

                // Validación: vacío, solo espacios, o múltiples espacios entre palabras
                if (input.isEmpty() || input.contains("\\s{2,}".toRegex())) {
                    throw IllegalArgumentException("Cadena vacía o con espacios dobles")
                }

                val resultado = procesarCadena(input)
                resultadoTexto.text = "Resultado: $resultado"
                textoError.visibility = View.GONE // OCULTA el mensaje de error si estaba visible

            } catch (e: Exception) {
                textoError.visibility = View.VISIBLE // MUESTRA el mensaje de error
                resultadoTexto.text = "Resultado:"
            }

        }
    }

    private fun procesarCadena(cadena: String): String {
        val largo = cadena.length
        val mitad = (largo + 1) / 2
        val primeraMitad = cadena.substring(0, mitad)
        val segundaMitad = cadena.substring(mitad)
        return segundaMitad + primeraMitad
    }
}
