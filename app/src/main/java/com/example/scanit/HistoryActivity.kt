package com.example.scanit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryActivity : AppCompatActivity() {
//    private lateinit var productDao: ProductDao
//    private lateinit var productList: List<Product>
//    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

//        val db = Room.databaseBuilder(applicationContext, ProductDatabase::class.java, "product-db").build()
//        productDao = db.productDao()
//
//        recyclerView = findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // Load products from Room and display in RecyclerView
//        CoroutineScope(Dispatchers.IO).launch {
//            productList = productDao.getAllProducts() // This should be done in a coroutine
//            withContext(Dispatchers.Main) {
//                recyclerView.adapter = ProductAdapter(productList)
//            }
//        }
    }
}