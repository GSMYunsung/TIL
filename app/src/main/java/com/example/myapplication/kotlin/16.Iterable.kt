package com.example.myapplication.kotlin

// 16. Iterable

fun main(array: Array<String>){
    val a = mutableListOf<Int>(1,2,3,4,5,6,7,8,9)


    // 반복하는 방법(1)
    for(item in a){
        if(item == 5){
            println("item is five")
        }
        else{
            println("item is not five")
        }
    }

    // 반복하는 방법(2)
    for((index, item) in a.withIndex()){
        println("index : " + index + "value : " + item)
    }

    // 반복하는 방법(3)
    // 기본이름으로 it이라는 이름이 된다.
    a.forEach{
        println(it)
    }

    // 반복하는 방법(4)
    // 이름을 변경할 수있다.
    a.forEach{item ->
        println(item)
    }

    // 반복하는 방법(5)
    // index값과 인자값을 같이 출력가능하다.
    a.forEachIndexed { index, item ->
        println("index : " + index + "value : " + item)
    }

    // 반복하는 방법(6)
    println(a.size)

    for(i in 0 until a.size){
        // until은 마지막을 포함 하지 않는다
        // 0 부터 8까지 이다. (끝에 들어가는 숫자 -1)
        // i의 값이 0이고 a.size의 크기 -1 만큼 돌아라
        println(a.get(i))
    }

    // 반복하는 방법(7)
    for(i in 0 until a.size step (2)){
        //증가하는 폭을 step으로 설정 가능
        println(a.get(i))
    }

    // 반복하는 방법(8)
    for (i in a.size -1 downTo (0))
        // 반대로 8부터 0까지 출력
        println(a.get(i))

    // 반복하는 방법(9)
    for (i in a.size -1 downTo (0) step (2))
        // 이 경우 역시 증가하는 폭을 step으로 설정 가능
        println(a.get(i))

    // 반복하는 방법(10)
    // ..은 마지막 수를 포함한다.
    for (i in 0..a.size){
        println(i)
    }

    // 반복하는 방법(11)
    var b: Int = 0
    var c: Int = 4


    while ( b < c ) {
        b++ // while문을 정지 시키기 위한 코드드
       println("b")
    }

    // 반복하는 방법(12)
    // 한번은 실행한다.

    var d: Int = 0
    var e: Int = 4


    do {
        println("hello")
        d++
    } while (d < e)
}