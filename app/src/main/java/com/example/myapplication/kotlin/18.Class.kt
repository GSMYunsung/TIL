package com.example.myapplication.kotlin

// 18. Class

// OOP -> Object Oriented Programing (객체지향 프로그래밍)

// 객체란 뭘까?
// - 이름이 있는 모든 것

// 잘차지향 프로프래밍 문제 해결 방법
//- 코드를 위에서 부터 아래로 실행을 하면 문제가 해결된다!

// 객체지향 프로그래밍 문제 해결 방법
// - 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결한다!
// - 선수, 심판, 경기장, 관중 -> 축구 게임
// 자신에게 필요한 구성요소들을 하나의 객체로 만들어서 필요할때마다 써서 해결

// 객체를 만드는 방법
// - 설명서가 있어야 한다.

fun main(array: Array<String>){

    //클래스(설명서)를 통해서 실체를 만드는 방법
    // -> 인스턴스화 -> 인스턴스(객체)
    Car(engine = "v8 engin",body =  "big")
    val bigCar = Car(engine = "v8 engin", body = "big")

    // 우리가 만든 클래스(설명서)는 자료형이 된다
    val bigCar1 : Car = Car(engine = "v8 engin", body = "big")

    val runableCar : RunableCar = RunableCar(engine = "simple engine", body = "shrotbody")

    //RunableCar.ride() -> 불가능!
    //객체를 생성하고 구성요소들을 다 넣어줘야지만 실행이 가능하다.

    runableCar.ride()
    runableCar.navi("서울")
    runableCar.drive()

    // 인스턴스의 멤버 변수에 접근 하는 방법
    val runableCar2 : RunableCar2 = RunableCar2(engine = "nice engine", body = "long body")
    println(runableCar2.body)
    println(runableCar2.engine)

    val testCalss : TestClass = TestClass()
    testCalss.test(1)
}

// 클래스(설명서) 만드는 방법(1) -> 축약
class Car(var engine : String, var body : String){
    val supercar : SuperCar = SuperCar(engine = "good engin" , body = "big", door = "White")
}

// 클래스(설명서) 만드는 방법(2) -> 기본
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String){
        println(engine)
        println(body)
        println(door)

        this.engine = engine
        this.body = body
        this.door = door
    }
}

// 클래스(설명서) 만드는 방법(3) -> 1번 방법의 확장
class Car1 (engine: String, body: String){ // constructor의 생략
    // 인자값을 두개만 준다면 engine body로 할당됨

    var door : String = " "

    //생성자
    constructor(engine: String, body: String, door: String):this(engine,body){
        // 만약, 인자값을 door까지 넘겨준다면 이쪽으로 와서 값이 할당됨
        // 즉, 필수적인 요소가 아니라면 이렇게 빼주는 것도 나쁘지 않음
         this.door = door
    }
}

// 클래스(설명서) 만드는 방법(4) -> 2번 방법의 확장
class Car2{
    var engine : String = ""
    var body : String = ""
    var door : String = ""

    constructor(engine: String, body: String){
        this.engine = engine
        this.body = body
    }
    constructor(engine: String, body: String, door: String){
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String){

    fun ride() {
        println("탑승 하였습니다")
    }

    fun drive(){
        println("달립니다 !")
    }

    fun navi(destination : String){
        println("$destination 으로 목적지가 설정되었습니다")
    }
}

class RunableCar2{
    var engine :String = ""
    var body: String = ""

    constructor(engine: String, body: String){
        this.engine = engine
        this.body = body
    }

    init {
        //클래스안에 적을 수 있고, 객체가 만들어질 때 우선 호출된다
        // 초기 세팅을 할 때 유용하다.
        println("RunableCar2가 만들어 졌습니다.")
    }

    fun ride() {
        println("탑승 하였습니다")
    }

    fun drive(){
        println("달립니다 !")
    }

    fun navi(destination : String){
        println("$destination 으로 목적지가 설정되었습니다")
    }
}

// 오버로딩
// 이름이 같은 함수가 받는 매게체가 서로 다르다면
// 같은 이름으로 다른 함수가 될 수있다.

class TestClass(){
    val a: Int = 10
    val b : Int = 11

    fun test(a: Int){
        //
    }
    fun test(a: Int, b: Int){
        //
    }

}
