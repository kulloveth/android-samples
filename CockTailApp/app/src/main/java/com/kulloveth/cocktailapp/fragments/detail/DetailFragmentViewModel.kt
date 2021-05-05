package com.kulloveth.cocktailapp.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kulloveth.cocktailapp.api.DrinkDetail
import com.kulloveth.cocktailapp.api.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailFragmentViewModel(private val repository: Repository):ViewModel() {

    private val _detailLivedata = MutableLiveData<List<DrinkDetail>>()

    val detailLiveData:LiveData<List<DrinkDetail>>
    get() = _detailLivedata

    fun fetchDetails(id:String){
        viewModelScope.launch {
            try {
                _detailLivedata.value = repository.getDrinksDetail(id).drinks
            }catch (e:Exception){

            }
        }
    }



}
