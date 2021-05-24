package com.kulloveth.contactlist.auth

import androidx.lifecycle.*
import com.kulloveth.contactlist.data.Repository
import com.kulloveth.contactlist.data.db.User
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: Repository) : ViewModel() {
     val allUserLiveData = repository.fetchAllUsers().asLiveData()


    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}