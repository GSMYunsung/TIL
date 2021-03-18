package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // 내가 만든화면을 activity_main대신 내 프로젝트로 넣어주면
    // 그 화면을 실행한다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.youtube_clone_layout)
    }
}
