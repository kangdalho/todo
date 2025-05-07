 # 📌Todo Application

**Spring Boot** 기반의 일정 관리 **API 애플리케이션**입니다.

**일정(Schedule)** 작성 및 조회 기능과, 이에 대한 **댓글(Comment)** 및 **대댓글(Reply)** 기능을 제공합니다.


## 🚀 주요 기능
- **일정** : 생성, 수정, 삭제, 단건/전체 조회
- **댓글** : 특정 일정에 댓글 작성, 댓글 수정 및 삭제, 단건/전체 조회
- **대댓글** : 특정 댓글에 대댓글 작성, 댓글 조회시 대댓글 같이 조회

## 🛠️ 기술 스택
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Lombok

## 🗂️ 프로젝트 구조
````
com.example.todo
├── controller       // API 요청 처리
├── dto              // 요청/응답 DTO
│   ├── request
│   └── response
├── entity           // JPA 엔티티
├── repository       // 데이터 접근 레이어
├── service          // 비즈니스 로직
└── TodoApplication  
````

## API 명세서
📌 https://www.notion.so/teamsparta/API-1ec2dc3ef5148060acbbe6fa541489de

## ERD
📌 https://www.erdcloud.com/d/YLhoW5FwcRDtgPyLf