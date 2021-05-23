package com.kulloveth.contactlist.data

import com.kulloveth.contactlist.data.db.User
import com.kulloveth.contactlist.data.db.UserDatabase

class Repository(private val db: UserDatabase) {

    fun insertUser(user: User) = db.userDao().insertUser(user)

    fun fetchUser(email: String) = db.userDao().fetchUser(email)

    fun fetchAllUsers(): List<User> = db.userDao().fetchUser()
}