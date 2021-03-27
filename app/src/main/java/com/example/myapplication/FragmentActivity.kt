package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "F onCreate");
    }

        override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "F onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "F onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "F onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "F onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "F onDestroy");
    }


}