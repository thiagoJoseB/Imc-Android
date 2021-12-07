package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {

    lateinit var textNome: TextView
    lateinit var textProfissao: TextView
    lateinit var textALtura: TextView
    lateinit var cardPesarAgora: CardView //// inicia ,


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        textNome = findViewById(R.id.text_nome)
        textALtura = findViewById(R.id.text_altura)
        textProfissao = findViewById(R.id.text_profissao)
        cardPesarAgora = findViewById(R.id.card_pesar_agora)//// pega o id


        cardPesarAgora.setOnClickListener{
            val abrirPessagem = Intent(this,activity_pessagem::class.java)
            startActivity(abrirPessagem)  //// criar a funcao
        }


//        btnEntrar = findViewById(R.id.btn_entrar)




        /// carregar os dados da sharedPreferences

        /// nos campos da dashbord

        //// abrir o arquivo cadastro
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        //// tirar a toobar
        supportActionBar!!.hide()

        /// pegar os dados do arquivo e jogar nos TextViews
        textNome.text = arquivo.getString("nome", "")
        textProfissao.text = arquivo.getString("profissao", "")
        textALtura.text = arquivo.getFloat("altura", 0.0f).toString()



    }
}