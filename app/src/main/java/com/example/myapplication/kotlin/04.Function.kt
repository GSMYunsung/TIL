package com.example.myapplication.kotlin


// 04. Function
//- 함수
//      - 어떤 input을 넣어주면 어떤 output이 나오는것
//      - y = x + 2

// - 함수를 선언하는 방법
// fun 함수명 (변수명 : 타입, 변수명 : 타입 ....) : 변환형 {
//       ~~~~함수내용~~~~~~~
//       return 반환값
//  }

//인자값 즉,메서드를 받아오고 변환형은 따로 output

fun plus(first: Int, second: Int): Int {
    println(first)
    println(second)
    val result: Int = first + second
    println(result)
    return result
}

// - 디폴트 값을 갖는 함수 만들기
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result
}

// - 반환값이 없는 함수 만들기
fun printPlus(first: Int, second: Int): Unit {
    val result: Int = first + second
    print(result)
}

fun printPlus2(first: Int, second: Int) {
    //반환값이 없는 함수는 반환형을 생략해도 상관없다.
    val result: Int = first + second
    print(result)
}

// - 간단하게 함수를 선언하는 방법
fun plusShort(first: Int, second: Int) = first + second

// - 가변 인자를 갖는 함수 선언하는 방법
//1개부터 n개의 인자값을 받는다.
fun plusMany(vararg numbers: Int){
    for(number in numbers) {
        println(number)
    }
}

fun main(args: Array<String>) {
    //함수를 호출하는 방법
    val result: Int = plus(5, 10) // 15가 된다.
    // 함수에 들어가는 수를 명시적으로 적어 놓을 수 있는 방법
    val result2 = plus(first = 20, second = 30)
    println(result)
    println(result2)

    //디폴트 값을 갖는 함수 호출하기
    println()
    val result4 = plusFive(10, 20)
    println (result4)
    val result5 = plusFive(10);
    // 미리 인자값을 써놓으면 숫자가 안 들어갈경우 그 수로 대체된다.
    println(result5)
    // 반환형에 Unit을 넣어주게되면 아무것도 return하지 않는다.
    println()
    printPlus(10, 20)

    println()
    val result6: Int = plusShort(50, 50)

    //인자값을 넣은 그대로, 즉 1~n개의 인수를전달 할 수 있다.
    println()
    plusMany(1,2,3)
}