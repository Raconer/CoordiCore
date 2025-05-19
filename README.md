# CoordiCore

**CoordiCore** – 코디(Coordinate) + Core (백엔드의 핵심 로직)  
Spring Boot + Kotlin 기반의 백엔드 서비스입니다.

## 문서

### H2 Console

- URL: [http://localhost:8080/api/h2-console?jdbcUrl=jdbc:h2:mem:testdb&user=sa](http://localhost:8080/api/h2-console?jdbcUrl=jdbc:h2:mem:testdb&user=sa)

### API

- Swagger UI를 통해 자동 생성된 API 문서를 제공합니다.  
  (예: `/swagger-ui.html` 또는 `/v3/api-docs`)

## Spec

| 기술 스택                        | 설명                                |
|----------------------------------|-------------------------------------|
| Spring Boot 3.4.5                | 애플리케이션 프레임워크             |
| Kotlin 1.9.25                    | JVM 기반 프로그래밍 언어            |
| JPA + QueryDSL 5.1.0 (Jakarta)  | 타입 안전한 쿼리 DSL 및 ORM         |
| H2 In-Memory Database           | 테스트용 메모리 데이터베이스        |
| Swagger UI (SpringDoc)          | API 문서 자동 생성 도구             |
| Actuator (헬스체크)              | 시스템 상태 모니터링용 엔드포인트    |