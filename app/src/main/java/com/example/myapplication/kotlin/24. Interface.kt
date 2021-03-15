package com.example.myapplication.kotlin

// 24. Interface
// - 인터페이스는 약속 -> 당신이 이것을 구현하면 당신도 이 타입이다!
// - 인터페이스를 구현하는 클래스는 기능을 반드시 구현해주어야 함

// 상속이 만들어낸 특징
// - 생성자가 없다 -> 인스턴스화 시킬 수 없다 -> 설명서가 없다!
// - 지침서 -> 당신이 만약 이것을 구현하고 싶다면 반드시 아래 기능을 구현해라!

// 상속과 인터페이스의 차이점
// - 상속 : 안에있는 구현 내용이 비슷할때
// - 인터페이스 : 안에있는 구현 내용이 큰틀은 비슷하지만 내용은 크게 다를때
interface Person_{
    fun eat()
    fun sleep()
}

class Student_ : Person_{
    override fun eat() {

    }

    override fun sleep() {

    }
}

class SoccerPlay : Person_{
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

}


// 기존의 상속

open class Person(){
    open fun eat(){

    }
    fun sleep(){

    }
}

class Student() : Person(){
    override fun eat(){
        super.eat()
    }
}