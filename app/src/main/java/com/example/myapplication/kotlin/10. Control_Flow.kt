package com.example.myapplication.kotlin

// 10 제어흐름

// When

fun main(args: Array<String>){
    val value: Int = 3

    when(value){
        1 ->
            println("value is 1") // c,c#등에서 사용되는 switch case문과 유사
        2->
            println("value is 2")
        3->
            println("value is 3")
        else->
            println("No date")
    }

    if (value == 1){
        println("value is 1")
    }
    else if(value == 2){
        println("value is 2")
    }else if(value == 3){
        println("value is 3")
    }
    else{
        println("No date")
    }

    //when 문이 값을 return 하는 경우

    val value2 = when(value){
        1 -> 10
        2 -> 20
        3 -> 30
        else -> 100
    }
    //만약 value값이 2라면 20이 return 된다.
    println(value2)
}