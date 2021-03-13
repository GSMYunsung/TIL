package com.example.myapplication.kotlin

// 12.배열

// 배열이 필요한 이유
// - 똑같은 변수형을 한번에 많이 선언해야 할 일이 생길때필요
// But, 변수형식을 지정해주지 않는다면 다양한 변수형이 들어감



fun main(array: Array<String>){

    // 배열을 생성하는 방법(1)
    var group1 = arrayOf<Int>(1,2,3,4,5) // Int만 들어갈 수 있는 배열

    println(group1 is Array)

    //배열을 생성하는 방법(2)
    var number = 10
    //But, 변수형식을 지정해주지 않는다면 다양한 변수형이 들어갈 수있음
    var group2 = arrayOf(1,2,3.5,"Hello")

    //Index 란?
    // -> 순서(번째)
    // [1,2,3,4,5]
    // 0부터 시작

    // 배열의 값을 꺼내는 방법(1)
    println(group1.get(1))
    println(group1.get(0))

    // 배열의 값을 꺼내는 방법(2)
    val test3 = group1[0]
    println(test3)

    // 배열의 값을 바꾸는 방법(1)
    group1.set(0,100)
    println(group1[0])

    // 배열의 값을 바꾸는 방법(2)
    group1[0] = 200
    println(group1)
}