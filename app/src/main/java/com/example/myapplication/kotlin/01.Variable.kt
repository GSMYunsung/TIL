package com.example.myapplication.kotlin

// 01. Variable > 변수

//상자에다가 내가 원하는것을 넣고 필요할 때 가져다 쓰는것
// > 만약 변수를 사용하지 않는다면 계속 불필요한 계산을 하게된다.

//        - 내 마음대로 원하는 것을 넣을 수 있는 상자 > Variable
//        - 한번 넣으면 값을 바꿀 수 없는 상자 > Value

// 변수 선언하는 방법
// var/val 변수명(상자) = 값(넣고 싶은 것 )
// Variable/Value

//C# 언어의 Object 형태와 유사

var num = 10;
var hello = "hello"
var point = 3.4

val fix = 20


fun main(args:Array<String>){
    println(num)
    println(hello)
    println(point)
    println(fix)

    num = 100 // 값 재할당
    hello = "Good bye"

    println(num)
    println(hello)
    println(point)
    println(fix)

    //fix = 500 // Val cannot be reassigned 오류 즉, Val 형식은 재할당 될 수없다.

}