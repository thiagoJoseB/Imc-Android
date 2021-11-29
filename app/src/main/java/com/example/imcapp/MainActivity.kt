package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btnEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// tirar a too
        supportActionBar!!.hide()

        /// instancia do botao entrar
        val buttonCriarConta = findViewById<Button>(R.id.button_criar_conta)

        editEmail = findViewById(R.id.edit_login_email)
        editSenha = findViewById(R.id.edit_login_senha)
        btnEntrar = findViewById(R.id.btn_entrar)


        btnEntrar.setOnClickListener {
            login()
        }

        buttonCriarConta.setOnClickListener {
            val abrirCadastro = Intent(this, CadastroUsuarioActivity::class.java)
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


    //// funcao de login
    private fun login() {
        //// arquivo que pega os dadso
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        val email = arquivo.getString("email", "")
        val senha = arquivo.getString("senha", "")


        //// validar se a senha esta certa
        if (editEmail.text.toString() == email && editSenha.text.toString() == senha){
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }else {
            Toast.makeText(this, "senha ou email errado", Toast.LENGTH_SHORT).show()
        }
    }

}


