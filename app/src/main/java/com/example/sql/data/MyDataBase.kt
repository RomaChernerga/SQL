package com.example.sql.data

import android.provider.BaseColumns

object MyDataBase: BaseColumns {
    const val TABLE_NAME = "PhoneBOOK"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_PHONE = "number"

    const val DATABASE_NAME = "SQL_PhoneNumbers.db"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME_NAME TEXT, " +
                "$COLUMN_NAME_PHONE TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}