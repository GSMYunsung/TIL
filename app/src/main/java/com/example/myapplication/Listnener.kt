package com.example.myapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Listnener : AppCompatActivity() {

        var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listnener)


        // 뷰를 activity로 가져오는 방법

        //1. 직접 찾아서 가져온다.
        //  val textView : TextView = findViewById(R.id.hello)
        //2. xml을 import해서 가져온다.
        //  hello.

        val textView : TextView = findViewById(R.id.hey)
        val image : ImageView = findViewById(R.id.image)

        // 익명함수
        // 1. 람다방식
        textView.setOnClickListener{
            Log.d("click","Click!!")
        }

        // 2. 익명 함수 방식
        textView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d("click","Click")
            }
        })

        // 3. 이름이 필요한 경우(click)
        val click = object : View.OnClickListener{
            override fun onClick(p0: View?) {
                // Text가 클릭이 되면 Text를 바꿔줌
                textView.setText("안녕하세요!")
                image.setImageResource(R.drawable.dog)
                number += 10
                // Log는 string형이 인자값으로 들어가야하는데, int값이 들어가니까 오류발생
                // 좋은 방법은 아니지만, 문자열 + 출력값을 하게되면 string형으로 자동 형변환 되므로 급하게 사용해야할때 유용
                Log.d("number","" + number)
            }
        }

        textView.setOnClickListener(click)


        // View를 조작하는 함수들
        // View마다 쓸 수있는 Listneer가 각각 다르다.
        // 1. setText
        // 2. setImageResource
    }
}