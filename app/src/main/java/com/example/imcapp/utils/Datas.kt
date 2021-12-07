package com.example.imcapp.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun dataAtualBrasil(): String{


    //// obter a data atual ou seja hoje
    val hoje = LocalDate.now()

    //// determinar o formato da data brasileiro
    val formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    /// converter a data para brasil
    val hojeBrasil = hoje.format(formatoBrasil)

    return hojeBrasil
}