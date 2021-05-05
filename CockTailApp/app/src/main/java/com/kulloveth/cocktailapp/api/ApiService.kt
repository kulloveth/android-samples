package com.kulloveth.cocktailapp.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

interface ApiService {

    @GET("1/filter.php")
    suspend fun getDrinks(@Query("a") category:String): DrinkResponse

    @GET("1/lookup.php?i=11007")
    suspend fun getDrinksDetail(@Query("i")id:String):DrinkDetailResponse
}

object Api {
    val apiService: ApiService by
    lazy {
        retrofit.create(ApiService::class.java)
    }
}