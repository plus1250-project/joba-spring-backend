# :loudspeaker: 트렌드를 JOBA

## :radio: 프로젝트 주제
뉴스 기사 데이터를 활용한 산업 트렌드 분석 및 시각화 서비스

## :floppy_disk: 프로젝트 배경 
2030의 가장 큰 관심사인 취업은 목표하는 산업의 트렌드 및 기업 정보를 습득하는 것이 중요하다. 빅데이터를 통해 산업군의 실시간 트렌드와 산업군별 기업들의 성장 정보들을 모아 제공하여 취업을 희망하는 사람들에게 도움이 될 수 있는 플랫폼을 기획하였다. 따라서 실시간으로 변화하는 데이터에 적합한 플랫폼을 제작하기 위해서 데이터 파이프라인 구축 및 자동화와 웹 개발이 필요하다고 판단하였다.

## :minidisc: 프로젝트 목적
1. 빅데이터 축적을 위한 데이터 파이프라인 구축 및 자동화 솔루션 구축
2. 실제 현업에서 적용할 만한 수준의 웹 어플리케이션 개발 기술 습득
3. 애자일 방식의 프로젝트 관리 및 실행 경험

## :hourglass: 프로젝트 기간
`2022년 5월 23일 ~ 2022년 7월 24일`

## :high_brightness: 팀 소개

**팀명: +125°** &#x1F321;&#xFE0F;   
**팀장: 김영애**  
:cyclone: 김영애 : 데이터 ETL, 데이터 파이프라인 설계 및 구축  
 :runner: 이동빈 :  데이터 ETL, AI  
&#x1F9A6; 양지현 :  데이터 ETL , 프론트엔드  
:ocean: 김종원 :  백엔드 , 프론트엔드 ,docker 구축  
:hamster: 오다솔 :  백엔드, docker 구축  

 
## :movie_camera: 기능 소개

[![유튜브화면](https://user-images.githubusercontent.com/97429679/180661184-3a780e84-5641-4118-807c-9fd5d023d267.PNG)](https://youtu.be/6BCoMDTAVqs)

![image](https://user-images.githubusercontent.com/97663140/180639315-e8f00d35-d429-495d-8456-4dea82bee7a1.png)

<p float=left>
<img src = "https://user-images.githubusercontent.com/97663140/180639326-ec6096b5-c7b3-4111-97d6-94ac4c923af3.png" width="49.6%" height="50%">
<img src = "https://user-images.githubusercontent.com/97663140/180639332-63aa98ea-00e4-4c62-b220-6a4f0372dedf.png" width="49.6%" height="50%">
</p>
<p float=left>
<img src = "https://user-images.githubusercontent.com/97663140/180639340-1b1f22df-b8dc-4088-b35c-89a08b21d332.png" width="49.6%" height="50%">
<img src = "https://user-images.githubusercontent.com/97663140/180639359-e9808afe-6a67-4a17-8c1b-1a3230d18d57.png" width="49.6%" height="50%">
</p>

<p float=left>
<img src = "https://user-images.githubusercontent.com/97663140/180639348-c41a65b2-fd27-4367-a1e4-0639bef93f6a.png" width="49.6%" height="50%">
<img src = "https://user-images.githubusercontent.com/97663140/180639353-a4ce9d09-e268-413d-b039-9ea6b100a8be.png" width="49.6%" height="50%">
</p>



## :wrench: 기술 스택
### 인프라 구축
<img src="https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white"> <img src="https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/RedHat-EE0000?style=for-the-badge&logo=redhat&logoColor=white"> <img src="https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white"> <img src="https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=Apache%20Tomcat&logoColor=white">

### 데이터 파이프라인
<img src="https://img.shields.io/badge/Apache%20Hadoop-66CCFF?style=for-the-badge&logo=Apache%20Hadoop&logoColor=white"> <img src="https://img.shields.io/badge/Apache%20Spark-E25A1C?style=for-the-badge&logo=Apache%20Spark&logoColor=white"> <img src="https://img.shields.io/badge/PyTorch-EE4C2C?style=for-the-badge&logo=PyTorch&logoColor=white"> <img src="https://img.shields.io/badge/Apache%20Airflow-017CEE?style=for-the-badge&logo=apache%20Airflow&logoColor=white">

### 백엔드
<img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white"> <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot">

### 프론트엔드
<img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB"> <img src="https://img.shields.io/badge/Redux-764ABC?style=for-the-badge&logo=Redux&logoColor=61DAFB">

## :bomb: 이슈

### 데이터 
1. KoBERT 정확도 
- 계획대로 훈련 데이터 셋을 생성하여 훈련을 시켰을 때, 정확도가 기대에 미치지 못하는 문제 발생.
- 훈련 데이터를 개선하고 하이퍼 파라미터를 조정함으로써 해결. 
2. 키워드 추출
- 기사 안의 명사를 카운팅하는 워드 카운트를 실행하였을 때 의미없는 단어들이 상위권에 위치하는 문제 발생.
- 키워드 추출 모델인 KeyBERT를 사용하여 기사 하나당 핵심 키워드 하나를 추출하고 카운팅하여 해결.
### 웹 
#### 프론트

1. state 관리
- 부모자식 컴포넌트 간의 state 관리는 props로 가능하지만, 관계가 없는 컴포넌트는 state 관리가 어려운 문제
- Redux를 사용하여 state를 관리함으로써 해결.

#### 백엔드

1. JPA
- 빈 리스트를 반환하거나 Entity 관련 에러를 다수 출력하는 문제 발생.
- Repository 에서 DB 정보를 잘 호출 할 수 있도록 메소드 수정하여 해결.
- Controller 에서 요청을 수신할 때 POST, GET 요청을 구분하여서 파라미터를 설정하여 해결.
2. Spring Security + JWT
- antMatchers.permitAll()을 해도 메소드 실행이 되지 않는 문제발생가 발생하여 .csrf().disable() 추가하여 해결.
- 파라미터 값을 가져오지 못하여 access token이 생성이 되지 않는 문제가 발생하여 LoginDTO를 만들어 해결.
3. Docker 컨테이너 네트워크
- 독립된 컨테이너로 구축하면 컨테이너 간의 통신이 되지 않는 문제 발생.
- 브릿지 네트워크를 동일한 네트워크로 구성하여 해결.

## :thought_balloon: 개선 사항 
1. 모델서버와 HDFS를 연결하여 전체 데이터 흐름을 Airflow로 자동화
2. 로그인 Redis 활용 토큰 관리
3. 리액트 프로젝트 도커 컴포즈로 배포
4. 독립된 도커 컨테이너로 구축된 MariaDB 를 Mysqldump 를 이용하여 백업하고 React + Nginx + SpringBoot + MariaDB 함께 도커 컴포즈 재배포


<i class="devicon-pytorch-plain-wordmark"></i>


## :scroll: WIKI 
<a href="https://github.com/plus1250-project/joba/wiki">
    <img src="https://img.shields.io/badge/-JOBA%20WIKI-CDDEFF?style=for-the-badge&labelColor=EEF2FF"/></a>  


- 프로젝트 개요
- WBS
- DB 설계 
- 화면 설계
- Class Diagram
- API 명세서
- 시스템 아키텍처

