# Compaion Object


## Thiking🤨
---
안드로이드 Room DB를 공부하던도중 Companion Object라는 키워드를 발견했습니다. 여기서 궁금증이 생겼습니다. 과연 Companion Object가 무엇일까요? 단순히 자바(JAVA)의 static 키워드를 대체하기위해 만들어진 키워드일까요? 이 질문이 우리가 이번에 배우는데에 큰 도움을 줄것입니다.

## Let's Go!
자바의 static 키워드는 클래스 멤버(member)임을 지정하기 위해 사용합니다. 
**static이 붙은 변수와 메소드를 각각 클래스 변수, 클래스 메소드**라 부릅니다. 반면,
**static이 붙지 않은 클래스 내의 변수와 메소드는 각각 인스턴스 변수, 인스턴스 메소드**라 합니다. static이 붙은 멤버는 클래스가 메모리에 적재될 때 자동으로 함께 생성되므로 인스턴스 생성 없이도 클래스명 다음에 점(.)을 쓰면 바로 참조할 수 있습니다.

```
public final class JAVAClass{
  static public final String TEST = "This is JAVA Test";  //클래스 변수
  static public method(int i):int{     //클래스 메소드
    return i + 10
  }
}
System.out.println(MyClass.TEST);    //test
System.out.println(MyClass.method(1));   //11
```

하지만 JAVA에 있는 static이 코틀린에는 없습니다. 대신 Kotiln은 Companion Object라는 키워드와 함께 블록({})안에 멤버를 구성합니다.

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
이 시점에서보면 static과 다를 바가 없습니다. 하지만!! companion object와 static의 차이점은 분명히 있고 static의 한계에 따라 companion object를 쓰는이유를 이제부터 저와 알아봅시다.

## Kotiln Class 키워드 기초

우선 코틀린의 class 와 Object를 이해해 봅시다.

**class**

```
class WhatThisFood(private val name:String){
    fun FavoriteFood() = "내가 좋아하는 음식은 ${name}입니다."
}
fun main(args: Array<String>){
    val food1 = WhatThisFood("마라탕")
    val food2 = WhatThisFood("김치찌게")
    println(food1.WhatThisFood()) // 내가 좋아하는 음식은 마라탕입니다.
    println(food2.WhatThisFood()) // 내가 좋아하는 음식은 김치찌게입니다.
}
```
위쪽은 Kotiln Class를 정의하는 방법입니다. 이경우 클래스 WhatThisFoodf를 정의하면서 val name:String값을 생성자의 인자로 받습니다. 자바를 주로 사용하셨던분이라면 이해가 안되실수도 있습니다. 이제 이 시점에서 자바코드로 바꾸어 보겠습니다.

```
class WhatThisFood{
    private val name:String
    constructor(name:String){
        this.name = name
    }
    fun FavoriteFood() = "내가 좋아하는 음식은 ${name}입니다."
}

```
위처럼 클래스 생성자는 constructor 키워드를 써서 정의합니다. 그리고 생성자에서 받은인자 name:String인 값을 속성인 this:name을 통해 private val name:String에 할당하고있습니다.

여기에서의 문제점은 **중복되는 부분이 너무 많다**는것입니다.
이러한 문제점을 Kotiln의 Class를 정의하면서 인자값을 받아오는부분으로 해결한것입니다!

즉, val m1 = WhatThisFood(“영수”) 꼴로 클래스에서 객체를 생성합니다.
코틀린에서는 new 키워드 없이 클래스 명 뒤에 괄호()를 붙인다는 점!! (마치 함수호출😁)

**Object**

코틀린에는 자바에는 없는 "특별한" 싱글턴(Singletion : 인수가 하나만 있는 클래스)가 있습니다. 다음과같이 class 대신 object라는 키워드를 사용합니다. 한번만 객체가 생성되게 하므로 메모리 낭비를 방지할 수 있고, 전역변수이므로 공유도 용이합니다.

```
object MySingleton{
    val prop = "나는 MySingleton의 속성이다."
    fun method() = "나는 MySingleton의 메소드다."
}
fun main(args: Array<String>){
    println(MySingleton.prop);    //나는 MySingleton의 속성이다.
    println(MySingleton.method());   //나는 MySingleton의 메소드다.
}
```
싱글톤이기 때문에 시스템 전체에서 쓸 기능(메소드로 정의)을 수행하는 데는 큰 도움이 될 수 있지만, 전역 상태를 유지하는 데 쓰면 스레드 경합 등으로 위험할 수 있으니 주의해서 사용해야 합니다.

이제 우리는 class 와 object에 대해 간결히 배워보았습니다. 이제부터는 이 지식들을 가지고 companion object를 다뤄봅시다!

## Companion object는 static이 아니다!

사실 Companiond Object는 static과 동일한것이 아니며, 동일하게 보이는것 뿐입니다.
이게 무슨말일까요? 밑의 예제를 살펴봅시다.

```
class MyClass2{
    companion object{
        val prop = "나는 Companion object의 속성이다."
        fun method() = "나는 Companion object의 메소드다."
    }
}
fun main(args: Array<String>) {
    //사실은 MyClass2.맴버는 MyClass2.Companion.맴버의 축약표현이다.
    println(MyClass2.Companion.prop)
    //println(MyClass2.prop)와 같다.
    
    println(MyClass2.Companion.method())
}
```

MyClass2 클래스에 companion object를 만들어 2개의 멤버를 정의했습니다. 이를 사용하는 main() 함수를 보면 이 멤버에 접근하기 위해 클래스명.Companion형태로 쓴 것을 확인할 수 있습니다. 

즉, companion object{}는
**MyClass2클래스가 메모리에 적재되면서 함께 생성되는 동반(companion)되는 객체**입니다. 여기서 우리는 변수를 사용하기위해 같이 사용됨을 유추해 볼 수있습니다.

따라서 우리가 알 수 있는사실은 위의 MyClass2.prop 는 MyClass2.Companio.prop의 축약형이라는것을 알 수 있습니다. 우리가 지금까지 생각한 생각은 언어적으로 지원하는 축약 표현 때문에 companion object가 static으로 착각이 드는 것때문이라는것을 알 수 있습니다.

## Companion object는 객체입니다.


```
class MyClass2{
    companion object{
        val prop = "나는 Companion object의 속성이다."
        fun method() = "나는 Companion object의 메소드다."
    }
}
fun main(args: Array<String>) {
    println(MyClass2.Companion.prop)
    println(MyClass2.Companion.method())
    //이렇게 변수에 할당하는 것은 자바의 클래스에서 static 키워드로 정의된 멤버로는 불가능한 방법입니다.
    val comp1 = MyClass2.Companion  //--(1)
    println(comp1.prop)
    println(comp1.method())
    val comp2 = MyClass2  //--(2)
    println(comp2.prop)
    println(comp2.method())
}
```
위와 같은 코드에서 우리는 Companion Object가 객체임을 알 수 있습니다
(1)번 주석과 같이 companion Object를 변수에 할당하는것을 볼 수있고,
(2)번 주석과 같이 .Companion을 빼고 클래스안에 들어가있는 companion Object 를 변수에 할당을 할 수있는것도 볼 수 있습니다.

즉, static 과는 다르게 companion object는 독립된 객체임을 알 수있습니다.

## Companion object에 이름을 지을 수 있습니다.

companion object의 기본 이름은 Companion이지만 이름을 변경 할 수도 있습니다.
```
class MyClass3{
    companion object MyCompanion{  // -- (1)
        val prop = "나는 Companion object의 속성이다."
        fun method() = "나는 Companion object의 메소드다."
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
    val comp3 = MyClass3.Companion // -- (5) 이름이 바뀌었으므로 에러발생!!!
    println(comp3.prop)
    println(comp3.method())
}
```

위의 그림을 보면 주석(1)번에서 companion object에 이름을 주자, 주석(2),(3)번이 변경된 이름그대로 사용 할 수있음을 알 수 있습니다.
그러나 여전히 주석(4)번처럼 Companion키워드를 생략 할 수도있습니다.

## 클래스내 Companion object는 딱 하나만 쓸 수 있습니다.

클래스내에서 Companion Object는 딱 하나만 쓸 수있습니다. 지금까지 공부한것을 생각해 보았을때 당연한 결과일지도 모릅니다. 왜냐하면 코틀린은 클래스명만으로도 참조가 가능하므로 한 클래스안에 두개의 Companion Object가 들어가있으면 무엇을 가져와야할지 결정을 못하기 때문입니다.

```
class MyClass5{
    companion object{
        val prop1 = "나는 Companion object의 속성이다."
        fun method1() = "나는 Companion object의 메소드다."
    }
    companion object{ // -- 에러발생!! Only one companion object is allowed per class
        val prop2 = "나는 Companion object의 속성이다."
        fun method2() = "나는 Companion object의 메소드다."
    }
}
```
위처럼 만들면 Only one companion object is allowed per class 에러가 발생합니다.
그렇다고 밑의 코드처럼 Companion object에 이름을 서로 다른이름으로 할당해주어도 오류가 발생합니다.
```
class MyClass5{
    companion object MyCompanion1{
        val prop1 = "나는 Companion object의 속성이다."
        fun method1() = "나는 Companion object의 메소드다."
    }
    companion object MyCompanion2{ // --  에러발생!! Only one companion object is allowed per class
        val prop2 = "나는 Companion object의 속성이다."
        fun method2() = "나는 Companion object의 메소드다."
    }
}
```

## 상속 관계에서 Companion object 멤버는 같은 이름일 경우 가려집니다(섀도잉, shadowing).

부모 클래스를 상속한 자식 클래스에 모두 companion object를 만들고 같은 이름의 멤버를 정의했다고 가정합니다. 이때, 자식 클래스에서 이 멤버를 참조하면 부모의 멤버는 가려지고 자식 자신의 멤버만 참조할 수 있습니다. 이해하기 쉽도록 코드로 보겠습니다.
```
open class Parent{
    companion object{
        val parentProp = "나는 부모값"
    }
    fun method0() = parentProp
}
class Child:Parent(){
    companion object{
        val childProp = "나는 자식값"
    }
    fun method1() = childProp
    fun method2() = parentProp
}
fun main(args: Array<String>) {
    val child = Child()
    println(child.method0()) //나는 부모값
    println(child.method1()) //나는 자식값
    println(child.method2()) //나는 부모값
}
```
위 코드처럼 부모/자식의 companion object의 멤버가 다른 이름이라면 자식이 부모의 companion object 멤버를 직접 참조할 수 있습니다. 하지만 같은 이름이면 어떻게 될까요? 다음 코드를 봅시다.

```
open class Parent{
    companion object{
        val prop = "나는 부모"
    }
    fun method0() = prop //Companion.prop과 동일
}
class Child:Parent(){
    companion object{
        val prop = "나는 자식"
    }
    fun method1() = prop //Companion.prop 과 동일
}
fun main(args: Array<String>) {
    println(Parent().method0()) //나는 부모
    println(Child().method0()) //나는 부모
    println(Child().method1()) //나는 자식
    println(Parent.prop) //나는 부모
    println(Child.prop) //나는 자식
    println(Parent.Companion.prop) //나는 부모
    println(Child.Companion.prop) //나는 자식
}
```
위에서  companion object가 같은 이름을 사용했을때의 경우를 보여줍니다.
같은이름을 사용하였을경우 자식클래스의 companion object 속성인 prop이 부모에서 정의 되어 있지만 가려져서 무시되는 것을 볼 수 있습니다.

즉, method0() 메소드는 Parent클래스 것이기때문에 그래서 부모의 companion object의 prop값인 “나는 부모”가 출력됩니다.

여기서 코드를 살짝 바꾸어보겠습니다. 자식클래스의 companion object에 이름을 부여합니다.
```
open class Parent{
    companion object{
        val prop = "나는 부모"
    }
    fun method0() = prop
}
class Child:Parent(){
    companion object ChildCompanion{ // -- (1) ChildCompanion로 이름을 부여했어요.
        val prop = "나는 자식"
    }
    fun method1() = prop
    fun method2() = ChildCompanion.prop
    fun method3() = Companion.prop
}
fun main(args: Array<String>) {
    val child = Child()
    println(child.method0()) //나는 부모
    println(child.method1()) //나는 자식
    println(child.method2()) //나는 자식
    println(child.method3()) // -- (2)
}
```

위 코드에서 주석 (1)에 자식 클래스의 companion object에 ChildCompanion로 이름을 부여했습니다. 그리고 자식 클래스에 3개의 메소드를 정의했습니다. 

child.method0()은 **부모의 method**이므로 어렵지 않게 “나는 부모”가 출력된 것을 예상할 수 있습니다. 그리고 child.method1()과 child.method2()도 역시 자식의 companion object의 속성을 가리킨다는 것을 알 수 있습니다.

주석(2)는 어떤 결과가 나올까요? 답부터 말씀드리면 “나는 부모”입니다. 자식의 companion object를 뛰어넘어서 부모의 companion object에 직접 접근이 가능하게 되었습니다.

왜냐하면 자식은 ChildCompanion로 이름을 바꿨으니 부모의 Comaniond을가져와 여기서 Companion은 부모가 됩니다.

우리가 여기서 알 수 있는점은  부모/자식의 companion object에 정의된 멤버는 자식 입장에서 접근할 수 있지만, 이름이 겹친다면 **섀도잉(shadowing)** 이 되어 감춰진다는 점을 알 수 있었습니다.


---
출처 :https://www.bsidesoft.com/8187
