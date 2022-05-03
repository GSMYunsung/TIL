
객체의 값을 복사하는경우 크게 **얕은 복사(Shallow Copy)**, **깊은 복사(Deep Copy)** 로 나뉘게 됩니다.


> “ 나는 단순히 해당 값만 필요해 해당값을 가져와 수정했을뿐인데 기존의 값도 같이 바뀌어버린다면? “


이런식으로 혼동해서 사용하면 결과값 자체가 바뀔 수 있으니 해당 개념을 인지하며 사용해야합니다.

## 얕은 복사(Shallow Copy)

얕은 복사의 경우, 값만 복사하는것이 아닌 주소 자체를 복사하기때문에 복사후 변수를 변경하거나 삭제하면 

기존 객체의 변수값에도 변화가 생깁니다.

```kotlin
class SampleClass(var id: Int) {
	...
}
```

```
val instance1 = SampleClass(1) // 인스턴스 생성

val instance2 = instance1 // 인스턴스1을 2에 얕은 복사 진행

instance2.id = 3 // 얕은 복사를 진행한 객체의 멤버변수를 변경

println(instance1.id) // 3
```

> 현재 당신이 instance1 의 값을 유지하고 해당 값만을 변경해야하는 상황에 놓여있다면?
> 

 

“ 뭐야 쉽잖아 "

하며 위의 코드같이 instance1 의 값을 instance2 의 변수에 저장해두고 instance2의 값을 바꾼다면?

instance1 의 값도 함께 바뀌는 마법을 확인할 수 있다.

다음 상황이 일어나 이유는 간단하다. 위의 코드를 통해 얕은 복사가 되어 주소값이 복사 되었기 때문에 

두변수가 같은 주솟값을 참조하면서 생기는 문제인것이다.

## ****깊은 복사 (Deep Copy)****

깊은 복사의 경우, 참조값이 아닌 객체 전체가 복사되기 때문에 복사한 객체의 변수값을 변경해도 기존 객체는 

변화가 생기지 않습니다.

```kotlin
data class SampleClass(var id: Int) {
	...
}
```

사실 간단한 방법이 있다. 

슬쩍 다음과 같이 클래스를 data class 로 변경해 본다면? 

깊은복사를 아주 쉽게 진행할 수 있다.

```
val instance1 = SampleClass(1) // 인스턴스 생성
val instance2 = instance1.copy() // 인스턴스1을 2에 깊은 복사 진행

instance1.id = 3 // 깊은 복사를 진행한 객체의 멤버변수를 변경

println(instance2.id) // 1
```

data class에서 제공하는 몇가지 기본 오버라이딩 메서드 중 copy() 메서드를 통해서 깊은 복사를 할 수 있다.

얕은 복사와 달리 복사한 객체의 값이 변하지 않는 것을 확인할 수 있다.

그렇다고 우리는 객체를 깊은 복사하기 위해서 무조건 data class로 변경해야할 필요는 없다.

여기서 부터는 여러 깊은 복사 방법에 대해 알아보도록 하자.


## 깊은복사의 첫번째 방법, **Cloneable**


깊은 복사를 하는 첫번째 방법은 **Cloneable** 이다.

**Cloneable** 인터페이스를 상속받아서 **clone() 메서드를 오버라이딩**하는게 핵심이다.

```kotlin
class SampleClass(var id: Int, var list: MutableList<Int>) : Cloneable {
    public override fun clone(): SampleClass {
        return super.clone() as SampleClass
    }
}
```

다음과 같은 코드를 보고 너무 쉬운데? 라고 생각하기전에 고려해야할것이 있다.

primitive type만 멤버변수로 갖고 있다면 매우 쉽게 깊은 복사가 가능하지만 우리가 클래스를 그렇게 호락호락하게 만들지 않는다..

타입을 정의하거나 리스트를 사용하거나 등등.. 여러 **기본형이 아닌 멤버변수는 깊은 복사가 되지 않는다**는 

단점이 있다.

이렇게 클래스에 clone을 오버라이딩해서 작성했다면 아래와 같이 리스트만 얕은 복사가 진행된다.

```kotlin
val instance1 = SampleClass(1, mutableListOf(1, 2))
val instance2 = instance1.clone()

instance1.id = 3
instance1.list.add(3)

println(instance2.id) // 1
println(instance2.list) // [1, 2, 3]
```

따라서 모든 맴버변수의 유형을 깊은 복사 해주기 위해서는 다음과 같이 clone 메서드를 재정의 해야한다.

```kotlin
class SampleClass(var id: Int, var list: MutableList<Int>) : Cloneable{
    public override fun clone(): SampleClass {
        val sampleClass = super.clone() as SampleClass
        sampleClass.list = mutableListOf<Int>().apply{ addAll(list) }
        return sampleClass
    }
}
```

다음 방법이 귀찮다면 다음 방법을 쓰면 된다.

## 깊은복사의 두번째 방법, Copy

두번째 방법은 data class의 copy 메서드를 사용하는것이다.

위에서 먼저 나왔던 data class 는 `toString()`, `hashCode()`, `equals()`, `copy()`

메서드가 이미 구현되어 있다.

그 중에서 우린 copy() 메서드를 통해 깊은 복사를 적용할 수 있다.

```kotlin
data class SampleClass(var id: Int) {
	...
}
```

```kotlin
val instance1 = SampleClass(1) // 인스턴스 생성
val instance2 = instance1.copy() // 인스턴스1을 2에 깊은 복사 진행

instance1.id = 3 // 깊은 복사를 진행한 객체의 멤버변수를 변경

println(instance2.id) //
```

상속은 신경 쓰지 않고 바로 copy 를 통해 깊은 복사를 할 수 있지만,

copy() 도 clone과 똑같이 **기본형이 아닌 변수는 깊은 복사가 안된다.**

그래서 결국 clone 과 똑같이 copy 를 다시 재정의 해주어야한다.

하지만 copy 는 **Any의 메서드가 아니기 때문에,** 

**직접 정의하려면 override 함수가 아닌 일반 함수로 정의**해야 한다.

```kotlin
data class SampleClass(var id: Int, var list: MutableList<Int>) {
    fun copy() : SampleClass {
        return SampleClass(id, list.toMutableList())
    }
}
```

다음과 같이 copy() 메소드를 따로 재 정의 해주면, 기존 copy() 가 아닌 해당 copy() 메서드로 완벽한 깊은 복사를 할 수 있다.

## 깊은복사의 마지막 방법, Gson

Gson 은 자바 오브젝트를 JSON 으로 변환 시켜주거나 반대로 해주는 구글에서 만든 라이브러리다.

해당 라이브러리를 사용하기위해 아래의 의존성을 먼저 추가하자.

```kotlin
dependencies {
  implementation 'com.google.code.gson:gson:2.8.8'
}
```

우리가 데이터를 복사하기 위해 사용할 메서드는 두가지이다.

- `fromJson` : Json 데이터를 지정한 타입으로 변환
- `toJson` : 지정한 타입의 데이터를 Json 형식으로 변환

**toJson 메서드를 사용해서 data class의 값을 먼저 Json 형식으로 변환**하고,

**fromJson 메서드를 사용해서 해당 데이터를 다시 data class의 형식으로 변환**

해주면 깊은 복사를 쉽게 할 수 있다.

```
data class SampleClass(var id: Int, var list: MutableList<Int>){
    fun deepCopy() : SampleClass {
        return Gson().fromJson(Gson().toJson(this), this::class.java)
    }
}
```
