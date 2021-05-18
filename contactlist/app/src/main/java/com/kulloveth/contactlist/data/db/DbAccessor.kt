package com.kulloveth.contactlist.data.db

import androidx.room.Room
import com.kulloveth.contactlist.App

object DbAccessor {
    val db =
        Room.databaseBuilder(App.applicationContext(), UserDatabase::class.java, "user-database")
            .allowMainThreadQueries()
            .build()
}