package com.lotus.navegador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_pesquisa.*
import android.webkit.*

class TelaPesquisa : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_pesquisa)

        // Get the web view settings instance
        val settings = wwvTelaNavegacao.settings

        // Enable java script in web view
        settings.javaScriptEnabled = true

        // Enable and setup web view cache
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setAppCachePath(cacheDir.path)

        // Enable zooming in web view
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        wwvTelaNavegacao.webViewClient = WebViewClient()
        wwvTelaNavegacao.loadUrl("https://bing.com")

        val listaSites = arrayListOf<String>()
        var index = 0
        //Acao botao pesquisar
        btnPesquisar.setOnClickListener {
            val textoPesquisa = edtBarraPesquisa.text.toString()
            if(!listaSites.contains(textoPesquisa)){
                listaSites.add(textoPesquisa)
            }
            index++
            wwvTelaNavegacao.loadUrl("https://${textoPesquisa}")

        }

        //Acao botao atualizar
        btnAtualizar.setOnClickListener {
            wwvTelaNavegacao.reload()
        }

        //Acao botao avancar
        btnAvancar.setOnClickListener {
            if(index != listaSites.size - 1 && listaSites.size != 0){
                var num = index +1
                wwvTelaNavegacao.loadUrl("https://${listaSites[num]}")
                edtBarraPesquisa.hint = listaSites[num]
                index++
            }
        }

        //Acao do botao voltar
        btnVoltar.setOnClickListener {
            if(index !=  0) {
                var num = index -1
                wwvTelaNavegacao.loadUrl("https://${listaSites[num]}")
                edtBarraPesquisa.hint = listaSites[num]
                index--
            }
        }


        //Acao do EdtPesquisar
        edtBarraPesquisa.setOnClickListener {
            edtBarraPesquisa.hint = ""
        }


        // Set web view client
        wwvTelaNavegacao.webViewClient = object : WebViewClient() {

            override fun onReceivedError(view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                var alerta = Alerta(this@TelaPesquisa, R.layout.alert)
                alerta.abrir()
                wwvTelaNavegacao.loadUrl("https://google.com")
            }
        }
    }


}
