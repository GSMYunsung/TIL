## MVVM 이 뭘까?

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f029dc47-802c-4478-a517-6db641c4364e/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220419%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220419T112006Z&X-Amz-Expires=86400&X-Amz-Signature=ebdc39e623dbf100d5f4f12fd149bd3819355c191b33501a8183631e50a18fa2&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

MVVM 패턴이란 **Model, View, ViewModel의** 줄임말입니다. 하나의 소프트웨어를 최대한 기능적으로 

작은 단위로 나누어 의존성을 낮추어 테스트가 쉽고 큰프로젝트들도 관리하기 쉬워지게 만들어주는 구조입니다.

모든 입력들은 `View` 로 전달되며 `ViewModel`은 입력에 해당하는 `Presentation Logic`을 처리하여 `View`에 데이터를 전달합니다. `ViewModel`은 `View`를 따로 참조하지 않기 때문에 독립적이며 `ViewModel`과 View는 1:n의 관계입니다. 따라서 `View`는 자신이 사용할 값이있는 `ViewModel`을 선택해 데이터를 바인딩하여 정보의 업데이트를 받게됩니다. 

그후, Model이 상태 및 데이터가 변경되면 해당하는 ViewModel을 통해 자동으로 View가 업데이트가 된다.

마지막으로 ViewModel은 View를 나타내기 위한 Model이자, View의 Presentation Logic을 처리합니다.

MVP와 마찬가지로 M-V 사이의 의존성이 없고, MVP처럼 V-VM이 1:1 관계가 아닌 독립적이기 때문에 이 둘 사이의 의존성도 없습니다.

<aside>
❗ **model** : 비즈니스 로직

**view** : view 화면 UI 처리

**view model** : View와 Model 사이의 매개체

</aside>

- 자세히보기
    
    **View**
    
    - View 는 Activity 나 fragment 같은 화면에 표현하는 레이아웃을 정의함
    - View는 기본적으로 데이터를 보여주기만 해야 해서 비즈니스 로직을 포함하지 않지만 UI 변경과 관련된 일부 로직은 포함될 수 있음.(안드로이드는 다른 플랫폼과는 다르게 생명주기(lifecycle)이라는 특수한 순서(Flow)를 가지고 있기 때문에 이것을 처리하는 것만으로도 View는 상당히 복잡해지기 때문임.)
    - View는 ViewModel을 관찰하고 있다가 상태 변화가 전달되면 화면을 갱신해야 함
    
    **Model**
    
    - MVC의 Model과 역할은 동일함.
    - DataModel이라고도 하며 DB, Network, SharedPreference 등 다양한 데이터 소스로부터 필요한 데이터를 준비함.
    - ViewModel에서 데이터를 가져갈 수 있게 데이터를 준비하고 그에 대한 "이벤트"를 보냄.
    
    **ViewModel**
    
    - View와 Model 사이의 매개체 역할을 함.
    - 모든 View와 관련된 비즈니스 로직은 이 곳에 들어가게 되며 데이터를 잘 가공해서 View에서 뿌리기 쉬운 Model로 바꾸는 역할을 함.
    - View와 ViewModel은 MVP와는 다르게 1:n의 관계를 가질 수 있으며 여러 개의 Fragment가 하나의 ViewModel을 가질 수 있음.
    - ViewModel은 View가 데이터 바인딩(Data Binding)할 수 있는 속성과 명령으로 구성되어 있음.
    

## MVVM 의 장점

**Model과 View 사이, ViewModel과 View 사이의 의존성이 없으므로**

유닛 테스트가 더 쉬워지며 MVP패턴에서처럼 테스트를 위한 가상 뷰를 만들 필요 없이, 테스트할 때 모델이 변경되는 시점에 옵저버블(관찰) 변수가 제대로 설정됐는지 확인하면 됩니다

Databinding 라이브러리를 이용함으로써 서로 간의 의존성을 낮추고, 유닛 테스트를 더욱 쉽게 작성할 수 있고 UI 코드는 네이티브 코드에 관여하지 않아도 됩니다. 또한 중복되는 코드를 모듈화 할 수 있습니다.

## MVVM 의 단점

View가 변수와 표현식 모두에 binding 될 수 있으므로 시간이 지남에 따라 관계없는 Presentation Logic이 늘어나고 이를 보완하기 위해 XML에 코드를 추가하게 됩니다. 이때 난해하게 코드가 증가된다면 유지보수 단계에서 어려움을 겪을 수 있습니다.

또 ViewModel은 설계하기가 어려운 문제도 있습니다.

다행히 요즘은 잘 설계된 구조가 샘플 코드로 많이 나와 있기 때문에 해결이 가능합니다.
