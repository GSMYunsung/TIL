package com.example.myapplication.kotlin


var a = 1 + 2 + 3 + 4 + 5 //연산의 결과값을 변수에 넣어 줄 수있다.
var b = "1"
var c = b.toInt() // b를 Int형으로 변환 즉, 형변환 하겠다.
var d = b.toFloat() // b를 Flaot형으로 변환

var e = "John"
var f = "My name is $e Nice to meet you" //변수 e가 $e 자리에 들아간다.

//Null
//- 존재 하지 않는다. 즉, 비어있다.

//var abc : Int = null  null값이 int형 변수에 들어가지 못해 오류가 난다.
var abc1 : Int? = null // null을 가질 수 있는 자료형
var abc2 : Float? = null

fun main(args: Array<String>){
    println(a)
    println(b)
    println(c)
    println(d)
    println(f)

    println(abc1)
}