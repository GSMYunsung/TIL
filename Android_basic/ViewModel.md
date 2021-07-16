## ViewModel 그게 뭔데? 💁

특정 액티비티 화면과 연동되며, 해당 화면에 보여줄 데이터를 형식화하는 로직을 두는곳.
화면에서 필요한 모든 데이터를 "종합" 하고 "형식화" 할 수 있는것이다.

 > 즉,생명주기에 영향을 받지않고 값을 저장 할 수 있는곳이다!

## 근데 왜 (Why?) 필요해❓

화면이 로테이션 되어 엑티비티가 재실행 되거나 잠시 앱을 나가고 다시 실행할 경우해당 엑티비티의 리소스는 제거하고 다시 새로운 엑티비티의 리소스를 가져오게됩니다.

그래서..

우리는 생명주기가 변경되어도 저장되어야 하는 값은 저장시켜주어야합니다. 하지만 화면이 변경될 때 마다 저장을 일일이 시켜주기란.. 쉽지않습니다. 코드도 일일히 작성해야하고 무엇보다 리소스를 소모하게되어 좋지 않을 수 있습니다.

그.래.서!

우리는 **ViewModel** 을 사용하게 되었습니다! 왜냐하면 ViewModel 객체는 엑티비티의 Lifecycle 상태가 종료(FINISH)상태가 될 때 까지 소멸되지 않습니다. 즉, 화면이 위와같은 이유로 재실행되어도 ViewModel은 데이터를 앱이 Finished 가 되기전 까지 유지하고있습니다.

![](https://images.velog.io/images/yunsung_/post/46919603-8db4-402a-a386-2eeab5217160/image.png)

## 좋아! 그럼 사용하는방법은? 🧾

### 우선 문제가 있는 앱을 참고해봅시다!

![](https://images.velog.io/images/yunsung_/post/0e4e4788-4e6b-400d-befd-d118aca9280b/image.png)

다음과 같은 심플한 타이머를 만들어 보았습니다. 이 앱의 문제점은?

> 회전을 하면 타이머가 다시 0부터 시작해요!!

![](https://images.velog.io/images/yunsung_/post/d5e183a4-ef2e-4cd7-9b59-e0a28d7e0c48/image.png)
(Rotation되면서 Configuration Change가 발생하였고 액티비티가 재실행되어 다시 0부터 시작하는 모습)

그래서 우린 이 오류를 **ViewModel** 로 고쳐볼겁니다.
 
### ViewModel로 문제를 해결해봅시다!🥸

#### 우선 ViewModel을 작성해주겠습니다!

![](https://images.velog.io/images/yunsung_/post/392d4579-cd95-4c64-b6f7-fd397208e1b6/image.png)

#### 그 다음 MainActivity의 코드를 작성해 주겠습니다!

![](https://images.velog.io/images/yunsung_/post/11304dd3-6453-4b45-bbb7-71679091149f/image.png)

ViewModelProviders로 ViewModel의 객체를 생성해주고 그걸 이용해 countsave()로 ViewModel에 값을 저장하고 getcount로 값을 받아와 타이머에 넣어주어 타이머가 작동되게 해 주었습니다. 이제 만약 액티비티가 재실행된다고 해도 ViewModel은 소멸되지 않고 이전에 생성한 것을 사용하기 때문에 startTime은 처음에 설정된 값을 갖고 있습니다.

다음과 같이 하면??!?

![](https://images.velog.io/images/yunsung_/post/e1860486-3927-4800-8476-ac56716898af/image.png)

쨘! 🎉 다음과 같이 화면을 돌려도 값이 변하지않는것을 알 수 있습니다.

## TMI(추가 정보들)  🦔

#### ViewModel에 대해 조금더 알아볼까요? 🔍

1. ViewModelProVider (요청) => ViewModel (객체반환)

2. 장치구성이 변경되어도 ViewModel을 다시 불러오는것이 아닌 최초로딩이된것을 가져오고 MainActivity의  상태에따라 그대로 변화한다.

3. 단방향! MainActivity 는  ViewModel을 참조하지만 ViewModel은 MainActivity를 참조하지 않는다.

4. 만약 ViewModel에서 Context나 Activity 객체를 사용하고 싶다면 ViewModel을 사용하지 말고 AndroidViewModel를 사용해야 합니다.

**주의할점!**

- 소멸되어야 하는 객체의 참조를 다른 객체가 참조하면 메모리 유실이 생길 수 있다! - 강한참조

- 현재 사용되지 않는 과거 액티비티의 참조를 가지게되어 ViewModel 인스턴스가 과거 액티비티의 뷰를 변경하려고 하면 오류발생!
