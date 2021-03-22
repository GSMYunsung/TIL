package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.util.Log.d as d1

class Calculating_machine_ : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculating_machine_)

        var new_num = "0"
        var old_num = "0"
        var resulte = 0
        var sign = ""

        val number0 : TextView = findViewById(R.id.number0)
        val number1 : TextView = findViewById(R.id.number1)
        val number2 : TextView = findViewById(R.id.number2)
        val number3 : TextView = findViewById(R.id.number3)
        val number4 : TextView = findViewById(R.id.number4)
        val number5 : TextView = findViewById(R.id.number5)
        val number6 : TextView = findViewById(R.id.number6)
        val number7 : TextView = findViewById(R.id.number7)
        val number8 : TextView = findViewById(R.id.number8)
        val number9 : TextView = findViewById(R.id.number9)
        val main_num : TextView = findViewById(R.id.main_num)
        val plus : TextView = findViewById(R.id.plus)
        val minus : TextView = findViewById(R.id.minus)
        val multiply : TextView = findViewById(R.id.multiply)
        val division : TextView = findViewById(R.id.division)
        val ca : TextView = findViewById(R.id.CA)
        val result : TextView = findViewById(R.id.result)


        number0.setOnClickListener {
            new_num = new_num +"0"
            Log.d("num",new_num)
            main_num.text = new_num
        }
        number1.setOnClickListener {
            new_num = new_num +"1"
            main_num.text = new_num
        }
        number2.setOnClickListener {
            new_num = new_num +"2"
            main_num.text = new_num
        }
        number3.setOnClickListener {
            new_num = new_num +"3"
            main_num.text = new_num
        }
        number4.setOnClickListener {
            new_num = new_num +"4"
            main_num.text = new_num
        }
        number5.setOnClickListener {
            new_num = new_num +"5"
            main_num.text = new_num
        }
        number6.setOnClickListener {
            new_num = new_num +"6"
            main_num.text = new_num
        }
        number7.setOnClickListener {
            new_num = new_num +"7"
            main_num.text = new_num
        }
        number8.setOnClickListener {
            new_num = new_num +"8"
            main_num.text = new_num
        }
        number9.setOnClickListener {
            new_num = new_num +"9"
            main_num.text = new_num
        }
        ca.setOnClickListener {
            new_num = "0"
            main_num.text = new_num
        }
        plus.setOnClickListener {
            old_num = new_num
            new_num = "0"
            main_num.text = new_num
        }
        plus.setOnClickListener {
            sign = "+"
            old_num = new_num
            new_num = "0"
            main_num.text = new_num
        }
        minus.setOnClickListener {
            sign = "-"
            old_num = new_num
            new_num = "0"
            main_num.text = new_num
        }
        multiply.setOnClickListener {
            sign = "*"
            old_num = new_num
            new_num = "0"
            main_num.text = new_num
        }
        division.setOnClickListener {
            sign = "/"
            old_num = new_num
            new_num = "0"
            main_num.text = new_num
        }
        result.setOnClickListener {
            if(sign == "+"){
                resulte = (old_num).toInt() + new_num.toInt()
                main_num.text = resulte.toString()
            }

            else if(sign == "-"){
                resulte = (old_num).toInt() - new_num.toInt()
                main_num.text = resulte.toString()
            }

            else if(sign == "*"){
                resulte = (old_num).toInt() * new_num.toInt()
                main_num.text = resulte.toString()
            }

            else if(sign == "/"){
                resulte = (old_num).toInt() / new_num.toInt()
                main_num.text = resulte.toString()
            }
        }

    }
}