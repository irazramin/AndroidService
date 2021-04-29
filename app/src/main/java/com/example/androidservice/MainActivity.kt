package com.example.androidservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var myService:Intent?=null
    var startBtn:Button?=null
    var stopBtn:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startServiceId)
        stopBtn = findViewById(R.id.stopServiceId)
        Log.d("TAG", "onCreate: ${Thread.currentThread().id}")
        myService = Intent(this,MyService::class.java)
        startBtn?.setOnClickListener {
            startService(myService)

        }
        stopBtn?.setOnClickListener {
            stopService(myService)
        }


    }
}