## Room! 너 정체가 뭐야? 🧐

### 1.SQLite ➡️ Room

Room은 스마트폰 내장 DB에 데이터를 저장하기 위해 사용하는 라이브러리 입니다!
우리가 평소에 사용하는앱에도 Room이 적용되어 있는경우가 많은데 

 - 메모저장
 - 나만의 노래 리스트
 - 즐겨찾기 _ect..._

다음과 같은 일을 하기위해 과거에는 **SQLite** 라는 데이터 베이스를 이용하였으나
![](https://images.velog.io/images/yunsung_/post/22ee762a-1d2b-4e3a-b51e-f66e23061cb2/image.png)

다음과 같이... 사용하기 어렵다는 빨간줄이 막 그어져있다.(구글도 인정한 어려움 ㅠㅠ 🤬) 
그.래.서 나온것이 **Room** 친구라는것이다! 
- 구글도 SQLite 대신 Room을 사용할 것을 권장하고있다. 💁

하지만 그렇다고해서 Room이 완전히 달라진것은 아니고 
SQLite 이 친구를 활용하는 개념이다 라고만 보면된다. 

### 2.Room 너 어떻게 생겼어?

![](https://images.velog.io/images/yunsung_/post/618e61ad-ff08-4e3f-aa30-56019fdcc52d/image.png)

위 사진에서 

- Room Database
- Data Access Objects
- Entities 

이 세가지 부분이 Room의 구성요소이고 Rest of The App은 앱의 나머지 부분을 뜻합니다. 
```즉, (Room Database - DAO - Entities) ↔️ Rest of The App```
다음과 같이 세가지 요소와 서로 ```get,set!``` 과 같이 서로 주고받는다! 
정도로 이해하고 넘어가시면 됩니다.

Room 의 요소 하나하나는 조금이따가 설명해드릴 예정입니다!😎

## 그래서 사용은 어떻게해야하는건데? 📝


### 1.gradle 추가!

👉 JAVA 기준
```
    implementation 'androidx.room:room-runtime:2.2.6'
    annotationProcessor 'androidx.room:room-compiler:2.2.6'

```
👉 Kotiln 기준

```
// gradle맨 위쪽에 추가
     
    	 plugins {
    		id 'kotlin-kapt'
		}
     implementation 'androidx.room:room-runtime:2.2.6'
     kapt 'androidx.room:room-compiler:2.2.6'
```

### 2.Entity

![](https://images.velog.io/images/yunsung_/post/0481c641-0f2d-47b1-907d-eb19ceb4da30/image.png)

> 관련이 있는 속성들이 한곳에 모여 하나의 정보단위 를 이룬것을 말합니다!

위의 사진과 같이 Primary Key(해당 테이블의 이름)를 기준으로 
관련있는 사용자의 정보가 한곳에 모여있는것을 보시면 이해하기 쉽습니다.

```
// @Entity(tableName="userProfile") 와 같이 직접 해당 테이블의 이름을 지정한다.
// 놔두면 해당클래스 이름으로 테이블이름을 지정한다.

@Entity(tableName = "userinfo")
data class UserEntity (
    //기본키설정
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    //필드명 즉, 열의 이름을 다르게
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "email") val email : String
)
```

**이제 개념을 알았으니 위의 코드를 보며 공부해보자! 💁**

우선 Enitiy를 생성해야 한다.(데이터베이스 테이블을 만든다고 생각하자!)

data class에 @Entity *어노테이션을 붙어주고 저장하고싶은 속성의 
변수 이름과 타입을 지정해주자!

또한 primaryKey 라는 어노테이션도 보이는데, 이 어노테이션은 대표값 즉, 
각각의 유저가 가진 id 와 같이 중복되지 않는 값을 넣을 때 사용되는데
위의 어노테이션이 적용되면 해당 변수는 기본키가 된다.

```primaryKey는 유일한 키값이기 때문에 유일한 값이어야한다.본인이 직접 지정할 수 도있지만 autoGenerate = true으로 자동 생성 할 수도있다.```

> *어노테이션(annotation) : '@'가 붙은 데이터를 설명하는 데이터

<br>

### 3. DAO

> 데이터에 접근할 수 있는 메서드를 정의해놓은 인터페이스이다.


```
@Dao
interface UserDao {

    //Insert = 데이터베이스에서 값을 꺼내거나 값을 넣을때 인자값으로 끼워넣을 수 있다.

    @Insert
    fun insertUser(user : UserEntity?)

    @Delete
    fun deleteUser(user : UserEntity)

    @Update
    fun UpdateUser(user : UserEntity?)

}
```
즉, Entity를 어떻게 해줄건지 **결정하는 설명서**🧾 라고 보면될거같다.

Dao는 위와같이 이렇게 생성하면된다. (interface 라는점을 유의하면서보자) 

Entity와 같이 어노테이션을 지정하지만 이번에는 @Dao 어노테이션을 지정하고 그 안에 메소드를 지정해주는데

- @Insert를 붙이면 테이블에 데이터 삽입
- @Update를 붙이면 테이블의 데이터 수정
- @Delete를 붙이면 테이블의 데이터 삭제

라고 이해하면 될거같다.

그렇다면 위와같이 삽입/수정/삭제 이외의 다른 기능을 하는 메서드를 만들고싶다면 어떻게 해야할까??

```
    @Query("SELECT * FROM userinfo ORDER BY id DESC")
    fun getAllUserInfo() : List<UserEntity>
    ------------------------------------------------------
      @Query("SELECT * FROM User") 
      // 테이블의 모든 값을 가져와라
    fun getAll(): List<User>
    ------------------------------------------------------
    @Query("DELETE FROM User WHERE name = :name") 
    // 'name'에 해당하는 유저를 삭제해라
    fun deleteUserByName(name: String)
```

그렇다면 위와같이 @Query 어노테이션을 통해 선언하고 그 안에 어떤동작을 할건지 SQL 문법으로 작성을 해주어야한다.

### 4. Room DataBase

```
//entities에는 앞서 만들었던 엔티티를 넣어준다.

@Database(entities = [UserEntity::class],version = 1)
abstract class RoomAppDB : RoomDatabase()  {
```
> 말 그대로 데이터베이스를 생성해준다.

이번에는 데이터베이스를 생성하고 관리하는 데이터베이스 객체 만들기 위해서 위와 같은 추상 클래스를 만들어 줘야 한다. 우선 RoomDatabase 클래스를 상속받고, @Database 어노테이션으로 **데이터베이스임**을 표시한다.

또한 **version**은 앱을 업데이트하다가 entity의 구조를 변경해야 하는 일이 생겼을 때 이전 구조와 현재 구조를 구분해주는 역할을 한다.

```
@Database(entities = arrayOf(User::class, Student::class), version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}
```
만약 여러개의 Entitiy가 들어가는 경우라면 위와같이 arrayof 안에 ,로 구분해 넣어준다.

![](https://images.velog.io/images/yunsung_/post/895f02fe-76e5-48b5-bc8c-b8fece869c52/image.png)

[공식문서](https://developer.android.com/training/data-storage/room?hl=ko)에서는 데이터베이스 객체를 인스턴스 할 때 싱글톤으로 구현하기를 권장하고 있습니다!

**Why?**
일단 여러 인스턴스에 액세스를 꼭 해야 하는 일이 거의 없고, 객체 생성에 비용이 많이 들기 때문입니다.

> 이 부분에 대한 이해가 잘 안 된다면 다음 목차로 넘어가도 당장 문제가 생기거나 하진 않습니다. 어디까지나 "권장" 하는 부분이고, 알아 두어야 할 부분이라는 걸 고려만 해두고 넘어가도 무관합니다.


```
@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
 
    companion object {
        private var instance: UserDatabase? = null
 
        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if (instance == null) {
                synchronized(UserDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }
}
```

위와 같이 싱글톤을 사용하기 위해 companion object 로 객체를 선언해서 사용해주면 됩니다. 객체를 생성할 때 databaseBuilder라는 static 메서드를 사용하는데

- context
- database 클래스 
- 데이터 베이스를 저장할 때 

사용할 데이터베이스의 이름을 정해서 넘겨주면 됩니다.

```❗️주의```
```다른 데이터베이스랑 이름이 겹치면 꼬여버리니 주의하자!!```

### 5. 대망의 데이터베이스 사용👻

```
var newUser = User("김똥깨", "20", "010-1111-5555")

val db = UserDatabase.getInstance(applicationContext)
        db!!.userDao().insert(newUser)
```

> 다음 형식은 예시일뿐이다.

위와 같이 전에 만들어놓은 데이터베이스에 insert를 해주면 값이 들어가게된다.

```❗️주의!```
```Cannot access database on the main thread since it may potentially lock the UI for a long period of time 와 같은 오류가 생길것이다. 위와같은 오류는 다음과 같이 해결할 수 있는데```

```

1. 컴퓨터! 너 실행하라구 😤

-> allowMainThreadQueries()를 사용해 강제로 실행시킨다

-> 하.지.만 나중에 문제가 생길 수 있다. (공부하는 입장에서는 무관)

 

2. 컴퓨터님.. 어.. 실행 해주세요 뀨유~ 🙄

-> 비동기 실행을 하면 된다.

```
---
출처 : https://todaycode.tistory.com/39#recentComments
