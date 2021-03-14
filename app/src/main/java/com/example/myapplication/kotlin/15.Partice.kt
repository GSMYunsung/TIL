package com.example.myapplication.kotlin

fun main(array : Array<String>){

    val a = mutableListOf<Int>(1,2,3)
    a.add(4) // index를 넣어주지 않는다면 맨뒤로 이동
    println(a)
    // 만약 추가할 칸에 인자가 있으면 기존 모든 인자들을
    // 우측으로 민다.
    a.add(0,100)
    println(a)
    // 만약 추가할 칸에 인자가 있더라도 기존 모든 인자들을
    // 우측으로 밀지 않는다.
    a.set(0,200)
    println(a)
    a.removeAt(1)
    println(a)

    val b = mutableSetOf<Int>(1,2,3,4)
    println()
    b.add(2) // 애당초 인덱스가 없다
    println(b)
    b.remove(2) // 있는 값의 경우만 지워짐
    println(b)

    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    c.put("two",2)
    println(c)
    c.replace("two", 3) //해당키에 다른 값 추가
    println(c)
    println(c.keys) // key만 모아보기
    println(c.values) // 값만 모아보기
    c.clear()
    println(c)

}