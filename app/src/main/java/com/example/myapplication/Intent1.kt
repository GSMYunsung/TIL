package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.net.URI

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        var a = 10
        var b = a + 10
        var c = a + 10

        val change_activty: Button = findViewById(R.id.change_activty)
//
//         1.명시적 인텐트
//        change_activty.setOnClickListener{
//            //첫번째가 이동하기전 activity, 두번째가 이동할려는 activity
//            val intent = Intent(this@Intent1, Intent2::class.java)
//
//            //key, Value 방식 -> Key와 Value를 쌍으로 만들어 보내준다. (Dictionary)
//            intent.putExtra("number1",1)
//            intent.putExtra("number2",2)
//            startActivity(intent)

//          2.명시적 인텐트
        change_activty.setOnClickListener {
            val intent = Intent(this@Intent1, Intent2::class.java)
            // Apply -> [].apply : []의 기능을 묶어줘서 실행하겠다.
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            //startActivity(intent2) -> 전달만 하는 요청, 즉 값을 받아올 수 없음
            startActivityForResult(intent,300) // -> 전달을 받는 요청, intent화면 뒤에 값을 받아오는 이름코드를 작성해줘야함.
        }
//
//          1.암시적 인텐트
//        change_activty.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com/"))
//            startActivity(intent)
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            Log.d("number",""+requestCode)
            Log.d("number",""+resultCode)
            Log.d("number",""+data)
            val result = data?.getIntExtra("result",0)
            Log.d("number",""+result)
    }

}