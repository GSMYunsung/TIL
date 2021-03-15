package com.example.myapplication.kotlin

import android.speech.tts.TextToSpeech

// 25.상속
// 부모로부터 설명서를 물려받는다!
// 접근제한자의 기본값이 private 즉, 외부에서 사용 불가능
// 그래서 상속을 받을 때는 open이란 키워드를 앞에 설정해줘야함


fun main(args : Array<String>){
    val car : Supercar = Supercar()
}

// 부모 : Car3
// 자식 : Super

open class Car3(){
    open fun drive() : String{
        return "달린다"
        //println("달린다")
    }
    fun stop(){

    }
}

// 부모의 함수를 가져오면 아래 형식으로 써줘야 한다.
class Supercar() : Car3() {
    override fun drive(): String {
        //println("빨리 달린다")
        val run = super.drive()
        return "빨리 $run"
    }

}