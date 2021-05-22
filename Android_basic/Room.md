**데이터를 매핑해주는 orm 라이브러리 Room


[ORM]

객체지향 프로그래밍 -> 클래스
관계형 데이터베이스 -> 테이블

객체모델 -X- 관계형모델 (두개모델의 불일치가 발생한다)

ORM으로 SQL을 자동으로 생성하여 테이블 생성!

[SQLite vs ROOM]

1. SQLite는 쿼리에 대한 에러를 컴파일 타임에 확인불가
2. SQLite는 Schema가 변경이 될경우 SQL 쿼리를 수동으로 업데이트
3. SQLite는 Java 데이터 객체를 변경하기위해 많은 boilerplate code를 작성해야함 즉, 많고 반복되는 코드를 계속 작성해야함
4. LiveData 와 RxJava를 위한 Observation으로 생성하여 동작 불가	

Room은 모두 된다.

하지만, SQL라이트의 단점들을 Room은 모두 극복했다고 볼 수 있다.

[Room 구성요소]

Database, Entity, Dao 세가지 구성요소

[Database]
데이터베이스의 holder를 구성, 지속적인 관계형 데이터의 기본연결을 위한 중간연결지점!

“@Database” 로 지정된 클래스의 제약

- RoomDatabase를 extends 하는 abstract class 여야한다.
- Annotation 내에 entities 를 포함해야 한다.
       즉, @Database 안에 entities포함!
   - 클래스 내부에 인수가 0개인 @Dao가 지정된 클래스를 반환하는 abstract 추상클래스를 포함한다.

