package com.kulloveth.cocktailapp.fragments.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kulloveth.cocktailapp.api.CocktailInfoModel
import com.kulloveth.cocktailapp.api.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainFragmentViewModel(private val repository: Repository) : ViewModel() {

    private val _drinksLiveData = MutableLiveData<List<CocktailInfoModel>>()

    val drinksLiveData: LiveData<List<CocktailInfoModel>>
        get() = _drinksLiveData

    init {
        fetDrinks()
    }

  private  fun fetDrinks() {
        viewModelScope.launch {
            try {
                val result = repository.getDrinks("Alcoholic")
                _drinksLiveData.value = result.drinks
                Log.d(MainFragmentViewModel::class.java.simpleName, "${result.drinks}")
            } catch (e: Exception) {
                Log.e(MainFragmentViewModel::class.java.simpleName, e.message.toString())
            }

        }
    }
}