package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.imcapp.utils.dataAtualBrasil
import java.time.LocalDate

class activity_pessagem : AppCompatActivity() {

    lateinit var textViewDataPesagem:TextView
    lateinit var spinnerNivelAtividade:Spinner
    lateinit var editTextNovoPeso: EditText
    lateinit var buttonRegistrarPeso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pessagem)


        textViewDataPesagem = findViewById(R.id.text_view_data_pessagem)
        editTextNovoPeso = findViewById(R.id.edit_text_novo_peso)
        spinnerNivelAtividade = findViewById(R.id.spinner_nivel_atividade)
        buttonRegistrarPeso = findViewById(R.id.button_registrar_peso)




        supportActionBar!!.hide()


        //// aparece a data atual
        textViewDataPesagem.text =  dataAtualBrasil()


        buttonRegistrarPeso.setOnClickListener {
            registrarPeso()
        }
    }

   private fun registrarPeso(){
       val cadastro = getSharedPreferences("cadastro", MODE_PRIVATE)
       val editor = cadastro.edit()

       editor.putString("data", dataAtualBrasil())
       editor.putString("peso",editTextNovoPeso.text.toString())
       editor.putInt("nivel",spinnerNivelAtividade.selectedItemPosition)

       editor.commit()

       Toast.makeText(this, "peso gravado com sucesso", Toast.LENGTH_SHORT).show()
       finish()

    }
}

