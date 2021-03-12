package com.example.myapplication.kotlin

//02. 자료형
// 정수형 > Long > Int > Short > Byte
// 실수형 > Double > Float
// 문자형 > Char
// 문자열 > String
// 논리형(참 True/거짓 False) > Boolean

// 변수 선언하는 방법(1)
// 변수를 스스로 판단
// Variable/Value 변수형 = 값
// Var/val 변수명 = 값
var number = 10

//변수 선언하는 방법(2)
//var/val 변수 : 자료형 = 값
var number1 : Int = 20
var hello1 : String = "Hello"
var point1 : Double = 3.4

// Variable or Value ??
// 1.변하지 않는 값이라면? > Value
// 2. 변할지 안변할지 모르겠다 > Value >> Variable (바꿀일이 있을때)

fun main(args: Array<String>){
    number = 20
    //number = 20.5 기존에 선언한 변수형과 맞지 않기때문에 오류가난다.

}
