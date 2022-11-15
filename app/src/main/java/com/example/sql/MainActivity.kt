package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.placeholder, RecViewFragment::class.java.newInstance())
                .commitNow()
        }


    }



}