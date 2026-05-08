INSERT INTO skills (title, description, category, content) VALUES
('React 컴포넌트 개발', '재사용 가능한 React 컴포넌트 설계 및 구현 스킬', 'REACT', 'React 함수형 컴포넌트, Hooks(useState, useEffect, useContext), Props 설계, 컴포넌트 합성 패턴, 커스텀 Hook 작성, 메모이제이션(React.memo, useMemo, useCallback) 등을 활용한 재사용 가능한 UI 컴포넌트 개발'),
('React 상태관리', 'Redux, Zustand 등을 활용한 전역 상태 관리', 'REACT', 'Redux Toolkit, Zustand, Recoil, Jotai 등 상태관리 라이브러리 활용. 전역 상태 설계, 비동기 상태 처리(RTK Query, React Query), 상태 정규화, 불변성 관리 등'),
('Spring Boot API 개발', 'RESTful API 설계 및 Spring Boot 기반 백엔드 구현', 'SPRING_BOOT', 'Spring Boot를 활용한 RESTful API 설계 및 구현. @RestController, @Service, @Repository 계층 구조, DTO 패턴, 예외 처리(@ControllerAdvice), Validation, Swagger 문서화 등'),
('Spring Security 인증/인가', 'JWT 기반 인증 및 역할 기반 접근 제어 구현', 'SPRING_BOOT', 'Spring Security를 활용한 JWT 토큰 기반 인증, OAuth2 로그인, 역할 기반 접근 제어(RBAC), SecurityFilterChain 설정, CORS 처리, 비밀번호 암호화(BCrypt) 등'),
('Spring Data JPA', 'JPA를 활용한 데이터 접근 계층 구현', 'SPRING_BOOT', 'Spring Data JPA, QueryDSL을 활용한 데이터 접근 계층 구현. 엔티티 매핑, 연관관계 설정, N+1 문제 해결, 페이징 처리, 동적 쿼리, Auditing 등'),
('MySQL 데이터베이스 설계', '관계형 데이터베이스 모델링 및 쿼리 최적화', 'DATA', 'MySQL 기반 관계형 데이터베이스 설계. 정규화, 인덱스 최적화, 실행 계획 분석(EXPLAIN), 트랜잭션 격리 수준, 슬로우 쿼리 튜닝, 파티셔닝 등'),
('Redis 캐싱 전략', 'Redis를 활용한 캐시 설계 및 성능 최적화', 'DATA', 'Redis를 활용한 캐싱 전략 수립. Cache-Aside, Write-Through, Write-Behind 패턴, TTL 설정, 캐시 무효화 전략, Redis Pub/Sub, 세션 저장소 활용 등'),
('Docker 컨테이너화', 'Docker를 이용한 애플리케이션 컨테이너화 및 배포', 'DEVOPS', 'Dockerfile 작성, 멀티 스테이지 빌드, Docker Compose를 활용한 멀티 컨테이너 환경 구성, 이미지 최적화, 볼륨 마운트, 네트워크 설정, Docker Hub 배포 등'),
('CI/CD 파이프라인 구축', 'GitHub Actions 기반 자동화 빌드/배포 파이프라인 설계', 'DEVOPS', 'GitHub Actions를 활용한 CI/CD 파이프라인 구축. 자동 빌드, 테스트, 배포 워크플로우 작성, 환경 변수 관리, Docker 이미지 빌드 자동화, AWS/GCP 배포 연동 등'),
('AWS 클라우드 인프라', 'AWS 서비스를 활용한 클라우드 인프라 설계 및 운영', 'DEVOPS', 'AWS EC2, RDS, S3, CloudFront, Route53, ELB, Auto Scaling 등을 활용한 클라우드 인프라 설계. VPC 네트워크 구성, IAM 권한 관리, CloudWatch 모니터링 등'),
('Python 데이터 분석', 'Pandas, NumPy를 활용한 데이터 분석 및 시각화', 'DATA', 'Python Pandas, NumPy를 활용한 데이터 전처리, 분석, 시각화. DataFrame 조작, 결측치 처리, 그룹 연산, Matplotlib/Seaborn 시각화, Jupyter Notebook 활용 등'),
('기술 문서 작성', 'API 문서, 아키텍처 설계서 등 기술 문서 작성', 'ETC', 'Swagger/OpenAPI 기반 API 문서 작성, 아키텍처 설계서(C4 모델), ERD 작성, README 작성, 기술 블로그 작성, Confluence/Notion 활용 등');
