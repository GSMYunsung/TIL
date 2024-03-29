MVP

MVP 가 뭘까?

MVP 패턴이란 Model, View, Presenter 의 첫글자를 따서 이름이 지어졌습니다. 
MVP 모델의 핵심 설계는 MVC와는 다르게 UI(View) 와 비지니스 로직(Model)을 분리하고, 
서로 간의 상호작용을 다른 객체 (Presenter)에 그 역할을 줌으로써 서로의 영향(의존성)을 최소화하는 것에 있습니다. 
MVP의 역할에 대해 설명하면 다음과 같습니다.
❗
Model : 데이터의 저장 및 처리
View : UI 처리
Presenter : Model 과 View를 이어주는 매게채

- MVC의 Controller처럼 Presenter도 어느 정도 시간이 지남에 따라 추가 비즈니스 로직이 집중되는 경향이 있습니다.
- 개발자는 시간이 지난 어느 순간 거대해지며 동시에 다루기도 어렵고, 문제가 발생하기 쉽고, 서로 간의 분리를 하기도 어려운 `Presenter`를 발견하게 됩니다. (물론 초기에 설계/기획을 잘함과 동시에 유능한 개발자라면 시간의 흐름에 따른 앱의 다양한 변화에 맞춰서 이 문제를 해결해나갈 수 있겠지만 실제로는 그것도 쉽지만은 않습니다.)

MVC와는 다른 장점, 단점
장점

- MVC와는 다르게 코드가 매우 깔끔해지며 MVP를 사용하여 **`Model`과 `View`** 간의 의존도를 낮추면, 새로운기능이 추가되거나 오류가 발생할 때 오류가발생한 부분이나 새로운 기능을 해당 부분만 수정하면 되기 때문에 확장성과 안전성이 동시에 좋아진다. 또한, 유닛 테스트시 테스트코드를 작성하기 간편해지기때문에 다시 한번 더 안정성이 보장된다고 보면 됩니다.

- 그리고 UI, Data 각각 파트를 나누기 때문에 해야 할 일이 명확해지고 코드를 보기 쉬워져 그 결과로 쉽고 빠르게 코딩이 가능합니다.

단점

- 위에서 말했던것과 같이 애플리케이션이 복잡해질수록 `View` 와 `Presenter` 사이에 의존성이 강해진다는 단점이 있습니다.

- MVC의 Controller처럼 Presenter도 어느 정도 시간이 지남에 따라 추가 비즈니스 로직이 집중되는 경향이 있습니다.
- 개발자는 시간이 지난 어느 순간 거대해지며 동시에 다루기도 어렵고, 문제가 발생하기 쉽고, 서로 간의 분리를 하기도 어려운 `Presenter`를 발견하게 됩니다. (물론 초기에 설계/기획을 잘함과 동시에 유능한 개발자라면 시간의 흐름에 따른 앱의 다양한 변화에 맞춰서 이 문제를 해결해나갈 수 있겠지만 실제로는 그것도 쉽지만은 않습니다.)
