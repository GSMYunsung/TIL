## EditText_사용법

  

> Text를 입력 및 수정까지 가능한 뷰(View) 위젯이다.

​	
  
#### 1.EditText 기본 사용법
  
> [사용방법]
>
> 레이아웃 리소스 XML에서 `<EditText> </EditText>` 사이에 EditText의 속성을 정의

```xml
<EditText
	android:id="@+id/sample_EditText"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:layout_weight="1"
	android:ems="10" // 일정한 글자 간격
	android:inputType="textPersonName" // 초기 EditText창에 들어갈 Text
	android:text="Sample EditText" />
```
  
![img](https://cdn.discordapp.com/attachments/804184517644386345/824235156357251163/unknown.png)

▶EditText를 클릭했을때 Text 입력기가 실행됨

​	* 기존에 기본값인 Sample EditText은 사라지지않고 유지된 상태에서 입력됨	

​		
  
#### 2.EditText 입력 및 수정 방지

>만일 부모 클래스로부터 enabled속성을 부여 받았다면, EditText에 텍스트를 입력 및 수정이 불가능한 상태가 된다.

![img](https://cdn.discordapp.com/attachments/804184517644386345/824237034792419350/unknown.png)

▶ enabled = "true"일 경우 : 텍스트 입력 및 수정 가능

▶ enabled = "false"일 경우 : 텍스트 입력 및 수정 불가능

​		

#### 3.EditText속성 -  hint / textColorHint
  
> **hint** : EditText배경에 속성값으로 지정한 문자열을 나타나게 한다.
>
> **textColorHint** : hint 속성에 의해 지정된 문자열의 색을 지정한다.
  
```xml
        <EditText
            android:id="@+id/Sample1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:ems="10"
            android:hint="이메일을 입력하세요."
            android:inputType="textPersonName"
            android:textColorHint="@color/colorAccent"/>
```
  
![img](https://cdn.discordapp.com/attachments/804184517644386345/824243517052289034/unknown.png)

▶EditText를 클릭했을때 Text 입력기가 실행됨

 * 기존에 기본값인 Sample EditText이 기존의 EditText과 다르게 사라지고, 텍스트가 입력됨.

   ​	

#### 4. EditText 속성 - selectAllOnFocus / textColorHighlight
  
> **selectAllOnFocus** : EditText를 클릭하였을 때 텍스트 영역을 전체 선택된 상태를 만들고자 할 때 사용한다.
>
> **textColorHighlight** : EditText에서 Text에 해당하는 사각형 영역을 표현할 때 사용한다.
  
```xml
        <EditText
            android:id="@+id/Sample1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:ems="10"
            android:inputType="textPersonName"
            android:selectAllOnFocus="true"
            android:text="Sample"
            android:textColorHighlight="@color/colorPrimary" />
```

![img](https://cdn.discordapp.com/attachments/804184517644386345/824245846404104232/unknown.png)

▶	selectAllOnFocus = "true"로 지정 하였기 때문에 "Sample" 전체 텍스트 영역이 선택됨

​		텍스트 입력시, 모두 지워지고 새로운 text로 채워짐.
  
  
  
#### 5. EditText 속성 - maxLength
  
> EditText에 입력 가능한 텍스트의 수를 지정할 수 있습니다.
  
```xml
           <EditText
                android:id="@+id/editText"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:ems="10"
                android:inputType="textPersonName"
                android:maxLength="5"
                android:text="Name" />
```

