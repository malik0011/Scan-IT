package com.example.scanit

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoImage = findViewById<ImageView>(R.id.splash_logo)
        val titleText = findViewById<TextView>(R.id.splash_title)

        // Load animations
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)

        // Apply animations
        logoImage.startAnimation(fadeIn)
        titleText.startAnimation(slideUp)

        // Navigate to Scanner activity after delay
        logoImage.postDelayed({
            startActivity(Intent(this, ScannerActivity::class.java))
            finish()
        }, 2000)
    }
} 