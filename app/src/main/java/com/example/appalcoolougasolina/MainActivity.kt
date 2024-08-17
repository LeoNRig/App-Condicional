package com.example.appalcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputLayout: TextInputLayout
    private lateinit var edit1: TextInputEditText

    private lateinit var textInputLayout2: TextInputLayout
    private lateinit var edit2: TextInputEditText

    private lateinit var btn_calcula: Button

    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InicializarComponentesInterface()
        btn_calcula.setOnClickListener{
            calculaMelhorPreco()
        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {
        textInputLayout.error = null
        textInputLayout2.error = null

        if (pAlcool.isNotEmpty()){
            textInputLayout.error = "Digite o preço do Alcool"
            return false
        } else if (pGasolina.isNotEmpty()){
            textInputLayout2.error = "Digite o preço da Gasolina"
            return false
        }


        return true
    }

    private fun calculaMelhorPreco() {
        val precoAlcool = edit1.text.toString()
        val precoGasolina = edit1.text.toString()

        val resultado = validarCampos(precoAlcool, precoGasolina)
        if (resultado){
            val precoAlcoolNumero = precoAlcool.toDouble()
            val precoGasolinaNumero = precoAlcool.toDouble()
            val resultado = precoAlcoolNumero / precoGasolinaNumero

            if (resultado >= 0.7){
                textResultado.text = "Melhor Usar gasolina"
            }else {
                textResultado.text = "Melhor Usar Alcool"
            }
        }
    }

    private fun InicializarComponentesInterface() {
        textInputLayout = findViewById(R.id.textInputLayout)
        edit1 = findViewById(R.id.Edit1)

        textInputLayout2 = findViewById(R.id.textInputLayout2)
        edit2 = findViewById(R.id.Edit2)
    }
}