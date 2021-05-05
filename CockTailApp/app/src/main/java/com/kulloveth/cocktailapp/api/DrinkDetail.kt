package com.kulloveth.cocktailapp.api

import com.squareup.moshi.Json

data class DrinkDetail(
    @Json(name = "strDrink")
    val drinkName: String,
    @Json(name = "strDrinkThumb")
    val thumbNail: String,
    @Json(name = "idDrink")
    val id: String,

    @Json(name = "strInstructions")
    val instruction: String
)
