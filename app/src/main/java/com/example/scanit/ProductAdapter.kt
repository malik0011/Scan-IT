package com.example.scanit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
//
//    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val barcodeTextView: TextView = itemView.findViewById(R.id.barcode_text)
//        val nameTextView: TextView = itemView.findViewById(R.id.name_text)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
//        return ProductViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        val product = productList[position]
//        holder.barcodeTextView.text = product.barcode
//        holder.nameTextView.text = product.name
//    }
//
//    override fun getItemCount(): Int {
//        return productList.size
//    }
//}