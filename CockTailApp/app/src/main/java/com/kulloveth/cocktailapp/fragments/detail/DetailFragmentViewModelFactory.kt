package com.kulloveth.cocktailapp.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kulloveth.cocktailapp.api.Repository
import java.lang.IllegalArgumentException

class DetailFragmentViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(DetailFragmentViewModel::class.java)){
          return DetailFragmentViewModel(repository)as T
      }else{
          throw IllegalArgumentException("UNKNOWN CLASS")
      }
    }
}