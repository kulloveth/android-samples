package com.kulloveth.cocktailapp.data.api

import com.squareup.moshi.Json

data class CocktailInfoModel(
    @Json(name = "strDrink")
    val drinkName: String,
    @Json(name = "strDrinkThumb")
    val thumbNail: String,
    @Json(name = "idDrink")
    val id: String)
