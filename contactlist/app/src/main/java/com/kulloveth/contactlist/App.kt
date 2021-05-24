package com.kulloveth.contactlist

import android.app.Application
import android.content.Context
import com.kulloveth.contactlist.data.Repository
import com.kulloveth.contactlist.data.db.UserDatabase

class App : Application() {

    val database by lazy { UserDatabase.getDatabase(this) }
    val repository by lazy { Repository(database.userDao()) }

    companion object {
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}