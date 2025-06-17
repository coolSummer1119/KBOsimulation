# Spring Boot Practice Project

이 프로젝트는 Spring Boot를 사용한 웹 애플리케이션입니다.

## 기술 스택

- Java 17
- Spring Boot 3.2.3
- Spring Security
- Spring Data JPA
- PostgreSQL
- H2 Database (개발 환경)
- Selenium
- JSP & JSTL

## 시작하기

### 필수 조건

- Java 17 이상
- Gradle
- PostgreSQL (프로덕션 환경)

### 설치 및 실행

1. 프로젝트 클론
```bash
git clone [repository-url]
```

2. 의존성 설치
```bash
./gradlew build
```

3. 애플리케이션 실행
```bash
./gradlew bootRun
```

## 환경 설정

- 개발 환경: `application-dev.yml`
- 프로덕션 환경: `application-prod.yml`

## 주요 기능

- 사용자 인증 및 권한 관리
- 데이터베이스 연동
- 웹 크롤링
- RESTful API

## API 문서

API 문서는 Swagger UI를 통해 확인할 수 있습니다:
```
http://localhost:8080/swagger-ui.html
```

## 모니터링

Actuator 엔드포인트를 통해 애플리케이션 상태를 모니터링할 수 있습니다:
```
http://localhost:8080/actuator
```

## 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다. 