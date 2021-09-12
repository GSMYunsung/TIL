## HiltViewModel에 대해 알아보자!
---

## Overview_

안드로이드 앱 개발시 뷰 모델을 구현할 때, 액티비티 또는 프래그먼트의 구성 변경에도
데이터가 유지되는 **AAC-ViewModel🔎** 클래스를 상속하는것을 권장합니다. **AAC-ViewModel🔎**을 사용할 때 생명주기에 맞춰 데이터를 유지, 보존하기위해 프로그래머는 **ViewModelProvider.Factory🏭** 를 구현하고 **ViewModelProvider🤲** 클래스가 뷰모델 인스턴스를 관리하도록 해야합니다.

하.지.만! 

매번 ViewModelProvider.Factory 를 구현하려면 많은 중복 코드가 발생할 수 밖에없는데, 기존에는 이러한 중복코드를 막을 방법이 없었지만.. ``Dagger2, Koin``과 같은 의존성 주입 라이브러리를 통해 비교적 편리하게 사용할 수 있게 되었습니다! 🎉

사실 Dagger라는 라이브러리도... 좋긴좋지만 복잡한 어노테이션, 높은 러닝커브 때문에 불편함이 많았던건 사실이라고 합니다...

그.래.서 

``Dagger Hilt`` 라는 라이브러리가 새로나오면서 적은 코드만으로 뷰모델 주입이 가능해졌습니다!(🎉🎉 이건 두번폭죽감이지ㅋㅋ)

이러한 배경을 보다가 최근 Dagger Hilt 공부를 시작하게되었는데 코드가 어떻게 작동하는지 문득 궁금해져서 공부겸 기록으로 남기려고 동작 원리에 대한 글을 쓰게 되었습니다.

## Before Entering_

### Multibindings

우선 먼저 알아야하는 기능이 있습니다. 바로바로! ``Multibindings🎉`

> **멀티바인딩이란?**
@IntoMap 어노테이션이 지정된 모든 주입 대상 객체를 컴포넌트 내부에 선언된 Map 인스턴스에 모아주는 기능입니다!

우리는 이러한 바인딩을 기존 Dagger2 에서도 지원하는 기능인 멀티바인딩을 활용하여ViewModelProvider.Factory를 매번 구현하지 않고도 사용이 가능했습니다.

**ex)**
![](https://images.velog.io/images/yunsung_/post/8278261a-3b0f-4601-92a4-33d716d2d6c3/image.png)이러한 클래스 묶음을

![](https://images.velog.io/images/yunsung_/post/0871d2ba-3588-49fc-9d75-4c7cf395e600/image.png)

다음과같이 어노테이션이 해당되는클래스의 함수를 Map으로 묶어주는 느낌!

## 기존 Dagger2 에서의 뷰모델 생성 방식
![](https://images.velog.io/images/yunsung_/post/f0868d6a-22fd-4fe9-834e-f64a2a127e0a/image.png)

1. Dagger2 에서 멀티바인딩 기능을 사용하여 뷰모델을 식별해줄 Key 와 ViewModel 객체를 모듈에 선언합니다.
2. ViewModelProvder.Factory 를 상속받은 뷰모델팩토리(ViewModelFactory) 클래스를 만들어서 대거를 통해 주입받은 map(creators)에서 뷰모델 key 로 조회하여 뷰모델을 생성하도록 구현
3. 액티비티에서는 viewModelFactory 를 주입 받아서 뷰모델을 생성!

### 개선된점

Dagger2 를 사용 했을 때는 뷰모델 클래스가 추가될 때마다 매번 viewModelFactory 를 만들어주어야 하는 불편함은 개선 되었지만, 멀티바인딩 기능에 대한 학습이 필요하고 의존성 주입을 하기 위해 필수적으로 구현해야 하는 모듈이 많았습니다.

## Dagger Hilt 에서의 뷰모델 생성방식

![](https://images.velog.io/images/yunsung_/post/de41ca12-00ba-4822-872d-148c3efa3656/image.png)

1.액티비티에서는 @AndroidEntryPoint 어노테이션을 읽어서 Hilt_XXXActivity 를 생성합니다
2.Hilt_XXXActivity 내부에서는 getDefaultViewModelProviderFactory() 메서드를 오버라이드하여 앞서 Dagger2 를 사용할 때 직접 만들었던 ViewModelFactory 와 동일한 역할을 수행하기 위한 HiltViewModelFactory 를 반환하도록 합니다
3.activity-ktx 라이브러리에 선언된 확장함수를 이용하여 간단하게 AAC-ViewModel 을 생성하고 사용할 수 있게 되었습니다.

## Conclusion_

Dagger Hilt 에서 개발자가 직접 구현했어야 했던 모듈, 컴포넌트를 모두 미리 생성해주어서 간단하게 DI 을 할 수 있게 되었습니다!!🎉
