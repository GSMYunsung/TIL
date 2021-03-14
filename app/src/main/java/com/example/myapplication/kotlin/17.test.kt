package com.example.myapplication.kotlin

// 1번 문제
// List를 두개 만든다
// 첫번째 ArrayList에는 0 부터 9까지 값을 넣는다. (반복문 사용)
// 두번째 ArrayListd에는 첫번째 ArrayList의 값을 하나씩 확인후
// 짝수면 True 홀수면 False를 넣어 준다.

// 2번 문제
// 학점을 구하자
// 80 - 90 -> A
// 70 - 79 -> B
// 60 - 69 -> C
// else -> D

// 3번 문제
// 두자리 숫자를 입력해 두자리 숫자를 각각 더하는 함수
// ex) 89 -> 17 / 18 -> 9 / 58 -> 13

// 4번 문제
// 구구단을 출력하는 함수를 만들어보자!

fun main(array: Array<String>){

     println(first())
     println(second(80))
     println(third(89))
    println()
     gugudan()
}

fun first(){
    val list1 = MutableList(9,{ 0 })
    val list2 = MutableList(9, {true})

    for(i in 0..8){
        list1[i] = i+1
    }
    println(list1)

    list1.forEachIndexed { index, value ->
        if (value % 2 == 0){
            list2[index] = true
        }
        else {
            list2[index] = false
        }
    }
    println(list2)
}

fun second(second: Int): String{
       when(second){
           in 80..90 -> return "A"
           in 70..80 -> return "B"
           in 60..70 -> return "C"
           else -> return "F"
       }
}

fun third(num : Int) : Int{
    var ten = num / 10
    var one = num % 10
    return ten+one
}

fun gugudan(){
    var i = 1
    var v = 1
//    while(i < 10){
//        while(v < 10){
//            println(""+ i + "X" + v + "=" + i*v)
//            v++
//        }
//        i++
//        v=1
//    }
    for(i in 1 until 10){
        for(v in 1 until 10){
            println(""+ i + "X" + v + "=" + i*v)
        }
       v=1
    }
}

