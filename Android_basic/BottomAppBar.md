## Bottom AppBar란?

![](https://images.velog.io/images/yunsung_/post/64dd0bc1-eb09-4f4a-badc-48742fc986dd/image.png)

Material 2.0에서 소개된 바텀앱바는 특정한 한두가지의 주요한 동작(액션)이 있는 앱에 사용하기 적합한 UI입니다. 사용자에게 보여주어야할 메뉴가 많은경우에는 Drawer, 4~5가지 정도의 범주로 나누어진다면 Bottom Navigation View 혹은 TabLayout + Viewpager가 적합합니다.

## 사용하기 유용한 상황!
ex) 
- TO-DO리스트 
- 노트처럼 할일만들기 
- 노트생성과 같은 기능

즉, 기능이 명확할때! 사용하기 좋습니다.    

## Bottom AppBar의 장점과 단점!
![](https://images.velog.io/images/yunsung_/post/3fabb549-0e19-4233-94b3-fe64b9894d63/image.png)

Bottom AppBar는 다음과같이 사용자가 스크롤을 해야한다고 미리 암시해놓을 수 있습니다.
동그란 Floating App Bar와 Bottom App Bar 사이에 빈 공간을통해 컨텐츠를 일부분 노출함으로써 직관적으로 스크롤을 내려야 더 많은 컨텐츠를 볼 수 있다고 알려줍니다.

![](https://images.velog.io/images/yunsung_/post/496a7152-e9e9-4961-8e11-c62ca1069dfd/image.png)

또한 큰 장점중의 하나는 다음과 같이 스크롤 시 하단 부분을 가려 전체화면과 동일한 레이아웃효과를 제공합니다.

![](https://images.velog.io/images/yunsung_/post/3677991e-ae75-4ea2-9c6e-2b4e1ac53b2d/image.png)

하지만 다음과같이 Tost가 Appbar를 가릴 수 도있으니 주의해서 사용해야합니다.

## Bottom AppBar 만들어보기!

**기본형식**

```
<androidx.coordinatorlayout.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
  
  <!-- FrameLayout 혹은 컨텐츠 영역 -->

  <com.google.android.material.bottomappbar.BottomAppBar
      android:id="@+id/bar"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_gravity="bottom"
      app:navigationIcon="@drawable/ic_menu_24"/>

  <com.google.android.material.floatingactionbutton.FloatingActionButton
      android:id="@+id/fab"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      app:layout_anchor="@id/bar"/>

</androidx.coordinatorlayout.widget.CoordinatorLayout>
```	
다음이 Bottom AppBar의 기본 형식입니다. BottomAppBar의 주의할점은 CoordinatorLayout과 함께 사용해야하며 안드로이드 스튜디오 3.2 이하버전에서는 레이아웃이 제대로 표현되지 않을 수 있습니다.

**AppBar의 속성**

FAB Alignment(app:fabAlignmentMode)
앱바의 정렬 위치를 설정할 수 있습니다.
![](https://images.velog.io/images/yunsung_/post/e46141ec-5740-46d2-a71b-2b89a2965f63/image.png)
fabAlignment: CENTER
![](https://images.velog.io/images/yunsung_/post/fb6d7f86-ebc2-499f-a811-05686def4175/image.png)
fabAlignment: End

<br>
다음과 같은 코드로 프레그먼트가 전환될때 애니메이션을 줄 수도있습니다.

```
app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
```
![](https://images.velog.io/images/yunsung_/post/18ae9822-c46d-4217-adb9-08468148686c/image.png)

**FAB Attached**

바텀앱바와 플로팅버튼이 떨어져있을지 붙어있을지 설정할 수 있습니다. false로 한다면 아래와같은 형태로 볼 수 있습니다.

![](https://images.velog.io/images/yunsung_/post/cf3fc0c4-7584-4b73-a29e-a04e4bfc31dc/image.png)

**fabCradleRoundedCornerRadius**
플로팅버튼과 AppBar사이의 간격을 조절할 수 있습니다.

![](https://images.velog.io/images/yunsung_/post/0c0ccb22-23e8-4b18-89a3-61a71aa74e8d/image.png)

**navigation**

![](https://images.velog.io/images/yunsung_/post/7b8c5219-252e-40b1-ac27-f2c7647eb06d/image.png)

왼쪽의 네비게이션 아이콘과 오른쪽의 메뉴아이콘입니다. 주로 왼쪽은 DrawrLayout처럼 여러 아이콘을 보여줄때 사용합니다.
주로 BottomSheetDialog를 통해 구현합니다.

```
bottomAppBar.setNavigationOnClickListener
```

 반면 오른쪽메뉴는 즐겨찾기, 검색과같이 사용자의 사용빈도가 조금 더 많은 메뉴들을 구현할때 사용합니다. 클릭될 경우 아래와 아래와 같은 리스너를 사용해 구현합니다.
 
 ```
 bottom_app_bar.replaceMenu(R.menu.menu_bottom_nav)
bottom_app_bar.setOnMenuItemClickListener({
    //구현부분
})
```

---
[출처] : https://medium.com/harrythegreat/android-bottom-appbar-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-9071ec428138
