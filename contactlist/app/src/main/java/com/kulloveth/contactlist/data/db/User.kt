package com.kulloveth.contactlist.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "name")
    val username: String,
    @ColumnInfo(name = "email-address")
    @PrimaryKey
    val email: String,
    val password: String
)
