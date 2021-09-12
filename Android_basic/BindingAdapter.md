## 바인딩 어뎁터에 대해 알아보자!!

---

## before start_

안드로이드 xml을 짜다 문득 건들고 싶은 뷰의 속성이 xml 메서드에 없는것을 보았다.
그래서 엑티비티에서 내가 원하는 메서드를 만들어 사용하듯이 xml에서도 사용할 수 있는 속성 설정을 만들어 사용할 수있는 방법에 대해 찾아보다, binding Adapter 라는 속성을 발견하게 되었다. 그래서 오늘은 Binding Adapter에 대해 알아보도록 하겠다.

![](https://jjalbang.today/jjv1HQ.gif)

## Binding Adapter_


### 1. 사용 방법

```
object TestBindingAdapter {
    @JvmStatic
    @BindingAdapter("this_is_binding_text")
    fun setText(view: TextView, text: String){
        view.text = text + "\n" + "하지만 바인딩 어뎁터로 바뀌었습니다!"
    }
}
```

- object: Binding Adapter는 메모리상에 올려서 사용해야 하기 때문에 Object로 생성한다.

- @JvmStatic: 전역 변수의 Getter Setter를 정적 함수로 설정하는 어노테이션이다.

- @BindingAdapter: 괄호 안에 원하는 메서드 이름을 지어주면 된다.

- setText: 이 메서드 이름도 원하는 걸로 정해주면 된다. 텍스트 뷰를 수정하는 기본 메서드 이름이 setText라고 해서 꼭 그걸 따라 사용하지 않아도 된다. (오버 라이딩 아님)

다음은 바인딩 어뎁터의 필수 속성이다. 또한 setText 메서드 안에서 'view.' 까지만 입력해도 자신이 커스텀 할 수 있는 기능들이 다양하게 나타난다. 여기서는 사용자가 원하는 메서드를 이용해 원하는 기능을 넣어주면 된다.

> 추가적으로 어노테이션에 대해 알고싶다면 다음 블로그를 참고하자!
[날고싶은개발자님 블로그](https://jaejong.tistory.com/106)


### 2. Layout

```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools%22%3E
 
    <data>
        <variable
            name="activity"
            type="com.example.selfstudy_kotlin.MainActivity" />
    </data>
 
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
 
        <TextView
            android:id="@+id/txt_number"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="24sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            
            <--인자 값으로 activity에 있는 introduce라는 변수를 넘겨준다.-->
            
            this_is_binding_text="@{activity.introduce}"/> 
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

레이아웃에서는 다음과 같이 사용할 수있다. 이때 앞에 'android:' 나 'app:'을 붙이지 않아도 된다. 

### 3. Activity

```
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var introduce = "안녕하세요. 저는 일반적인 텍스트 입니다."
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
    }
}
```

대충.. 바인딩을 배웠으면 알거라 믿지만 모르는 사람들을 위해 설명하자면 바인딩을``private lateinit var binding: ActivityMainBinding``로 받아와주고 다음과 같이 ``binding = DataBindingUtil.setContentView(this, R.layout.activity_main)`` 로 초기화를 시켜준다. 그리고 현재 엑티비티의 객체를 ``binding.activity = this`` 로 넘겨주는 코드이다.

### 4. Binding Adapter! 왜필요한건데?

![](https://images.velog.io/images/yunsung_/post/4dc91f15-9edd-4122-9b58-200cc1293de1/image.png)

단순히 뷰에 사용할 메서드를 직접 자신이 원하는대로 커스텀 할 수있다는 사실만으론 ``binding Adapter`` 를 써야하는 이유가 크게 와닫지않았다. 또한 방금의 코드들은 엑티비티에서 처리하게 하면 더욱 짧은 코드로 변환 할 수있었다.

그래도 굳이 쓰는 이유를 곰곰히 생각해 보았더니.. 역시 핵심은 `역할의 분리` 인것 같았다.

엑티비티에서 물론 처리해도 되지만 엑티비티에서 모든 로직을 처리하게 된다면 나중에는 엄청난 스파게티코드와 덤으로 엄청난 유지보수까지 ㅎㅎ.. 겪게 될것이다. 따라서 각자의 역할과 기능을 가지는 모듈로 잘게 쪼개서 보다 가시성도 늘리고 MVVM, ViewModel, Data Binding 등을 이용해 클린코드를 만들려고 사용하는 느낌인것 같다. 




## result_

```
안녕하세요. 저는 일반적인 텍스트 입니다.


               ⬇️          


안녕하세요. 저는 일반적인 텍스트 입니다.

하지만 바인딩 어뎁터로 바뀌었습니다!
```
