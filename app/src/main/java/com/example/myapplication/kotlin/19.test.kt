package com.example.myapplication.kotlin

fun main(array: Array<String>){
    val num : Calculate = Calculate()
    num.calcu(8,"*",2)
    val account : Bank =  Bank("최윤성", "04/06/23",1000)
    account.checkMoney()
    account.withdraw(1000)
    account.save(2000)
}

class Calculate(){

    fun calcu(num: Int, calculate : String, num2 : Int){

        when(calculate){
            "+" -> println(num+num2)
            "-" -> println(num-num2)
            "*" -> println(num*num2)
            "/" -> println(num/num2)
            "%" -> println(num%num2)
        }
    }
}

class Bank(val name : String, val birthday : String, val money : Int){
    fun checkMoney() : Int {
        return money
    }
    fun withdraw(output : Int) : Boolean{
        if(output< money){
            return true
        }
        else
            return false
    }
    fun save(Addmoney : Int) : Int{
        return Addmoney+money
    }
}