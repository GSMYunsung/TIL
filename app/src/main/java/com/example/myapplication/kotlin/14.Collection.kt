package com.example.myapplication.kotlin

// 14. Collection

// -> list, set, map

fun main(args: Array<String>) {

    // Immutable Collection (변경이 불가능)
    // List
    // -> 중복을 허용한다
    val numberList = listOf<Int>(1, 2, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    // Set
    // -> 중복을 허용하지 않는다
    // -> 순서가 없다
    val numberSet = setOf<Int>(1,2,3,3,3)
    println(numberSet)

    //Map
    // -> Key,value 방식으로 관리한다
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println()
    println(numberMap.get("one"))


    // Mutable Collection (변경가능)
    val MnumberList = mutableListOf<Int>(1,2,3)
    MnumberList.add(3,4)
    println()
    println(MnumberList)

    val mNumberSet = mutableSetOf<Int>(1,2,3,4,4,4)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String,Int>("one" to 1)
    mNumberMap.put("Two",2)
    println(mNumberMap)

}