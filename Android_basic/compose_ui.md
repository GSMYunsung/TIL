안드로이드 UI	

UI를 xml로 선언 , 속정을 지정하면된다.

그리고 어플리게이션의 상테가 변할경우 UI를 업데이트 해야합니다. 각 보기에 업데이트를 보장하느느데 필요한 일부 상태가 있기때문에 모델과 UI간의 상호 관계가 복잡해질 수 있습니다.

하지만 compose는 상태를 UI로 변환합니다.

따라서 상태가 업데이트되고나면 UI를 새표현으로 변환하기 위해 재실행합니다. 이렇게 하면 동기화문제가 해결되고 전체 UI를 재생성합니다.

하지만 변경되지 않은 부분도 건드린다.

컴포저블함수는 데이터를 함수 매개 변수로 사용하고 UI를 내보냅니다.

 viewmodel의 livedata와 함께사용하면 변경된 사항만 다시 실행 하는것같다.

컴포저블을 내보낼때는 모든 정보를 매개변수로 전달해야 합니다.

다만 체크박스는 예외인데 체크박스를 눌렀을 때 체크박스가 눌리고 나서 토글 즉 체크표시가 나오는것을 직접 처리해주어야한다.

하지만 이 모든것이 선언적 UI의 핵심 개념입니다.

만약 UI상에서 오류가 생기면 UI를 다시 업데이트 할필요없이 코드를 완전히 제어할 수 있다.

선언적 UI의 Key Idea(핵심 아이디어) 는 주어진 상태에 대한 UI의 모양을 완전히 설명하고 상태가 변경될 때 프래임워크가 UI 변경을 처리한다는것!
