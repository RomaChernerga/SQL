package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sql.data.MyPhoneBookManager

class MainActivity : AppCompatActivity() {
    val dbManager= MyPhoneBookManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name_text = findViewById<EditText>(R.id.editText_name)
        val phone_text = findViewById<EditText>(R.id.editText_phone)
        val textView = findViewById<TextView>(R.id.textView)

        findViewById<Button>(R.id.btn_create).setOnClickListener {
//            dbManager.openDB()
//            dbManager.insertToDB(name_text.text.toString(), phone_text.text.toString())
//            val dataList = dbManager.readToBD()
//            for (i in arrayOf(dataList)) {
//                textView.append(i.toString())
//                textView.append("\n")
//            }
            dbManager.openDB()
            dbManager.insertToDB(name_text.text.toString(), phone_text.text.toString())
//            val dataList = dbManager.readDBData()
//            for (item in dataList) {
//                textView.append(item)
////                textView.append("\n")
//            }
        }

        findViewById<Button>(R.id.btn_update).setOnClickListener {

        }

        findViewById<Button>(R.id.btn_delete).setOnClickListener {
            dbManager.delete()
        }

        findViewById<Button>(R.id.btn_show).setOnClickListener {
            textView.text = ""
            dbManager.openDB()
            val dataList = dbManager.readDBData()
            for (item in dataList) {
                textView.append(item)
                textView.append("\n")
            }

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDB()
    }
}