# 학생 & 출석 관리 프로그램
JSL 개인 프로젝트

### 개발 기간
2017.12. ~ 2019.12 (1개월)

### 팀 구성 및 담당
1명

### 주요 언어
- Java
- MySQL / Windows

### 주요 기능
#### 1. 학생 관리
* 기본적인 등록 / 검색 / 수정 / 삭제를 구현
* HashMap이용

| 번호 | 이름 | 주민번호 | 성별 | 일본어반 | IT반 | 전화번호 | 기수 | 
|:--------:|:-------:|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:|
| INT(PRIMARY KEY) | VARCHAR(20) | VARCHAR(20)| CHAR(2) | VARCHAR(10) | VARCHAR(10) | VARCHAR(20) | CHAR(5) |

![image](https://user-images.githubusercontent.com/67365433/87517148-74db4d00-c6b9-11ea-9392-8b04806b383e.png)

#### 2. 출석 관리

* 각 기수 별로 일본어와 IT 테이블을 학생 테이블과 조인을 통해 출력
* 기수 별 출력 위해 일본어와 IT, 학생 테이블을 모두 조인하여 출석 확인을 출력

* 26기 일본어반 / 26기 IT반 / 27기 일본어반 / 27기 IT반

| 날짜 | 번호 | 출석여부 | 
|:--------:|:-------:|:--------:|
| DATE | INT | VARCHAR(10)|

![image](https://user-images.githubusercontent.com/67365433/87517212-845a9600-c6b9-11ea-84f0-fabfd8747751.png)

### 보완점
- 테이블 요소에 JComboBox를 삽입햇지만 맨 처음 값만 받는 오류가 있음.
