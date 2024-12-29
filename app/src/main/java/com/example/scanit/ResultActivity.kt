package com.example.scanit

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val barcode = intent.getStringExtra("barcode")
        val resultTextView = findViewById<TextView>(R.id.result_text)
        resultTextView.text = "Scanned Barcode: $barcode"
    }
} 