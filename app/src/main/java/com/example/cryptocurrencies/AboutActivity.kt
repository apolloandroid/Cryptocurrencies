package com.example.cryptocurrencies

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button_rate_application.setOnClickListener { rateApplication() }
    }

    private fun rateApplication() {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("market://details?id=${applicationContext.packageName}")
        )
        startActivity(intent)
    }
}