# Compaion Object


## Thiking๐คจ
---
์๋๋ก์ด๋ Room DB๋ฅผ ๊ณต๋ถํ๋๋์ค Companion Object๋ผ๋ ํค์๋๋ฅผ ๋ฐ๊ฒฌํ์ต๋๋ค. ์ฌ๊ธฐ์ ๊ถ๊ธ์ฆ์ด ์๊ฒผ์ต๋๋ค. ๊ณผ์ฐ Companion Object๊ฐ ๋ฌด์์ผ๊น์? ๋จ์ํ ์๋ฐ(JAVA)์ static ํค์๋๋ฅผ ๋์ฒดํ๊ธฐ์ํด ๋ง๋ค์ด์ง ํค์๋์ผ๊น์? ์ด ์ง๋ฌธ์ด ์ฐ๋ฆฌ๊ฐ ์ด๋ฒ์ ๋ฐฐ์ฐ๋๋ฐ์ ํฐ ๋์์ ์ค๊ฒ์๋๋ค.

## Let's Go!
์๋ฐ์ static ํค์๋๋ ํด๋์ค ๋ฉค๋ฒ(member)์์ ์ง์ ํ๊ธฐ ์ํด ์ฌ์ฉํฉ๋๋ค. 
**static์ด ๋ถ์ ๋ณ์์ ๋ฉ์๋๋ฅผ ๊ฐ๊ฐ ํด๋์ค ๋ณ์, ํด๋์ค ๋ฉ์๋**๋ผ ๋ถ๋ฆ๋๋ค. ๋ฐ๋ฉด,
**static์ด ๋ถ์ง ์์ ํด๋์ค ๋ด์ ๋ณ์์ ๋ฉ์๋๋ ๊ฐ๊ฐ ์ธ์คํด์ค ๋ณ์, ์ธ์คํด์ค ๋ฉ์๋**๋ผ ํฉ๋๋ค. static์ด ๋ถ์ ๋ฉค๋ฒ๋ ํด๋์ค๊ฐ ๋ฉ๋ชจ๋ฆฌ์ ์ ์ฌ๋  ๋ ์๋์ผ๋ก ํจ๊ป ์์ฑ๋๋ฏ๋ก ์ธ์คํด์ค ์์ฑ ์์ด๋ ํด๋์ค๋ช ๋ค์์ ์ (.)์ ์ฐ๋ฉด ๋ฐ๋ก ์ฐธ์กฐํ  ์ ์์ต๋๋ค.

```
public final class JAVAClass{
  static public final String TEST = "This is JAVA Test";  //ํด๋์ค ๋ณ์
  static public method(int i):int{     //ํด๋์ค ๋ฉ์๋
    return i + 10
  }
}
System.out.println(MyClass.TEST);    //test
System.out.println(MyClass.method(1));   //11
```

ํ์ง๋ง JAVA์ ์๋ static์ด ์ฝํ๋ฆฐ์๋ ์์ต๋๋ค. ๋์  Kotiln์ Companion Object๋ผ๋ ํค์๋์ ํจ๊ป ๋ธ๋ก({})์์ ๋ฉค๋ฒ๋ฅผ ๊ตฌ์ฑํฉ๋๋ค.

```

class KotilnClass{
    companion object{
        val TEST = "This is Kotiln Test"
        fun method(i:Int) = i + 10
    }
}
fun main(args: Array<String>){
    println(MyClass.TEST);    //test
    println(MyClass.method(1));   //11
}
```
์ด ์์ ์์๋ณด๋ฉด static๊ณผ ๋ค๋ฅผ ๋ฐ๊ฐ ์์ต๋๋ค. ํ์ง๋ง!! companion object์ static์ ์ฐจ์ด์ ์ ๋ถ๋ชํ ์๊ณ  static์ ํ๊ณ์ ๋ฐ๋ผ companion object๋ฅผ ์ฐ๋์ด์ ๋ฅผ ์ด์ ๋ถํฐ ์ ์ ์์๋ด์๋ค.

## Kotiln Class ํค์๋ ๊ธฐ์ด

์ฐ์  ์ฝํ๋ฆฐ์ class ์ Object๋ฅผ ์ดํดํด ๋ด์๋ค.

**class**

```
class WhatThisFood(private val name:String){
    fun FavoriteFood() = "๋ด๊ฐ ์ข์ํ๋ ์์์ ${name}์๋๋ค."
}
fun main(args: Array<String>){
    val food1 = WhatThisFood("๋ง๋ผํ")
    val food2 = WhatThisFood("๊น์น์ฐ๊ฒ")
    println(food1.WhatThisFood()) // ๋ด๊ฐ ์ข์ํ๋ ์์์ ๋ง๋ผํ์๋๋ค.
    println(food2.WhatThisFood()) // ๋ด๊ฐ ์ข์ํ๋ ์์์ ๊น์น์ฐ๊ฒ์๋๋ค.
}
```
์์ชฝ์ Kotiln Class๋ฅผ ์ ์ํ๋ ๋ฐฉ๋ฒ์๋๋ค. ์ด๊ฒฝ์ฐ ํด๋์ค WhatThisFoodf๋ฅผ ์ ์ํ๋ฉด์ val name:String๊ฐ์ ์์ฑ์์ ์ธ์๋ก ๋ฐ์ต๋๋ค. ์๋ฐ๋ฅผ ์ฃผ๋ก ์ฌ์ฉํ์จ๋๋ถ์ด๋ผ๋ฉด ์ดํด๊ฐ ์๋์ค์๋ ์์ต๋๋ค. ์ด์  ์ด ์์ ์์ ์๋ฐ์ฝ๋๋ก ๋ฐ๊พธ์ด ๋ณด๊ฒ ์ต๋๋ค.

```
class WhatThisFood{
    private val name:String
    constructor(name:String){
        this.name = name
    }
    fun FavoriteFood() = "๋ด๊ฐ ์ข์ํ๋ ์์์ ${name}์๋๋ค."
}

```
์์ฒ๋ผ ํด๋์ค ์์ฑ์๋ constructor ํค์๋๋ฅผ ์จ์ ์ ์ํฉ๋๋ค. ๊ทธ๋ฆฌ๊ณ  ์์ฑ์์์ ๋ฐ์์ธ์ name:String์ธ ๊ฐ์ ์์ฑ์ธ this:name์ ํตํด private val name:String์ ํ ๋นํ๊ณ ์์ต๋๋ค.

์ฌ๊ธฐ์์์ ๋ฌธ์ ์ ์ **์ค๋ณต๋๋ ๋ถ๋ถ์ด ๋๋ฌด ๋ง๋ค**๋๊ฒ์๋๋ค.
์ด๋ฌํ ๋ฌธ์ ์ ์ Kotiln์ Class๋ฅผ ์ ์ํ๋ฉด์ ์ธ์๊ฐ์ ๋ฐ์์ค๋๋ถ๋ถ์ผ๋ก ํด๊ฒฐํ๊ฒ์๋๋ค!

์ฆ, val m1 = WhatThisFood(โ์์โ) ๊ผด๋ก ํด๋์ค์์ ๊ฐ์ฒด๋ฅผ ์์ฑํฉ๋๋ค.
์ฝํ๋ฆฐ์์๋ new ํค์๋ ์์ด ํด๋์ค ๋ช ๋ค์ ๊ดํธ()๋ฅผ ๋ถ์ธ๋ค๋ ์ !! (๋ง์น ํจ์ํธ์ถ๐)

**Object**

์ฝํ๋ฆฐ์๋ ์๋ฐ์๋ ์๋ "ํน๋ณํ" ์ฑ๊ธํด(Singletion : ์ธ์๊ฐ ํ๋๋ง ์๋ ํด๋์ค)๊ฐ ์์ต๋๋ค. ๋ค์๊ณผ๊ฐ์ด class ๋์  object๋ผ๋ ํค์๋๋ฅผ ์ฌ์ฉํฉ๋๋ค. ํ๋ฒ๋ง ๊ฐ์ฒด๊ฐ ์์ฑ๋๊ฒ ํ๋ฏ๋ก ๋ฉ๋ชจ๋ฆฌ ๋ญ๋น๋ฅผ ๋ฐฉ์งํ  ์ ์๊ณ , ์ ์ญ๋ณ์์ด๋ฏ๋ก ๊ณต์ ๋ ์ฉ์ดํฉ๋๋ค.

```
object MySingleton{
    val prop = "๋๋ MySingleton์ ์์ฑ์ด๋ค."
    fun method() = "๋๋ MySingleton์ ๋ฉ์๋๋ค."
}
fun main(args: Array<String>){
    println(MySingleton.prop);    //๋๋ MySingleton์ ์์ฑ์ด๋ค.
    println(MySingleton.method());   //๋๋ MySingleton์ ๋ฉ์๋๋ค.
}
```
์ฑ๊ธํค์ด๊ธฐ ๋๋ฌธ์ ์์คํ ์ ์ฒด์์ ์ธ ๊ธฐ๋ฅ(๋ฉ์๋๋ก ์ ์)์ ์ํํ๋ ๋ฐ๋ ํฐ ๋์์ด ๋  ์ ์์ง๋ง, ์ ์ญ ์ํ๋ฅผ ์ ์งํ๋ ๋ฐ ์ฐ๋ฉด ์ค๋ ๋ ๊ฒฝํฉ ๋ฑ์ผ๋ก ์ํํ  ์ ์์ผ๋ ์ฃผ์ํด์ ์ฌ์ฉํด์ผ ํฉ๋๋ค.

์ด์  ์ฐ๋ฆฌ๋ class ์ object์ ๋ํด ๊ฐ๊ฒฐํ ๋ฐฐ์๋ณด์์ต๋๋ค. ์ด์ ๋ถํฐ๋ ์ด ์ง์๋ค์ ๊ฐ์ง๊ณ  companion object๋ฅผ ๋ค๋ค๋ด์๋ค!

## Companion object๋ static์ด ์๋๋ค!

์ฌ์ค Companiond Object๋ static๊ณผ ๋์ผํ๊ฒ์ด ์๋๋ฉฐ, ๋์ผํ๊ฒ ๋ณด์ด๋๊ฒ ๋ฟ์๋๋ค.
์ด๊ฒ ๋ฌด์จ๋ง์ผ๊น์? ๋ฐ์ ์์ ๋ฅผ ์ดํด๋ด์๋ค.

```
class MyClass2{
    companion object{
        val prop = "๋๋ Companion object์ ์์ฑ์ด๋ค."
        fun method() = "๋๋ Companion object์ ๋ฉ์๋๋ค."
    }
}
fun main(args: Array<String>) {
    //์ฌ์ค์ MyClass2.๋งด๋ฒ๋ MyClass2.Companion.๋งด๋ฒ์ ์ถ์ฝํํ์ด๋ค.
    println(MyClass2.Companion.prop)
    //println(MyClass2.prop)์ ๊ฐ๋ค.
    
    println(MyClass2.Companion.method())
}
```

MyClass2 ํด๋์ค์ companion object๋ฅผ ๋ง๋ค์ด 2๊ฐ์ ๋ฉค๋ฒ๋ฅผ ์ ์ํ์ต๋๋ค. ์ด๋ฅผ ์ฌ์ฉํ๋ main() ํจ์๋ฅผ ๋ณด๋ฉด ์ด ๋ฉค๋ฒ์ ์ ๊ทผํ๊ธฐ ์ํด ํด๋์ค๋ช.Companionํํ๋ก ์ด ๊ฒ์ ํ์ธํ  ์ ์์ต๋๋ค. 

์ฆ, companion object{}๋
**MyClass2ํด๋์ค๊ฐ ๋ฉ๋ชจ๋ฆฌ์ ์ ์ฌ๋๋ฉด์ ํจ๊ป ์์ฑ๋๋ ๋๋ฐ(companion)๋๋ ๊ฐ์ฒด**์๋๋ค. ์ฌ๊ธฐ์ ์ฐ๋ฆฌ๋ ๋ณ์๋ฅผ ์ฌ์ฉํ๊ธฐ์ํด ๊ฐ์ด ์ฌ์ฉ๋จ์ ์ ์ถํด ๋ณผ ์์์ต๋๋ค.

๋ฐ๋ผ์ ์ฐ๋ฆฌ๊ฐ ์ ์ ์๋์ฌ์ค์ ์์ MyClass2.prop ๋ MyClass2.Companio.prop์ ์ถ์ฝํ์ด๋ผ๋๊ฒ์ ์ ์ ์์ต๋๋ค. ์ฐ๋ฆฌ๊ฐ ์ง๊ธ๊น์ง ์๊ฐํ ์๊ฐ์ ์ธ์ด์ ์ผ๋ก ์ง์ํ๋ ์ถ์ฝ ํํ ๋๋ฌธ์ companion object๊ฐ static์ผ๋ก ์ฐฉ๊ฐ์ด ๋๋ ๊ฒ๋๋ฌธ์ด๋ผ๋๊ฒ์ ์ ์ ์์ต๋๋ค.

## Companion object๋ ๊ฐ์ฒด์๋๋ค.


```
class MyClass2{
    companion object{
        val prop = "๋๋ Companion object์ ์์ฑ์ด๋ค."
        fun method() = "๋๋ Companion object์ ๋ฉ์๋๋ค."
    }
}
fun main(args: Array<String>) {
    println(MyClass2.Companion.prop)
    println(MyClass2.Companion.method())
    //์ด๋ ๊ฒ ๋ณ์์ ํ ๋นํ๋ ๊ฒ์ ์๋ฐ์ ํด๋์ค์์ static ํค์๋๋ก ์ ์๋ ๋ฉค๋ฒ๋ก๋ ๋ถ๊ฐ๋ฅํ ๋ฐฉ๋ฒ์๋๋ค.
    val comp1 = MyClass2.Companion  //--(1)
    println(comp1.prop)
    println(comp1.method())
    val comp2 = MyClass2  //--(2)
    println(comp2.prop)
    println(comp2.method())
}
```
์์ ๊ฐ์ ์ฝ๋์์ ์ฐ๋ฆฌ๋ Companion Object๊ฐ ๊ฐ์ฒด์์ ์ ์ ์์ต๋๋ค
(1)๋ฒ ์ฃผ์๊ณผ ๊ฐ์ด companion Object๋ฅผ ๋ณ์์ ํ ๋นํ๋๊ฒ์ ๋ณผ ์์๊ณ ,
(2)๋ฒ ์ฃผ์๊ณผ ๊ฐ์ด .Companion์ ๋นผ๊ณ  ํด๋์ค์์ ๋ค์ด๊ฐ์๋ companion Object ๋ฅผ ๋ณ์์ ํ ๋น์ ํ  ์์๋๊ฒ๋ ๋ณผ ์ ์์ต๋๋ค.

์ฆ, static ๊ณผ๋ ๋ค๋ฅด๊ฒ companion object๋ ๋๋ฆฝ๋ ๊ฐ์ฒด์์ ์ ์์์ต๋๋ค.

## Companion object์ ์ด๋ฆ์ ์ง์ ์ ์์ต๋๋ค.

companion object์ ๊ธฐ๋ณธ ์ด๋ฆ์ Companion์ด์ง๋ง ์ด๋ฆ์ ๋ณ๊ฒฝ ํ  ์๋ ์์ต๋๋ค.
```
class MyClass3{
    companion object MyCompanion{  // -- (1)
        val prop = "๋๋ Companion object์ ์์ฑ์ด๋ค."
        fun method() = "๋๋ Companion object์ ๋ฉ์๋๋ค."
    }
}
fun main(args: Array<String>) {
    println(MyClass3.MyCompanion.prop) // -- (2)
    println(MyClass3.MyCompanion.method())
    val comp1 = MyClass3.MyCompanion // -- (3)
    println(comp1.prop)
    println(comp1.method())
    val comp2 = MyClass3 // -- (4)
    println(comp2.prop)
    println(comp2.method())
    val comp3 = MyClass3.Companion // -- (5) ์ด๋ฆ์ด ๋ฐ๋์์ผ๋ฏ๋ก ์๋ฌ๋ฐ์!!!
    println(comp3.prop)
    println(comp3.method())
}
```

์์ ๊ทธ๋ฆผ์ ๋ณด๋ฉด ์ฃผ์(1)๋ฒ์์ companion object์ ์ด๋ฆ์ ์ฃผ์, ์ฃผ์(2),(3)๋ฒ์ด ๋ณ๊ฒฝ๋ ์ด๋ฆ๊ทธ๋๋ก ์ฌ์ฉ ํ  ์์์์ ์ ์ ์์ต๋๋ค.
๊ทธ๋ฌ๋ ์ฌ์ ํ ์ฃผ์(4)๋ฒ์ฒ๋ผ Companionํค์๋๋ฅผ ์๋ต ํ  ์๋์์ต๋๋ค.

## ํด๋์ค๋ด Companion object๋ ๋ฑ ํ๋๋ง ์ธ ์ ์์ต๋๋ค.

ํด๋์ค๋ด์์ Companion Object๋ ๋ฑ ํ๋๋ง ์ธ ์์์ต๋๋ค. ์ง๊ธ๊น์ง ๊ณต๋ถํ๊ฒ์ ์๊ฐํด ๋ณด์์๋ ๋น์ฐํ ๊ฒฐ๊ณผ์ผ์ง๋ ๋ชจ๋ฆ๋๋ค. ์๋ํ๋ฉด ์ฝํ๋ฆฐ์ ํด๋์ค๋ช๋ง์ผ๋ก๋ ์ฐธ์กฐ๊ฐ ๊ฐ๋ฅํ๋ฏ๋ก ํ ํด๋์ค์์ ๋๊ฐ์ Companion Object๊ฐ ๋ค์ด๊ฐ์์ผ๋ฉด ๋ฌด์์ ๊ฐ์ ธ์์ผํ ์ง ๊ฒฐ์ ์ ๋ชปํ๊ธฐ ๋๋ฌธ์๋๋ค.

```
class MyClass5{
    companion object{
        val prop1 = "๋๋ Companion object์ ์์ฑ์ด๋ค."
        fun method1() = "๋๋ Companion object์ ๋ฉ์๋๋ค."
    }
    companion object{ // -- ์๋ฌ๋ฐ์!! Only one companion object is allowed per class
        val prop2 = "๋๋ Companion object์ ์์ฑ์ด๋ค."
        fun method2() = "๋๋ Companion object์ ๋ฉ์๋๋ค."
    }
}
```
์์ฒ๋ผ ๋ง๋ค๋ฉด Only one companion object is allowed per class ์๋ฌ๊ฐ ๋ฐ์ํฉ๋๋ค.
๊ทธ๋ ๋ค๊ณ  ๋ฐ์ ์ฝ๋์ฒ๋ผ Companion object์ ์ด๋ฆ์ ์๋ก ๋ค๋ฅธ์ด๋ฆ์ผ๋ก ํ ๋นํด์ฃผ์ด๋ ์ค๋ฅ๊ฐ ๋ฐ์ํฉ๋๋ค.
```
class MyClass5{
    companion object MyCompanion1{
        val prop1 = "๋๋ Companion object์ ์์ฑ์ด๋ค."
        fun method1() = "๋๋ Companion object์ ๋ฉ์๋๋ค."
    }
    companion object MyCompanion2{ // --  ์๋ฌ๋ฐ์!! Only one companion object is allowed per class
        val prop2 = "๋๋ Companion object์ ์์ฑ์ด๋ค."
        fun method2() = "๋๋ Companion object์ ๋ฉ์๋๋ค."
    }
}
```

## ์์ ๊ด๊ณ์์ Companion object ๋ฉค๋ฒ๋ ๊ฐ์ ์ด๋ฆ์ผ ๊ฒฝ์ฐ ๊ฐ๋ ค์ง๋๋ค(์๋์, shadowing).

๋ถ๋ชจ ํด๋์ค๋ฅผ ์์ํ ์์ ํด๋์ค์ ๋ชจ๋ companion object๋ฅผ ๋ง๋ค๊ณ  ๊ฐ์ ์ด๋ฆ์ ๋ฉค๋ฒ๋ฅผ ์ ์ํ๋ค๊ณ  ๊ฐ์ ํฉ๋๋ค. ์ด๋, ์์ ํด๋์ค์์ ์ด ๋ฉค๋ฒ๋ฅผ ์ฐธ์กฐํ๋ฉด ๋ถ๋ชจ์ ๋ฉค๋ฒ๋ ๊ฐ๋ ค์ง๊ณ  ์์ ์์ ์ ๋ฉค๋ฒ๋ง ์ฐธ์กฐํ  ์ ์์ต๋๋ค. ์ดํดํ๊ธฐ ์ฝ๋๋ก ์ฝ๋๋ก ๋ณด๊ฒ ์ต๋๋ค.
```
open class Parent{
    companion object{
        val parentProp = "๋๋ ๋ถ๋ชจ๊ฐ"
    }
    fun method0() = parentProp
}
class Child:Parent(){
    companion object{
        val childProp = "๋๋ ์์๊ฐ"
    }
    fun method1() = childProp
    fun method2() = parentProp
}
fun main(args: Array<String>) {
    val child = Child()
    println(child.method0()) //๋๋ ๋ถ๋ชจ๊ฐ
    println(child.method1()) //๋๋ ์์๊ฐ
    println(child.method2()) //๋๋ ๋ถ๋ชจ๊ฐ
}
```
์ ์ฝ๋์ฒ๋ผ ๋ถ๋ชจ/์์์ companion object์ ๋ฉค๋ฒ๊ฐ ๋ค๋ฅธ ์ด๋ฆ์ด๋ผ๋ฉด ์์์ด ๋ถ๋ชจ์ companion object ๋ฉค๋ฒ๋ฅผ ์ง์  ์ฐธ์กฐํ  ์ ์์ต๋๋ค. ํ์ง๋ง ๊ฐ์ ์ด๋ฆ์ด๋ฉด ์ด๋ป๊ฒ ๋ ๊น์? ๋ค์ ์ฝ๋๋ฅผ ๋ด์๋ค.

```
open class Parent{
    companion object{
        val prop = "๋๋ ๋ถ๋ชจ"
    }
    fun method0() = prop //Companion.prop๊ณผ ๋์ผ
}
class Child:Parent(){
    companion object{
        val prop = "๋๋ ์์"
    }
    fun method1() = prop //Companion.prop ๊ณผ ๋์ผ
}
fun main(args: Array<String>) {
    println(Parent().method0()) //๋๋ ๋ถ๋ชจ
    println(Child().method0()) //๋๋ ๋ถ๋ชจ
    println(Child().method1()) //๋๋ ์์
    println(Parent.prop) //๋๋ ๋ถ๋ชจ
    println(Child.prop) //๋๋ ์์
    println(Parent.Companion.prop) //๋๋ ๋ถ๋ชจ
    println(Child.Companion.prop) //๋๋ ์์
}
```
์์์  companion object๊ฐ ๊ฐ์ ์ด๋ฆ์ ์ฌ์ฉํ์๋์ ๊ฒฝ์ฐ๋ฅผ ๋ณด์ฌ์ค๋๋ค.
๊ฐ์์ด๋ฆ์ ์ฌ์ฉํ์์๊ฒฝ์ฐ ์์ํด๋์ค์ companion object ์์ฑ์ธ prop์ด ๋ถ๋ชจ์์ ์ ์ ๋์ด ์์ง๋ง ๊ฐ๋ ค์ ธ์ ๋ฌด์๋๋ ๊ฒ์ ๋ณผ ์ ์์ต๋๋ค.

์ฆ, method0() ๋ฉ์๋๋ Parentํด๋์ค ๊ฒ์ด๊ธฐ๋๋ฌธ์ ๊ทธ๋์ ๋ถ๋ชจ์ companion object์ prop๊ฐ์ธ โ๋๋ ๋ถ๋ชจโ๊ฐ ์ถ๋ ฅ๋ฉ๋๋ค.

์ฌ๊ธฐ์ ์ฝ๋๋ฅผ ์ด์ง ๋ฐ๊พธ์ด๋ณด๊ฒ ์ต๋๋ค. ์์ํด๋์ค์ companion object์ ์ด๋ฆ์ ๋ถ์ฌํฉ๋๋ค.
```
open class Parent{
    companion object{
        val prop = "๋๋ ๋ถ๋ชจ"
    }
    fun method0() = prop
}
class Child:Parent(){
    companion object ChildCompanion{ // -- (1) ChildCompanion๋ก ์ด๋ฆ์ ๋ถ์ฌํ์ด์.
        val prop = "๋๋ ์์"
    }
    fun method1() = prop
    fun method2() = ChildCompanion.prop
    fun method3() = Companion.prop
}
fun main(args: Array<String>) {
    val child = Child()
    println(child.method0()) //๋๋ ๋ถ๋ชจ
    println(child.method1()) //๋๋ ์์
    println(child.method2()) //๋๋ ์์
    println(child.method3()) // -- (2)
}
```

์ ์ฝ๋์์ ์ฃผ์ (1)์ ์์ ํด๋์ค์ companion object์ ChildCompanion๋ก ์ด๋ฆ์ ๋ถ์ฌํ์ต๋๋ค. ๊ทธ๋ฆฌ๊ณ  ์์ ํด๋์ค์ 3๊ฐ์ ๋ฉ์๋๋ฅผ ์ ์ํ์ต๋๋ค. 

child.method0()์ **๋ถ๋ชจ์ method**์ด๋ฏ๋ก ์ด๋ ต์ง ์๊ฒ โ๋๋ ๋ถ๋ชจโ๊ฐ ์ถ๋ ฅ๋ ๊ฒ์ ์์ํ  ์ ์์ต๋๋ค. ๊ทธ๋ฆฌ๊ณ  child.method1()๊ณผ child.method2()๋ ์ญ์ ์์์ companion object์ ์์ฑ์ ๊ฐ๋ฆฌํจ๋ค๋ ๊ฒ์ ์ ์ ์์ต๋๋ค.

์ฃผ์(2)๋ ์ด๋ค ๊ฒฐ๊ณผ๊ฐ ๋์ฌ๊น์? ๋ต๋ถํฐ ๋ง์๋๋ฆฌ๋ฉด โ๋๋ ๋ถ๋ชจโ์๋๋ค. ์์์ companion object๋ฅผ ๋ฐ์ด๋์ด์ ๋ถ๋ชจ์ companion object์ ์ง์  ์ ๊ทผ์ด ๊ฐ๋ฅํ๊ฒ ๋์์ต๋๋ค.

์๋ํ๋ฉด ์์์ ChildCompanion๋ก ์ด๋ฆ์ ๋ฐ๊ฟจ์ผ๋ ๋ถ๋ชจ์ Comaniond์๊ฐ์ ธ์ ์ฌ๊ธฐ์ Companion์ ๋ถ๋ชจ๊ฐ ๋ฉ๋๋ค.

์ฐ๋ฆฌ๊ฐ ์ฌ๊ธฐ์ ์ ์ ์๋์ ์  ๋ถ๋ชจ/์์์ companion object์ ์ ์๋ ๋ฉค๋ฒ๋ ์์ ์์ฅ์์ ์ ๊ทผํ  ์ ์์ง๋ง, ์ด๋ฆ์ด ๊ฒน์น๋ค๋ฉด **์๋์(shadowing)** ์ด ๋์ด ๊ฐ์ถฐ์ง๋ค๋ ์ ์ ์ ์ ์์์ต๋๋ค.


---
์ถ์ฒ :https://www.bsidesoft.com/8187
