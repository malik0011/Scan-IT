package com.example.scanit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator

class ScannerActivity : AppCompatActivity() {
//    private lateinit var productDao: ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)

//        val db = Room.databaseBuilder(applicationContext, ProductDatabase::class.java, "product-db").build()
//        productDao = db.productDao()

        findViewById<Button>(R.id.scan_button).setOnClickListener {
            // Start scanning activity with auto-focus enabled
            val intent = IntentIntegrator(this)
            intent.setOrientationLocked(false)
            intent.setBeepEnabled(true) // Optional: Enable beep sound on scan
            intent.setPrompt("Place a barcode inside the rectangle to scan it") // Optional: Set prompt message
            intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES) // Set desired barcode formats
            intent.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                // Process scanned barcode
                val barcode = result.contents
                // Fetch product details and save to Room
//                val product = Product(barcode = barcode, name = "Sample Product", category = "Food") // Example data
//                productDao.insert(product)
                
                // Navigate to ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("barcode", barcode)
                startActivity(intent)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
} 