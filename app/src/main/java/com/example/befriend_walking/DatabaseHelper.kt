package com.example.befriend_walking

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DBNAME, null, VERSION) {
    companion object {
        private const val DBNAME = "user.sqlite"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            it.execSQL("CREATE TABLE user ( " + "name TEXT, pass TEXT, age TEXT, gender TEXT, hobby TEXT, latitude FLOAT, longitude FLOAT)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.let {
            it.execSQL("DROP TABLE IF EXISTS user")
            onCreate(it)
        }
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }
}
