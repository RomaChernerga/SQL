package com.example.sql.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class MyPhoneBookManager(context: Context) {
    private val dbHelper = MyPhoneBookHelper(context)
    var db: SQLiteDatabase? = null

        // для открытия
    fun openDB() {
            db = dbHelper.writableDatabase
    }
    fun closeDB() {
        dbHelper.close()
    }

    // для записи
    fun insertToDB(name: String, phone: String) {
        val values = ContentValues().apply {
            put(MyDataBase.COLUMN_NAME_NAME, name)
            put(MyDataBase.COLUMN_NAME_PHONE, phone)
        }
        db?.insert(MyDataBase.TABLE_NAME, null, values)
    }
    fun readDBData(): ArrayList<String> {

        val dataList = ArrayList<String>()

        val cursor = db?.query(MyDataBase.TABLE_NAME, null, null, null, null, null, null)

        while(cursor?.moveToNext()!!) {
            val dataText = "name: " + cursor.getString(cursor.getColumnIndexOrThrow(MyDataBase.COLUMN_NAME_NAME)) + " " +
                    "phone: " + cursor.getString(cursor.getColumnIndexOrThrow(MyDataBase.COLUMN_NAME_PHONE))
            dataList.add(dataText)
        }
        cursor.close()
        return dataList

//        val db = dbHelper.readableDatabase
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        val projection = arrayOf(BaseColumns._ID, MyDataBase.COLUMN_NAME_NAME, MyDataBase.COLUMN_NAME_PHONE)
//
//        // Filter results WHERE "title" = 'My Title'
//        val selection = "${MyDataBase.COLUMN_NAME_NAME} = ?"
//        val selectionArgs = arrayOf("My Phones")
//
//        // How you want the results sorted in the resulting Cursor
//        val sortOrder ="${MyDataBase.COLUMN_NAME_PHONE} DESC"
//
//        val cursor = db.query(
//            MyDataBase.TABLE_NAME,      // The table to query
//            projection,                 // The array of columns to return (pass null to get all)
//            selection,                  // The columns for the WHERE clause
//            selectionArgs,              // The values for the WHERE clause
//            null,               // don't group the rows
//            null,                // don't filter by row groups
//            sortOrder                   // The sort order
//        )
//        val itemIds = mutableListOf<Long>()
//        with(cursor) {
//            while (moveToNext()) {
//                val itemId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
//                itemIds.add(itemId)
//            }
//        }
//        cursor.close()
    }
    fun delete() {
        db?.delete(MyDataBase.TABLE_NAME, null, null)
    }
    fun update() {
        val db = dbHelper.writableDatabase

        val name = "MyNewName"
        val values = ContentValues().apply {
            put(MyDataBase.COLUMN_NAME_NAME, name)
        }
        // Which row to update, based on the title
        val selections = "${MyDataBase.TABLE_NAME} LIKE ?"
        val selectionArgs = arrayOf("MyOldName")
        val count = db.update(
            MyDataBase.TABLE_NAME,
            values,
            selections,
            selectionArgs
        )
    }





}