package com.example.scanit.api

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class ProductResponse(
    val product: Product,
    val status: Int
)

data class Product(
    @Json(name = "product_name") val name: String?,
    @Json(name = "categories") val category: String?,
    @Json(name = "nutriments") val nutrients: Nutrients?
)

data class Nutrients(
    @Json(name = "energy-kcal_100g") val calories: Double?,
    @Json(name = "proteins_100g") val proteins: Double?,
    @Json(name = "sugars_100g") val sugars: Double?,
    @Json(name = "fat_100g") val fat: Double?,
    @Json(name = "carbohydrates_100g") val carbohydrates: Double?,
    @Json(name = "fiber_100g") val fiber: Double?
)

interface OpenFoodFactsService {
    @GET("api/v0/product/{barcode}.json")
    suspend fun getProduct(@Path("barcode") barcode: String): ProductResponse

    companion object {
        private const val BASE_URL = "https://world.openfoodfacts.org/"

        fun create(): OpenFoodFactsService {
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

            return retrofit.create(OpenFoodFactsService::class.java)
        }
    }
} 