package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val buttonCriarConta = findViewById<Button>(R.id.button_criar_conta)

        buttonCriarConta.setOnClickListener { val abrirCadastro = Intent(this, CadastroUsuarioActivity::class.java)
        startActivity(abrirCadastro)
        }

    }
}