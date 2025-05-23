# CoordiCore 과제 프로젝트

브랜드별/카테고리별 상품 정보를 관리하고, 다양한 조건으로 최저가 정보를 조회하는 쇼핑 코디 지원 백엔드 서비스입니다.

---

## ✅ 기술 스택

| 항목       | 내용                                      |
|------------|-------------------------------------------|
| Language   | Kotlin 1.9.x                              |
| Framework  | Spring Boot 3.4.5                         |
| ORM        | Spring Data JPA + Hibernate               |
| DB         | H2 In-Memory (MySQL 호환 모드)            |
| 문서화     | SpringDoc OpenAPI (Swagger UI)            |
| 테스트     | SpringBootTest + MockMvc                  |
| 빌드 도구  | Gradle (Kotlin DSL)                       |

---

## ✅ 사용 방법

✅ Swagger 주소
* Swagger UI:
  * http://localhost:8080/api/swagger/index.html

✅ H2 Console
- URL: [http://localhost:8080/api/h2-console?jdbcUrl=jdbc:h2:mem:testdb&user=sa](http://localhost:8080/api/h2-console?jdbcUrl=jdbc:h2:mem:testdb&user=sa)


✅ API 문서 요약

📦 Brand 관리 API /brand

|메서드|URL|설명|
|--|--|--|
|POST|	/brand|	브랜드 추가|
|PUT|	/brand|	브랜드 수정|
|DELETE|	/brand/{id}|	브랜드 삭제|

📦 Product 조회 API /products

|메서드|URL|설명|
|--|--|--|
|GET|	/products/categoryWiseCheapBrands	|카테고리별 최저가 브랜드 조회 (전체 카테고리)|
|GET|	/products/cheapestTotalByBrand	|단일 브랜드 기준 최저 총액 조회|
|GET|	/products/minMaxPriceByCategory	|특정 카테고리 기준 최저가/최고가 브랜드 조회|

📦 Product 관리 API /products

|메서드|URL| 설명     |
|--|--|--------|
|POST|	/products| 	상품 추가 |
|PUT|	/products	| 상품 수정  |
|DELETE|	/products/{id}| 	상품 삭제 |


⸻

✅ 패키지 구조

```
├── main
│   ├── kotlin
│   │   └── com
│   │       └── coordi
│   │           └── core
│   │               ├── CoordiCoreApplication.kt
│   │               ├── brand
│   │               │   ├── controller
│   │               │   │   └── BrandWriteController.kt
│   │               │   ├── domain
│   │               │   │   └── Brand.kt
│   │               │   ├── dto
│   │               │   │   └── request
│   │               │   │       ├── AddBrandRequest.kt
│   │               │   │       └── UpdateBrandRequest.kt
│   │               │   ├── repository
│   │               │   │   └── BrandRepository.kt
│   │               │   └── service
│   │               │       ├── BrandWriteService.kt
│   │               │       └── impl
│   │               │           └── BrandWriteServiceImpl.kt
│   │               ├── global
│   │               │   ├── config
│   │               │   │   ├── JpaConfig.kt
│   │               │   │   └── QueryDSLConfig.kt
│   │               │   ├── costants
│   │               │   │   └── Category.kt
│   │               │   └── response
│   │               │       ├── CommonRes.kt
│   │               │       └── ResponseMsg.kt
│   │               └── product
│   │                   ├── controller
│   │                   │   ├── ProductReadController.kt
│   │                   │   └── ProductWriteController.kt
│   │                   ├── domain
│   │                   │   └── Product.kt
│   │                   ├── dto
│   │                   │   ├── BrandCategoryPriceDto.kt
│   │                   │   ├── BrandPriceDto.kt
│   │                   │   ├── CheapPriceByBrandDto.kt
│   │                   │   ├── request
│   │                   │   │   ├── AddProductRequest.kt
│   │                   │   │   └── UpdateProductRequest.kt
│   │                   │   └── response
│   │                   │       └── CategoryMinMaxResponse.kt
│   │                   ├── repository
│   │                   │   ├── ProductWriteRepository.kt
│   │                   │   └── impl
│   │                   │       └── ProductReadRepositoryImpl.kt
│   │                   └── service
│   │                       ├── ProductReadService.kt
│   │                       ├── ProductWriteService.kt
│   │                       └── impl
│   │                           ├── ProductReadServiceImpl.kt
│   │                           └── ProductWriteServiceImpl.kt
│   └── resources
│       ├── application.yml
│       └── data.sql
└── test
    └── kotlin
        └── com
            └── coordi
                └── core
                    ├── CoordiCoreApplicationTests.kt
                    ├── brand
                    │   └── controller
                    │       └── BrandWriteControllerTest.kt
                    ├── product
                    │   └── controller
                    │       ├── ProductReadControllerTest.kt
                    │       └── ProductWriteControllerTest.kt
                    └── util
                        └── ConverterUtil.kt

```

⸻

✅ 테스트 방법

MockMvc 기반 단위 테스트 작성 완료.

./gradlew test

테스트 커버 범위
* 브랜드 추가 / 수정 / 삭제
* 상품 추가 / 수정 / 삭제
* 카테고리별 최저가 브랜드 조회
* 단일 브랜드 기준 최저 총액 조회
* 카테고리 기준 최저가/최고가 브랜드 조회

⸻

✅ 샘플 데이터

앱 실행 시 data.sql에 의해 H2 DB에 초기 데이터 삽입됩니다.
* 브랜드 A ~ I
* 각 브랜드당 8개 카테고리의 상품
* 카테고리: TOP, OUTER, PANTS, SNEAKERS, BAG, HAT, SOCKS, ACCESSORY

⸻

✅ 기타 참고 사항
* 테스트 DB: H2 In-Memory (MODE=MYSQL)
* 테이블은 JPA로 자동 생성됨 (ddl-auto: create)
* 로그: Hibernate SQL 및 바인딩 값 출력 (format_sql, sql: debug, type.descriptor.sql: trace)
