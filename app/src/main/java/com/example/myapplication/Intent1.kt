package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        var a = 10
        var b = a+10
        var c = a+10

        val change_activty : Button = findViewById(R.id.change_activty)

        change_activty.setOnClickListener{
            //첫번째가 이동하기전 activity, 두번째가 이동할려는 activity
            val intent = Intent(this@Intent1, Intent2::class.java)
            startActivity(intent)
        }
    }
}