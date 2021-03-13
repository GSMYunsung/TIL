package com.example.myapplication.kotlin

fun main(array: Array<String>){
    val array = arrayOf<Int>(1,2,3)

    //get, set
    val number = array.get(0)
    println(number)
    val number1 = array.get(100)
    //array배열 크기보다 더 큰 주소에서 가져오기 때문에 오류가난다.

    array.set(0,100)
    val number2 = array.get(0)
    println(number2)

    array.set(100,100)

    // Array 의 Bounds
    // - 처음 만들때 결정 된다

    // 변수 형식을 정해주는 Array를 만드는 방법
    val al = intArrayOf(1,2,3)
    val a2 = charArrayOf('A','B','C')
    val a3 = doubleArrayOf(1.2,100.345)
    val a4 = booleanArrayOf(true,false,true)

    //Array를 만드는 방법 -> lambda를 활용한 방법
    var a5 = Array(10,{ 0 })
    var a6 = Array(5,{1;2;3;4;5})

}