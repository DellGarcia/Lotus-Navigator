package com.lotus.navegador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        handler.postDelayed(Runnable { mostrarMainActivity() }, 4000)

    }

    private fun mostrarMainActivity() {
        val intent = Intent(
            this@MainActivity, TelaPesquisa::class.java
        )
        startActivity(intent)
        finish()
    }
}
