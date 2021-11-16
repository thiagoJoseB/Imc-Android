package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

class CadastroUsuarioActivity : AppCompatActivity() {

  /// iniciar tarde espear    variavel que tem o EditText
  lateinit var   editEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        editEmail = findViewById(R.id.edit_novo_email)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        ///R. == Recursos res , menu == pasta dentron da res
        menuInflater.inflate(R.menu.cadastro , menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // salvar os dados do usuario em um sharedPreferences
        /// criar um arquivo sharedPreferences
        //se o arquivo ja existir o arquivo sera aberto

                                         ///abrir o aplicativo em modo privado
        val dados = getSharedPreferences("cadastro" , MODE_PRIVATE)

        //criar um editor para o arquivo
        val editor = dados .edit()
        editor.putString("email" , editEmail.text.toString())
        editor.apply()




        return true
    }
}