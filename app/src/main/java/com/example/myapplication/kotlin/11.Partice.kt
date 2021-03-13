package com.example.myapplication.kotlin

//11. 제어흐름 실습
//변수가 가지는 값의 모든 경우에 대응하는 조건을 걸어주는것이 좋다
//값을 리턴하는 when 구문의 경우 반드시 값을 리턴해야함

fun main(args: Array<String>){
    val value : Int? = null

    when(value){
        null -> println("value is null")
        else -> println("value is not null")
    }

    val value2 : Boolean? = null

    when (value2){
        true -> println("value is true")
        false -> println("value is false")
        null -> println("value is null")
    }

    //when의 값할당
   val value3 = when(value2){
        true -> 1
        false -> 3
        null -> 5
    }

    // 타입을 인식할 수있는 조건
    val value4: Int = 10
        when(value4) {
            is Int -> println("value4 is int") // 타입을 인식할 수있는 조건
            else -> println("value4 is int")
        }

    // n~m 사이의 값 인식 할 수 있는 조건
    val value5: Int = 87
    when (value5){
        in 60..70 -> println("value5 is 60-70")
        in 70..80 -> println("value5 is 70-80")
        in 80..90 -> println("value5 is 80-90")
    }
}
