# 교육 설명
[교육과정 보기](https://edu.nextstep.camp/c/lqsBs7x0/)
* NextStep & 우아한 형제들 주관
* 일반 사용자용 서비스를 개발할 때 필요한 역량 습득
* 리뷰어의 코드 리뷰를 통해 책임 주도 설계를 기반으로 유연한 구조의 클린 코드를 작성

## 배운 점

### 미션 주요 내용
JPA 프레임워크를 사용해 OOP 패러다임으로 기능 구현
* JPA
  * ORM(Object Relation Mapping) 패러다임을 위하여 관계형 DB를 관리해주는 자바 API (명세)
    * 대표적인 구현체로 Hibernate가 있음
  * 관계형 DB와 객체 지향 프로그래밍 간 패러다임 간극을 줄여주는 도구
  * 엔티티 매니저가 영속성 컨텍스트를 관리
  * 연관 관계 매핑 지원
    * 일대일, 일대다 등 관계와 단방향, 양방향 등 방향 지원

### Step 1
**[Step1 피드백 보기](https://github.com/next-step/jwp-jpa/pull/24)**

**주요 피드백 내용**
* 각 `Entity`의 `Id`는 생성 전략이 다를 수 있어 `BaseEntity`에 구현하지 않고 각 `Entity`에 구현할 것
* JPA에서는 `Entity`마다 기본 생성자가 있어야 함 (일반적으로 `protected`로 선언)
* `Repository`에서 단건 조회 시 반환 형태를 통일할 것
  * 팀에 따라 `Optional<>` 형태로 반환할 수도 있음
* 도메인 설계에 따라 래퍼 클래스보다 원시 타입을 사용하는 것이 효율적인 경우도 있음
* OOP에서 `getter`, `setter`를 가급적 지양할 것

### Step 2
**[Step2 피드백 보기](https://github.com/next-step/jwp-jpa/pull/48)**

**주요 피드백 내용**
* 클래스 내 `getter`는 되도록 다른 주요 메서드 하단에 배치할 것
* `color`와 같은 속성은 문자열이 아닌 `Enum`을 사용하면 더 안정적
* 매개 변수가 `null`일 때 체크 로직 필요

### Step 3
[Step3 피드백 보기](https://github.com/next-step/jwp-jpa/pull/52)

**주요 피드백 내용**
* `null`을 체크하는 로직이 계속 추가되는 경우 널 오브젝트 패턴 사용을 고려해 볼 것

### Step 4
[Step4 피드백 보기](https://github.com/next-step/jwp-jpa/pull/60)

**주요 피드백 내용**
* 상황에 따라 해당 객체에서 `null` 인스턴스를 생성하는 구조도 고려해 볼 것
  * `null` 인스턴스 생성 시 팩터리 메서드 활용도 고려해 볼 것

---

# jpa

## H2 설정
* H2 사용시 MySQL Dialect 사용 설정
  * application.yaml(yml) 파일 설정
    * spring:
      * datasource:
        * hikari:
          * jdbc-url: jdbc:h2:tcp://localhost/~/test;MODE=MYSQL
    * properties:
      * hibernate:
        * dialect: org.hibernate.dialect.MySQL57Dialect
* 테스트 시 H2 사용할 때 test/resources 경로에 application 설정을 하지 않는 경우 아래 어노테이션 추가
  * 테스트 클래스에 @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
