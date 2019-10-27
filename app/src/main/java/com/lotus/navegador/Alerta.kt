package com.lotus.navegador

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View

class Alerta(contexto: Context, num: Int) {
    val meuContexto = contexto
    val inflater = LayoutInflater.from(meuContexto)
    val minhaView: View = inflater.inflate(num, null)

    fun abrir() {
        val builder = AlertDialog.Builder(meuContexto)
        builder.setView(minhaView)
        val construido = builder.create()
        construido.show()
    }

}