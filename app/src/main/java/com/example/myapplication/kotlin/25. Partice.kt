package com.example.myapplication.kotlin

// 25. 인터페이스(2)
// - 인터페이스도 구현이 있는 함수를 만들수 있다.
// - 인터페이스에 구현이 있는 함수는 그 인터페이스를 구현 하는 클래스에서
//   그 함수를 구현할 필요가 없다.
// - 없으면 함수를 반드시 구현해야한다.

interface Person__{
    fun eat(){
        println("먹는다")
    }
    fun sleep(){
        println("잔다")
    }

    abstract fun study() // 반드시 구현해야 하는 함수로 바뀌어 버린다.
}

class Student__ : Person__{
    override fun study() {
        TODO("Not yet implemented")
    }

}

class Teacher : Person__{
    override fun eat() {

    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun study() {
        TODO("Not yet implemented")
    }

}