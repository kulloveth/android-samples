package com.kulloveth.cocktailapp.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kulloveth.cocktailapp.api.Repository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)){
            return MainFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("UNKNOWN CLASS")
    }

}