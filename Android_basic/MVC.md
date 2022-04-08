
# MVC

// 예시

override funonCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
		//view
    setContentView(R.layout.activity_main)

//Model (모델설정)
varuser = User("용이", 28,"yongyi@google.com")

		//controller
    button.setOnClickListener{
name_text_view.setText("${user.name}")
        age_text_view.setText("${user.age}")
        email_text_view.setText("${user.email}")
		}
}
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c48bdbe2-a7f4-4cf4-a8b0-4876b97e29ab/Untitled.png)

MVC 패턴은 간단하게 말하면 

`model - view - controller` 이고, 

model - view 사이에 `controller` 가 

둘의 사이에서 커뮤니케이션 할 수 있도록 

연결해주는 패턴이다.

MVC 패턴의 `역할`에 대해 정리하면 다음과 같다.

<aside>
❗ **model** : 비즈니스 로직

**view** : UI 로직

**controller** : flow 로직

</aside>

- 추가적인 설명
    
    **view** 
    
    - 사용자에게 보일 화면을 표현.
    - 앱 및 UI와의 상호작용에서 컨트롤러와 통신함.
    - 유저가 어떤 입력(Action)을 하든 View는 무엇을 해야 할지 모름
    
    **model**
    
    - 데이터를 가지며 애플리케이션에서 사용되는 데이터와 그 데이터를 처리함.
    - View 또는 Control에 묶이지 않아 재사용 가능함.
    
    c**ontrol**
    
    - 사용자로부터 입력을 받고 이 입력을 모델에 의해 View 정의를 하게 됨.
    - 모델의 데이터 변화에 따라 뷰를 선택함.

추가적으로 설명하자면 여기서 컨트롤러의 역할은 model 과 view 에 있는 단위별 메소드들을 이용해

레고를 조립하듯이 흐름 설계도 같은 `flow 로직`을 짜는것이다.

 또한 에러 발생시에도 어떻게 뷰에 보여줄지 결정해서 넘겨주게 된다.

## 왜 안드로이드에선 MVC 패턴이 적용되기 어렵나?

한마디로 정리하자면, View-Controller 를 분리하는것이 애매하다.

만약 이런상황을 예로 들어보자.

```markdown
# view : xml 구조로 두고, activity를 controller 로 설정한다는 상황
```

이 경우 activity 가 너무 많은 일을 담당하게 된다. view 입력 이벤트 받기, 표시, model을 통한 데이터 가져오기

및 업데이트, flow 로직 등 이것만해도 충분히 기능이 많은데 추가적으로 안드로이드의 액티비티는 그 자체로도 많은 역할을 하고 있다.

> 라이프 사이클 관리, 파일 I/O, shared preference 등 자체로도 view + controller + other *etc...*
> 

결과적으론 액티비티에 어마어마한 양의 코드가 쌓인다고 볼 수 있다. 따라서 유지보수가 어려워질 뿐만아니라 

가독성과 더 나아가서 협업의 문제가 될 수있다.

따라서 `MVC 패턴`의 문제점을 보안할 `Non-MVC 전략` 이 등장했다.

## 명확한 장점, 단점

<aside>
❗ **Non-MVC 전략**

Non-MVC 전략의 경우엔 Activity의 `역할은 최소한` 으로 만들고 각각의 `역할을 명확히 분리` 하는 데 있다.

또한 view만 플랫폼 의존적으로 두고 나머지 presenter, viewmodel 부터는 독립적으로 떼어내려는 것이다.

안드로이드에선 크게 2가지의 패턴이 사용된다. `MVP, MVVM` 이다.

</aside>
