package com.kulloveth.contactlist.data

import com.kulloveth.contactlist.data.db.User
import com.kulloveth.contactlist.data.db.UserDao
import com.kulloveth.contactlist.data.db.UserDatabase
import kotlinx.coroutines.flow.Flow

class Repository(private val dao: UserDao) {

    suspend fun insertUser(user: User) = dao.insertUser(user)

     fun fetchUser(email: String) = dao.fetchUser(email)

    fun fetchAllUsers():Flow<List<User>> = dao.fetchAllUser()
}