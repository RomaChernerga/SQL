package com.example.sql.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyPhoneBookHelper(context: Context) : SQLiteOpenHelper(context, MyDataBase.DATABASE_NAME, null, MyDataBase.DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(MyDataBase.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        p0?.execSQL(MyDataBase.SQL_DELETE_TABLE)
        onCreate(p0)
    }
}