# practiceAboutDiAndIoc


# 리플렉션을 통한 스프링 IOC 컨테이너 구현 입니다.
![image](https://user-images.githubusercontent.com/108961843/226404299-584db612-b804-45de-a8bf-fdac390d4c23.png)
<br>

## 1.  기존의 스프링 IOC 

![image](https://user-images.githubusercontent.com/108961843/226404257-4e9e5cc7-84d5-4668-ba7c-97db30c9b231.png)
### 기본적인 서비스로직은 유저를 저장하고 이를 조회하는 구조이며, 인터페이스를 구체화한 구현체들은 인터페이스에 의존하는 구조입니다.
<br>

![image](https://user-images.githubusercontent.com/108961843/226404315-9e40725d-d230-440e-a6b9-15592fb441b2.png)
### 먼저, 스프링 컨테이너에서 구현하는 방식은 다음과 같습니다. 구체클래스에 @Compenet 어노테이션이 있게 되면 이는 빈 컨테이너에 등록하겠다고 의미하는 것입니다. 실행시점에서는 ComponentScan을 통해 해당 빈을 스캔하여 아래 그림과 같이 빈에 등록이 되게 됩니다.
<br>

![image](https://user-images.githubusercontent.com/108961843/226404329-fff14358-d4b0-4593-820b-c6f2a44bd935.png)
### ServieImpl을 상세히 본다면 생성자 호출을 통해 구체클래스가 생성될  때, 의존관계를 주입받게 됩니다.
<br>

![image](https://user-images.githubusercontent.com/108961843/226404342-fa6b8fda-40c1-4552-b3a8-cfc9c84e2e9f.png)
### 멤버를 등록 하고 이를 찾는 과정을 테스트를 진행한 결과 정상적으로 주입이 잘 된 것을 확인할  수 있었습니다. 
<br>

## 2. CLASS 이름으로 구현
![image](https://user-images.githubusercontent.com/108961843/226404363-a04862dd-7eaa-42bd-9d6e-35ab7afba81d.png)
### 다음으로, 클래스 이름을 통해 구현에 대해 말씀드리겠습니다. 구현과정에서  리플렉션을 평소에 사용하지 않았기 때문에 해당 부분에 대한 학습이 필요하였으며, DI Container와 같이  실행이후 클래스에 대한 빈 등록 및 주입을 하기 위해선 위와 같은 이유로 리플렉션을 사용해야합니다. 
<br>

![image](https://user-images.githubusercontent.com/108961843/226404372-b5ca9898-23ef-416c-9c73-e5d4dbf7edd9.png)
### 빈 객체를 담을 컨테이너 구성은 다음과 같습니다. 먼저 리플렉션 Class 타입의 셋구조로 구성되며,  인스턴스 객체를 생성합니다. 
<br>

![image](https://user-images.githubusercontent.com/108961843/226404386-d4e64688-2d88-497d-ae0a-6444df3f178c.png)
### 세부로직은 클래스 이름에  따른 구체 및 의존관계를 주입합니다. 이를 통해 * DIContainer가 객체를 생성하고 관계를 설정하게 됩니다. 
### 제어의 역전이라는 개념이 적용되면 객체는 자신이 사용할 객체를 선택하고 생성하지 않는다. UserService는 DIContainer에게 모든 제어 권한을 위임한 상태다.
<br>

 ![image](https://user-images.githubusercontent.com/108961843/226404398-ac44d9e1-c084-45b5-8d6b-d745199ac992.png)
 ### 테스트 실행전 DIC 컨테이너에 넣을 클래스타입을 지정, 실행시 빈으로 등록될 클래스 타입을 지정하여 생성자를 통해 객체를 생성합니다. 
<br>

![image](https://user-images.githubusercontent.com/108961843/226404424-d446ecc5-2a31-4eb9-9ff7-88bf860b0b72.png)
### 컨테이너에서 UserService클래스를 찾은 후 로직 실행 결과 등록 및 주입이 잘 된 것을 확인 할 수 있었습니다. 
<br>

![image](https://user-images.githubusercontent.com/108961843/226404450-e342d050-2b9b-489a-aade-4b0488b8e7d5.png)
### 다만 위와 같이 잘못 클래스 이름을 입력하더라도 발견이 어렵고, 등록할 클래스 타입 및 의존관계를 DIC컨테이너에 일일히 작성하는것도 하드코딩적인 부분이 크기 때문에 개선이 필요한 부분입니다.
<br>

## 3. 어노테이션을 통한 구현

![image](https://user-images.githubusercontent.com/108961843/226404463-95c3b86e-e255-4069-b508-881e41fb4c80.png)
### 그래서 어노테이션을 통한 구현순서는 다음과 같습니다. 
1. 리플렉션을 통해 클래스, 메서드, 필드 정보들을 들고온다.
2. 리플렉션 getDeclaredAnnotaitions을 통해 원하는 어노테이션이 붙었는지 확인.
3. 어노테이션이 붙은 클래스에 대해 로직수행
그래서 아래와 같은 어노테이션을 만들고 작동시점 및 작동 타입에 대한 설정을 합니다.
<br>

![image](https://user-images.githubusercontent.com/108961843/226404505-6289b9a2-80e4-4264-82d5-6363dbf97963.png)
### @Componet, @Autowired 어노테이션을 찾을 어노테이션스캔 클래스를 만듭니다.
<br>

![image](https://user-images.githubusercontent.com/108961843/226404511-fb1e4dd6-45d2-4ebe-af85-affc5ec7d320.png)
### 이를 특정 패키지들을 스캔하여 어노테이션이 붙은 클래스를 담아 생성자를 통해  DIC 컨테이너 생성을 합니다. 
<br>

![image](https://user-images.githubusercontent.com/108961843/226404539-af53d78c-1255-4091-9007-fb8d42007082.png)
### 각각 특정타입의 클래스를  생성자를 통해  private에 대한 접근을 풀고,  인스턴스화 시키고 빈을 돌려줍니다. 
### 인스턴스 생성과 함께 필드들에 대한 초기화를 진행합니다
<br>

![image](https://user-images.githubusercontent.com/108961843/226404546-f150a4df-6405-4362-9333-cf2d75c43572.png)
### 필드 순회를 진행
<br>

![image](https://user-images.githubusercontent.com/108961843/226404561-18428622-6758-44e1-958e-94c5c7a1dc08.png)
### @Autowried라는 어노테이션이 붙은 필드를 해당 빈에 주입을 합니다.  빈들 중에서 할당 가능한 빈이 있을 경우 해당 빈을 등록..그래서 UserServiceImpl의 빈에 해당 타입의 UserRepository 클래스가 주입 받게 됩니다. 
<br>

![image](https://user-images.githubusercontent.com/108961843/226404570-b34323a9-55bd-4e34-b362-0635ba21e9c1.png)
### 이전 테스트와 같이 컨테이너를 생성하고 여기서 빈 객체를 꺼내서 테스트를 수행합니다. 해당 패키지의 경로 지정을  하고 경로 하위에 있는 모든 클래스들을 스캔합니다. 
<br>

![image](https://user-images.githubusercontent.com/108961843/226404584-2aec9f64-e0dc-49ac-9d22-d71a2f7eb598.png)
### 로직 실행 결과 등록 및 주입이 잘 된 것을 확인 할 수 있었습니다. 
<br>


###
<br>
