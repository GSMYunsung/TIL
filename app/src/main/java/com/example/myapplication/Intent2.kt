package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myapplication.kotlin.number

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val result: Button = findViewById(R.id.result)

        result.setOnClickListener {
            //default값 즉, 기본값을 넣어주지 않으면 오류가뜸
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number", "" + number1)
            Log.d("number", "" + number2)

            val result = number1 + number2

            val resultIntent = Intent()
            resultIntent.putExtra("result", result)
            //difine지정, -1값을 단순히 주지만 조금더 코드의 가독성을 높이기위해 사용

            setResult(Activity.RESULT_OK, resultIntent)
            //결과값을 result라는 값에 넣어줌.
            this.finish()
            //Activity 종료
            //Intent는 쌓여서 올라가는 Stack. 제일 먼저 실행된 Intent가 제일 밑으로 내려간다.

        }
    }

}