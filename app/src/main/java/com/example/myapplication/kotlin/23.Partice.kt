package com.example.myapplication.kotlin

fun main(args: Array<String>){
    var monster : SuperMonster = SuperMonster(12,5)
    var night : SuperNight = SuperNight(100,3)
    println(monster.attack(night,3))
    println(night.hpUp(night))
}

open class basic(var hp : Int, var damage: Int){
    fun attack(basic: basic, damage: Int){
        basic.defance(damage)
    }
    fun defance(damage: Int){
        hp -= damage
        if (hp >0){
            // 클래스의 이름을 가져온다.
            println("${javaClass.simpleName} : 남은 체력 $hp")
        }
        else
            println("${javaClass.simpleName} : 사망했습니다.")
    }
}

//자식 클래스가 인스턴스화 되기 위해서 부모 클래스가 선행 되어서 인스턴스화 되어야 한다.
class SuperMonster(hp : Int, damage: Int) : basic(hp,damage){
    fun BestOfKiller(basic: basic){
        basic.attack(basic,damage+100)
    }
}

class  SuperNight(hp : Int, damage: Int) : basic(hp,damage){
    fun hpUp(basic : basic){
        basic.hp+=3
        println("${javaClass.simpleName}의 현재 채력은 $basic.$hp")
        println("SuperNight가 3만큼 치유 되었습니다.")
    }
}

