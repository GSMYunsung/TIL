### @Inject constructor

클래스의 생성자에서 @Inject 어노테이션을 사용하여 의존성을 생성하는 방법이다!

———————————————

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
   ...
}

———————————————

### Hilt 모듈

@Module 어노테이션이 지정된 클래스 

의존성 인스턴스를 제공하는 방법을 Hilt에 알려주는 역할

———————————————

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
   ...
}

———————————————

