```

❗ **개념알고가기**

View Model 과 Data Domain 단위를 이어주는 레이어

기존 흐름은 ViewModel → View
적용시킨후 흐름은 ViewModel → Repository → View

```

## Repository 패턴과 MVVM

![](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/497599ed-c7d6-4623-947f-6caabbdc3910/Untitled.png)

`Repository` 의 역할을 이해하기 위해선 `MVVM` 패턴을 먼저 살펴볼 필요가 있습니다.

우선 MVVM을 살펴보자면 `Repository` 가 `ViewModel` 과 `Room` 이라고 하는 `DB` 나 `Retrofit` 사이에 있습니다.

`ViewModel` 이 Activity 나 Fragment 같은 `UI` 에서 `Repository` 에 값을 요청하면 요청한 데이터를 보내준다는 뜻입니다.

이렇듯 분업화가 확실합니다.

 `Repository` 는 `ViewModel` 이 요청하는 데이터를 `Room` 이나 `Retrofit` 에서 가져옵니다.

이렇게 해주면 `ViewModel` 이 누구에게 가져온 어떤 데이터인지 알 필요도 없고 

그에따라 신경을 써줄 필요가 없게 되겠죠

이런것들은 `Repository` 가 알아서 처리해 주니까요.

<aside>
❗ **내용 정리 및 결론**

데이터 출처에 상관없이 ViewModel이 누구에게 가져온 어떤 데이터인지 알 필요도없이 
ViewModel 이 자신의 비지니스 로직에만 집중할 수 있게 해주는게 Repository 라는 뜻입니다.

</aside>

## Repository 예시

아래 코드는 Repository 클래스가 없이 ViewModel 에서 직접 Realm 데이터 베이스의 Dao 클래스를 이용해서

데이터를 가져오고 있는 코드입니다. 

- 이렇게 되면?
    
    비지니스 로직에 신경을 써야할 ViewModel 클래스가 
    로컬 DB인 Realm의 초기화까지 겸하게 됩니다.
    

![](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/893c5236-3237-4112-9155-1b184dd4d67d/Untitled.png)

이제 Repository 클래스를 추가한 코드입니다. 

ViewModel 에서 직접 접근했던 것들을 아래와 같이 Repository 클래스를 추가해 따로 빼줍니다. 

- 이렇게 바꾸면?
    
    새로운 레이어가 하나 추가되지만 이제 더이상 ViewModel 에서 
    
    DB 초기화와 같은 일은 하지 않아도 되게 됩니다.
    

![](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d5cac67b-f34d-43b1-85e5-1cdfbc148bb7/Untitled.png)

![](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/954722a4-b270-4d6d-8b5f-fbdd51c9ada2/Untitled.png)

## 결론

결론적으로는 Repository 패턴을 사용한다면 분업화가 확실하게 진행되어 서로간의 역할이 명확해 집니다.

또한 모듈의 교체도 유연해지고 더 나아가 최종적으론 유지보수가 쉬워집니다.

하지만 중간에 추상화가 된 레이어가 존재해 관리할 파일과 코드가 많아지는데, 

분업화 하는 과정에서는 사실 어쩔수없는 부분이긴 합니다.
