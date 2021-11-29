package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.util.*

class CadastroUsuarioActivity : AppCompatActivity() {

  /// iniciar tarde espear    variavel que tem o EditText
  lateinit var   editEmail: EditText
    lateinit var   editSenha: EditText
    lateinit var   editNome: EditText
    lateinit var   editAltura: EditText
    lateinit var   editProfissao: EditText
    lateinit var   editDataNascimento: EditText
    lateinit var   radioMasculino: RadioButton
    lateinit var   radioFeminino: RadioButton





   ///// ids dos campos de texto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        editEmail = findViewById(R.id.edit_novo_email)
        editSenha = findViewById(R.id.edit_novo_senha)
        editNome = findViewById(R.id.edit_novo_nome)
        editProfissao = findViewById(R.id.edit_novo_profissao)
        editDataNascimento = findViewById(R.id.edit_novo_dataNascimento)
        editAltura = findViewById(R.id.edit_novo_altura)
        radioFeminino = findViewById(R.id.radio_feminino)
        radioMasculino = findViewById(R.id.radio_masculino)


       //// abrir um calendario ao clicar ao campo de nascimento
       editDataNascimento.setOnClickListener{
           abrirCalendario()

       }


    }

    private fun abrirCalendario() {
        ////pode ser Calendar do java ou android
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

       val datePickerDialog = DatePickerDialog(
               this,
               DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                  var mesFinal = ""

                   if (month < 9) {
                       mesFinal = "0${month + 1}"
                   }else{
                       mesFinal = "${month + 1}"
                   }

                   var  diaFinal = ""
                   if (dayOfMonth < 10){
                       diaFinal = "0$dayOfMonth"
                   }else{
                       diaFinal = "$dayOfMonth"
                   }


                   editDataNascimento.setText("$dayOfMonth/$mesFinal/$year")

               }, ano , mes, dia)

        datePickerDialog.show()

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
        editor.putString("senha" , editSenha.text.toString())
        editor.putString("nome" , editNome.text.toString())
        editor.putFloat("altura" , editAltura.text.toString().toFloat())
        editor.putString("nascimento" , editDataNascimento.text.toString())
        editor.putString("profissao" , editProfissao.text.toString())
        editor.putString("sexo" ,if (radioFeminino.isChecked) "F" else "M")
        editor.apply()

        /// mostra mensagem depois do cadastro salvo com sucesso
        Toast.makeText(this, "Usuario Cadastrado com sucesso", Toast.LENGTH_SHORT).show()

        /// finalizar deois de salvar (sai da tela de cadastro e vai pra main)
        finish()



        return true
    }
}