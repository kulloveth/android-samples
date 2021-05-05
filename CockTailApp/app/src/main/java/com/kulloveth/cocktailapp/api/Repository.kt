package com.kulloveth.cocktailapp.api

import com.kulloveth.cocktailapp.api.ApiService

class Repository(private val apiService: ApiService) {

  suspend fun getDrinks(category: String )= apiService.getDrinks(category)

  suspend fun getDrinksDetail(id:String) = apiService.getDrinksDetail(id)
}