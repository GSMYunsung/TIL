package com.example.myapplication.kotlin

// 20. 접근 제어자
// 특정상황에서만 필요하고, 나머지 상황에서는 필요 없을 때
// 특정 사용자에게 굳이 공개를 안하려고 쓴다.

fun main(array: Array<String>){

    val testClass : TestAccess = TestAccess("최윤성")
    testClass.test()
    println(testClass.name)
    testClass.name = "최윤성 클론"
    println(testClass.name)

    //사용자가 임의적으로 쉽게 바꿀 수 있는 문제가 발생한다.
}

class TestAccess{
    var name : String = "홍길동"
    // private var name : String = "홍길동"
    // 다른클래스에서의 접근 차단

    constructor(name : String){
        this.name = name
    }

    fun test(){
        println("테스트")
    }
}