package com.example.myapplication.kotlin

// 08. 제어 흐름
//  - if, else


fun main(args: Array<String>){
    val a : Int = 5
    val b : Int = 10
//          0
    if(a > b){
//          1
        println("a가 b 보다 크다")
    }
    else{
//          2
        println("a 가 b 보다 작다")
    }
//          3
    //값을 리턴하는 if 사용방법
    val max = if (a > b){
        a // 5
    } else{
        b // 1
    }
    println()
    println(max)

}

