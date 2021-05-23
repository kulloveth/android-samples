package com.kulloveth.contactlist.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("Select * from  users where `email-address` = :email ")
    fun fetchUser(email: String): User

    @Query("Select * from  users")
    fun fetchUser(): List<User>
}