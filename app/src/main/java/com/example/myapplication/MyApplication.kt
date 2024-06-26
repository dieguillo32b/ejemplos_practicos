package com.example.myapplication


import android.app.Application
import androidx.room.Room
import com.example.myapplication.database.AppDatabase

class MyApplication : Application() {
    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}
