package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// tirar a too
      supportActionBar!!.hide()


        val buttonCriarConta = findViewById<Button>(R.id.button_criar_conta)

        buttonCriarConta.setOnClickListener { val abrirCadastro = Intent(this, CadastroUsuarioActivity::class.java)
            startActivity(abrirCadastro)
        }


    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.cadastro, menu)
//
//
//        return true
//    }

}