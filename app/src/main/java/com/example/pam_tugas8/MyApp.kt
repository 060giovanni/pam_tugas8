package com.example.pam_tugas8

import android.app.Application
import androidx.room.Room

class MyApp : Application() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this, AppDatabase::class.java, "my_database")
            .build()

        // Isi data dummy ke dalam database
        Thread {
            val userDao = database.userDao()
            userDao.insertUser(User(
                username = "John Doe", email = "john@example.com"))
            userDao.insertUser(User(
                username = "Jane Smith", email = "jane@example.com"))
            userDao.insertUser(User(
                username = "Mike Johnson", email = "mike@example.com"))
            userDao.insertUser(User(
                username = "Giovanni Lucy", email = "giovannilucy@example.com"))
            userDao.insertUser(User(
                username = "Andrew Garfield", email = "andrewgarfield@example.com"))
        }.start()
    }
}