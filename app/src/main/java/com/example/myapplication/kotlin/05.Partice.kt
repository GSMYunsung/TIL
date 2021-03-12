package com.example.myapplication.kotlin

fun PlusTree(first : Int, Two : Int, Tree : Int) :Int {
//    val total : Int = first+Two+Tree
//    return total

    return first+Two+Tree
    //위와 동일하다
}

fun minusTree(first : Int, Two : Int, Tree : Int) = first-Two-Tree

fun mutiplyTree(first : Int=2, Two : Int=5, Tree : Int = 1): Int {
    return first * Two * Tree
}

// 내부 함수
// - 함수 안에 함수가 있다

fun showMyPlus(first: Int, second: Int): Int{
    println(first)
    println(second)

    return plus(first,second)

    fun plus(first: Int, second: Int) : Int{
        return first+second
    }
}

fun main(args: Array<String>){
    val result = PlusTree(1,2,3)
    println(result)
    val result1 = minusTree(12,2,4)
    println(result1)
    val result2 = mutiplyTree(5,2,3)
    println(result2)
    val result3 = mutiplyTree()
    println(result3)

}