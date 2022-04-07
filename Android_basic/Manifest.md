## ❗ 개념 바로잡기

앱에대한 필수적인 정보를 안드로이드 빌드 툴과 Android OS, 그리고 구글플레이에 제공하는 
필수파일 입니다.

- 메니페스트 파일의 필수 선언 요소
    
    
    - 앱의 패키지 이름 📛
    - 앱에서 사용되는 컴포넌트 (액티비티, 서비스, 브로드캐스트 리시버, 컨텐트 프로바이더) 👨‍👩‍👧‍👦
    - 권한(Permission) ⚙️
    - 앱에서 요구하는 하드웨어와 소프트웨어 특징 👀
    

## ✅ Package name and Application ID

매니페스트 파일의 Root element(<manifest></manifest>) 에는 해당 앱의 패키지 네임이 반드시 기재되어야 합니다.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.ready.example"
    android:versionCode="1"
    android:versionName="1.0" >
    ...
</manifest>

//com.ready.example 이라는 패키지이름의 manifest 파일 생성
```

- 해당 manifast 파일은 앱을 APK로 추출하는 과정에서 Android Build Tool 에 의해 쓰임
    
    
    - App Resource 에 접근하는데 사용되는 R 클래스의 네임스페이스로 적용됩니다.
        
        ex) com.ready.example.R
        
    
    - 매니페스트 파일 내에서 선언된 상대경로에 적용됩니다.
        
        ex)  <activity android:name=".MainActivity>  ➡️  com.ready.example.MainActivity"
        

만약 sub-package 를 가지고 있다 하더라도 R 클래스는 sub-package 의 경로가 아닌 

매니페스트 내 package 속성에 따라 생성

하지만 `package` 속성이 불변인것은 아님. apk를 추출할때 package 속성의 값을 `build.gradle` 에 선언된 

`applicationId` 로 바꾸어 버립니다.  → 플레이스토어에 등록된 각 앱을 구분하기위해

<aside>
⛔ Manifest 파일에 선언된 package 이름과 build.gradle 에 선언된 applicationId 값이 같다면 문제가 없지만, 다를 경우에는 상황에 따라 충돌이 발생할 수 있습니다.

또한, 메니페스트의 package 속성으로 선언된 패키지 경로는 프로젝트의 base package name과 매칭되어야 합니다.

</aside>

## ✅ App Components

안드로이드에는 4대 컴포넌트(Activity, Service, Broadcast Receiver, Content Provider)라 불리는 녀석들이 있습니다. 이 컴포넌트들을 앱에서 사용한다면 매니페스트 파일에 등록해줘야 합니다.

Manifest 파일 내에서 각각 다음 태그를 통해 선언할 수 있습니다.

```xml
- <activity> : Activity
- <service> : Service
- <receiver> : Broadcast Receiver
- <provider> : Content Provider
```

만약 컴포넌트의 서브 클래스를 구현하여 사용하면서 매니페스트 파일에 선언해주지 않는다면, 시스템은 해당 컴포넌트에 대해 실행할 수 없습니다.

4대 컴포넌트들은 각각 인텐트에 의해 활성화됩니다. 여기서 `인텐트`란 메세지 객체로, 어떤 행동을 수행할지에 대한 명령이나 작업에 필요한 데이터를 포함합니다. 

앱이 `인텐트`를 시스템에 발행하면 시스템은 각 앱의 매니페스트에 선언된 `intent-filter` 에 기초하여 처리할 수 있는 `인텐트`를 찾게 됩니다. 만약 여러 개의 앱이 인텐트를 다룰 수 있다면, 사용자가 해당 인텐트를 어떤 앱에게 넘길지 선택할 수 있습니다.

## ✅ Permissions

매니페스트하면 빠지면 안되는것! ➡️  권한 설정

이 권한이라는 것은 안드로이드 진영에서 민감하게 다루고 있는 관심사 중 하나입니다. 

안드로이드 앱은 민감한 유저 정보나 카메라나 인터넷 등 특정 시스템 기능을 사용할 때 

해당권한을 사용하기위해선 반드시 권한을 요청해야합니다.

ex) camera 권한 설정 

```xml
<manifest ... >

<uses-permission android:name="android.permission.CAMERA"/>

</manifest>
```

Android 6.0 버전(API Level 23) 부터는 몇몇 권한에 대해서 사용자에게 동적으로 요청하여 승인이나 거절을 받아야합니다.

## ✅ Device Compatibility

Manifest 파일에는 앱이 필요로 하는 하드웨어나 소프트웨어 특징을 명시할 수 있습니다. 예를들어 자신이 카메라 앱을 만든다고 가정을 했을때 카매라가 필수로 있어야하니 카메라가 있는 기기에서만 Play Store 에서 해당 앱이 다운로드 될 수 있도록 명시하는 것입니다.

ex) 나침판이 있나요? **🧭**

```xml
<manifest ... >
    <uses-feature android:name="android.hardware.sensor.compass"
                  android:required="true" />
    ...
</manifest>
```

## 번외

매니페스트에 선언된 컴포넌트들과 <application> 은 유저에게 보여줄 수 있는 `icon` 과 `label` 속성을 갖고 있습니다.  xml 로 구성하다보면 트리 구조기 때문에 부모-자식 관계가 생김.

이때 자식 element에 `icon` 과 `label` 이 설정되어있지 않다면 부모에 설정된 값이 기본 값으로 설정되게 됩니다. 그렇기 때문에 각 컴포넌트마다 설정하지 않고 앱 전체에 기본 값을 설정하려면 `<application>` 에 설정하면 됩니다.
