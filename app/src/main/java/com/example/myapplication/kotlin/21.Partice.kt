package com.example.myapplication.kotlin

//몬스터의 현재 채력과 공격력등, 임의적으로 수정하면
// 안되는수치가 있기 때문에 private로 제한을 걸어준다.

fun main(array: Array<String>){
    val night : Night = Night(20 ,4)
    val monster : Monster = Monster(15,3)

    night.attack(monster)
    monster.attack(night)
}

class Night(private var hp : Int, private var power : Int){

    fun attack(monster: Monster){
        monster.defanse(power)
    }
    fun defanse(damage: Int){
        hp -= damage
        if (hp > 0){
            println("기사의 현재 체력은 $hp 입니다.")
        }
        else
        {
            println("기사가 죽었습니다.")
        }

    }
    fun heal(){
        hp += 3
    }
}

class Monster(private var hp :Int,private var power: Int){

    fun attack(night: Night){
        night.defanse(power)
    }
    fun defanse(damage : Int){

        hp -= damage
        if (hp > 0){
            println("몬스터의 현재 체력은 $hp 입니다.")
        }
        else
        {
            println("몬스터가 죽었습니다.")
        }
    }
}