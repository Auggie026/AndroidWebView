package com.example.androidwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.androidwebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val link = "https://mhrise.kiranico.com"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* binding.webView.apply {
            loadUrl(link)
        }*/

       // myHtml()

        turnYourWebSiteIntoAndroidApp()
    }

    private fun turnYourWebSiteIntoAndroidApp(){

        binding.webView.apply {

            webViewClient = WebViewClient()
            loadUrl(link)

            settings.apply {
                javaScriptEnabled = true
                setAppCacheEnabled(true)
                cacheMode = WebSettings.LOAD_DEFAULT
                setSupportZoom(false)
                builtInZoomControls = false
                displayZoomControls = false
                textZoom = 100
                blockNetworkImage = false
                loadsImagesAutomatically = true
            }
        }.canGoBack()
    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()){
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    private fun myHtml(){

        val customHtml = "<html><body>" +
                "<h1>Hello There</h1>" +
                "<h2>Heading 2</h2>" +
                "<h3>Heading 3</h3>" +
                "<p>This is a sample <br>paragraph of your</br> custom Html...</p>" +
                "</html></body>"


        binding.webView.apply {
            loadData(customHtml,
            "text/html",
            "UTF-8")
        }
    }
}