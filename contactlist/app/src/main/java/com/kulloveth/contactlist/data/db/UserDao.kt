package com.kulloveth.contactlist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("Select * from  users where `email-address` = :email ")
    fun fetchUser(email: String): LiveData<User>

    @Query("Select * from  users order by name asc")
    fun fetchAllUser(): Flow<List<User>>
}