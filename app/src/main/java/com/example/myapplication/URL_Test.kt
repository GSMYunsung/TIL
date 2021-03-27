package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import org.w3c.dom.Text

class URL_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_r_l__test)

        val button : Button = findViewById(R.id.button)
        val editText : EditText = findViewById(R.id.URL)
        button.setOnClickListener {
            val addres = editText.text.toString()
            val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse(addres))
            startActivity(intent1)
        }

        // 텍스트가 실시간으로 바뀌는것을 인식함.
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }
        })
    }
}