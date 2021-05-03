package com.kulloveth.cocktailapp.data.api

class Repository(private val apiService: ApiService) {

  suspend fun getDrinks(category: String )= apiService.getDrinks(category)
}