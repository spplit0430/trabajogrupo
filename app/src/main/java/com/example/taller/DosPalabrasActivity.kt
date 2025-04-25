package com.example.taller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class DosPalabrasActivity : AppCompatActivity() {

    private lateinit var saludoTextView: TextView
    private lateinit var instruccionesTextView: TextView
    private lateinit var inputTexto: TextInputLayout
    private lateinit var usernameField: TextInputEditText
    private lateinit var botonProcesar: Button
    private lateinit var resultadoTextView: TextView
    private lateinit var navItem1: TextView
    private lateinit var navItem2: TextView
    private lateinit var navItem3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dospalabras)

        // Inicializar vistas
        saludoTextView = findViewById(R.id.saludo)
        instruccionesTextView = findViewById(R.id.instrucciones)
        inputTexto = findViewById(R.id.inputTexto)
        usernameField = findViewById(R.id.username_field)
        botonProcesar = findViewById(R.id.botonProcesar)
        resultadoTextView = findViewById(R.id.resultado)
        navItem1 = findViewById(R.id.nav_item_1)
        navItem2 = findViewById(R.id.nav_item_2)
        navItem3 = findViewById(R.id.nav_item_3)

        // Mostrar saludo al usuario
        saludoTextView.text = "Hola alejing@gmail.com"

        // Instrucciones iniciales
        instruccionesTextView.text = """
            Te voy a ayudar a solucionar el problema de las 2 palabras.

            1. Ingresa una cadena de caracteres.
            2. Te ayudaré a cortarla en dos mitades.
            3. Te mostraré la nueva cadena con las mitades invertidas.
        """.trimIndent()

        // Acción del botón Procesar
        botonProcesar.setOnClickListener {
            val textoIngresado = usernameField.text.toString()

            if (textoIngresado.isNotEmpty()) {
                val resultado = procesarCadena(textoIngresado)
                resultadoTextView.text = "Resultado: $resultado"
            } else {
                resultadoTextView.text = "Por favor ingresa una cadena de caracteres."
            }
        }

        // Configurar los íconos de la barra inferior
        navItem1.setOnClickListener {
            // Acción para "Dos mitades"
            resultadoTextView.text = "Has seleccionado 'Dos mitades'."
        }

        navItem2.setOnClickListener {
            // Acción para "Dos palabras"
            resultadoTextView.text = "Has seleccionado 'Dos palabras'."
        }

        navItem3.setOnClickListener {
            // Acción para "Quitar fragmento"
            resultadoTextView.text = "Has seleccionado 'Quitar fragmento'."
        }
    }

    // Función para procesar la cadena de caracteres
    private fun procesarCadena(cadena: String): String {
        val mitad = cadena.length / 2
        val primeraMitad = cadena.substring(0, mitad)
        val segundaMitad = cadena.substring(mitad)

        return segundaMitad + primeraMitad
    }
}
