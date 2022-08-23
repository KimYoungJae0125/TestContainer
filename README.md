# 테스트 컨테이너

## 가상 테스트 컨테이너를 만들어주는 프레임워크
### ⭐️ 테스트 실행 전 도커 실행은 필수

## Dependencies
### 테스트 컨테이너
### 기본
```shell
testImplementation "org.testcontainers:testcontainers:1.17.3"
```
### Junit
```shell
testImplementation "org.testcontainers:junit-jupiter:1.15.3"
```
### MySQL
```shell
testImplementation "org.testcontainers:mysql:1.17.3"
```

### MariaDB
```shell
testImplementation "org.testcontainers:mariadb:1.17.3"
```

### Reference
#### 공식문서
https://www.testcontainers.org/