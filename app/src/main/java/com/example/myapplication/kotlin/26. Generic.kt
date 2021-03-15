package com.example.myapplication.kotlin

// 29. Generic(제너릭)
// 목적 : 다양한 타입의 객체들을 다루는 메서드나 컬렉션
//        타입을 체크하는 기능
// - 제너릭은 만들기 어렵고 실제로 만들일이 거의 없기 때문에 사용 하는
//   방법만 숙지하도록 한다.

fun main(args : Array<String>){

    // 제너릭을 사용하지 않을경우
        val list1 = listOf(1,2,3,"가")
        val b : String = list1[2].toString() // 형변환(타입 변환)

    // 제너릭을 사용하는 경우 -> 타입이 안전하다..?
        val list2 = listOf<String>("a","b","c")
        val c : String = list2[2] // String이라는것을 보장받기때문에 오류 X

    // 강한 타입을 체크 할 수 있다.
        val list3 = listOf(1,2,3,4,"가","나",3.0)
        val list4 = listOf<Int>(1,2,3,4,5) // 강한타입 체크

    // 제너릭을 사용하지 않은경우
         val list5 = listOf(1,2,3,4,"가","나",3.0) // -> Any형 즉, C#의 Object형
}
