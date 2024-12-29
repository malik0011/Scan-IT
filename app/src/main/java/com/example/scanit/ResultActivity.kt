package com.example.scanit

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.scanit.api.OpenFoodFactsService
import kotlinx.coroutines.launch

class ResultActivity : AppCompatActivity() {
    private lateinit var barcodeTextView: TextView
    private lateinit var productNameTextView: TextView
    private lateinit var productCategoryTextView: TextView
    private lateinit var caloriesTextView: TextView
    private lateinit var proteinTextView: TextView
    private lateinit var sugarTextView: TextView
    private lateinit var caloriesProgress: ProgressBar
    private lateinit var proteinProgress: ProgressBar
    private lateinit var sugarProgress: ProgressBar

    private val openFoodFactsService = OpenFoodFactsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        barcodeTextView = findViewById(R.id.barcode_text)
        productNameTextView = findViewById(R.id.product_name_text)
        productCategoryTextView = findViewById(R.id.product_category_text)
        caloriesTextView = findViewById(R.id.calories_text)
        proteinTextView = findViewById(R.id.protein_text)
        sugarTextView = findViewById(R.id.sugar_text)
        caloriesProgress = findViewById(R.id.calories_progress)
        proteinProgress = findViewById(R.id.protein_progress)
        sugarProgress = findViewById(R.id.sugar_progress)

        val barcode = intent.getStringExtra("barcode")
        barcodeTextView.text = "Scanned Barcode: $barcode"

        // Fetch nutritional information based on the barcode
        fetchNutritionalInfo(barcode)
    }

    private fun fetchNutritionalInfo(barcode: String?) {
        if (barcode == null) return

        lifecycleScope.launch {
            try {
                val response = openFoodFactsService.getProduct(barcode)
                val product = response.product

                // Update UI with real product information
                productNameTextView.text = "Product Name: ${product.name ?: "Unknown"}"
                productCategoryTextView.text = "Category: ${product.category ?: "Unknown"}"

                product.nutrients?.let { nutrients ->
                    // Update nutritional information
                    val calories = nutrients.calories?.toInt() ?: 0
                    val protein = nutrients.proteins?.toInt() ?: 0
                    val sugar = nutrients.sugars?.toInt() ?: 0

                    caloriesTextView.text = "Calories: $calories kcal"
                    proteinTextView.text = "Protein: $protein g"
                    sugarTextView.text = "Sugar: $sugar g"

                    // Update progress bars
                    caloriesProgress.progress = calories
                    proteinProgress.progress = protein
                    sugarProgress.progress = sugar

                    // Add additional nutritional information
                    val additionalInfo = StringBuilder()
                    nutrients.fat?.let { additionalInfo.append("\nFat: $it g") }
                    nutrients.carbohydrates?.let { additionalInfo.append("\nCarbohydrates: $it g") }
                    nutrients.fiber?.let { additionalInfo.append("\nFiber: $it g") }
                }
            } catch (e: Exception) {
                // Handle error
                Toast.makeText(this@ResultActivity, 
                    "Error fetching product information: ${e.message}", 
                    Toast.LENGTH_LONG).show()
            }
        }
    }
} 