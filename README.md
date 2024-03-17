
<img src="/images/logo.png"  width="400px" height="200px">

# 목차

1. [**서비스 소개**](#-멍글멍글)
2. [**기획 배경**](#-기획-배경)
3. [**주요 기능**](#-주요-기능)
4. [**회고록**](#-회고록록)
5. [**팀원 소개**](#-팀원-소개)
6. [**기술 스택**](#-기술-스택)
7. [**아키텍처**](#%EF%B8%8F-아키텍처)
8. [**erd 다이어그램**](#-erd-다이어그램)
9. [**와이어프레임**](#-와이어프레임)
10. [**전체 기능 소개**](#%EF%B8%8F-전체-기능-소개)

# 🐶 멍글멍글
>
> 사람들이 반려견의 일생을 기록하고 공유하며 즐거움을 나눌 수 있는 반려견 SNS
>
> 프로젝트 기간 : 2024.01.03 - 2024.02.16 (7주)

## 🌍 기획 배경

### 배경
1인 가구에서 반려견을 키우는 사람들이 늘어나고 있지만, 기존의 SNS는 반려견에 대한 기록을 공유하거나, 반려견을 키우는 데 필요한 정보를 얻는 데 한계가 있습니다. 또한, 자신의 반려견과 유사한 취향이나 생활 스타일을 가진 다른 사용자를 찾아 소통하거나 정보를 공유하는 것이 어렵습니다. 이는 반려견과 함께하는 일상을 풍요롭게 만들고, 반려견을 더 잘 이해하고 돌보는 데 필요한 정보와 경험을 얻는 데 제한을 두고 있습니다.

이러한 문제는 기존의 SNS가 반려견에 특화된 기능을 제공하지 않고, 일반적인 정보 공유에 중점을 두고 있기 때문입니다. 이로 인해 사용자들은 자신의 반려견에 대한 일상을 기록하거나 공유하는 데 필요한 도구를 찾는 데 어려움을 겪고 있습니다. 또한, 사용자들간에 유사한 취향이나 경험을 가진 사람들을 찾아 소통하는 것이 어렵습니다.

### 문제 해결
반려견 전용 SNS를 만들어 이러한 문제를 해결할 수 있습니다. 이 SNS는 반려견의 일상을 기록하고 공유할 수 있는 기능, 반려견을 키우는 데 필요한 정보를 공유하고 얻을 수 있는 기능, 그리고 유사한 취향이나 경험을 가진 사용자들끼리 매칭하여 소통할 수 있는 기능을 제공합니다. 또한, 반려견과의 산책을 기록하고, 이를 통해 반려견의 건강 상태를 관리하고 향상시키는 데 도움을 줄 수 있습니다. 이러한 특화된 기능들을 통해 반려견을 키우는 사람들이 자신과 반려견의 일상을 더욱 풍요롭게 만들 수 있게 돕습니다.

## 🐕 주요 기능

<img src="/images/로그인.png"  width="200px" height="400px">

### 로그인
- 아이디와 비밀번호를 입력해 로그인합니다.
- 이메일 인증을 통해 회원가입을 합니다.
- 아이디, 비밀번호를 잊은 경우 아이디/비밀번호 찾기를 이용할 수 있습니다.

<img src="./images/detail.gif" alt="디테일"  width="200px" height="400px">

<img src="./images/add.gif" alt="등록"  width="200px" height="400px">

### 메인
- 상단에서 팔로우 추천(해당일의 팔로우 증가수 기준)하는 계정들을 확인할 수 있습니다.
- 유저가 검색 혹은 상세 확인한 게시물의 태그가 포함된 게시물들이 노출됩니다. 
- 좋아요, 팔로우, DM메세지를 보낼 수 있습니다.

![산책](./images/walk.gif)

### 산책
- 산책 경로를 기록할 수 있습니다.
- 경로와 산책 시간, 거리, 평점 등을 등록하고 다른 사람과 공유할 수 있습니다.
- my 버튼을 눌러 내 산책 기록들을 날짜별로 확인할 수 있습니다.

![매칭](./images/matching.gif)

### 매칭
- 토글 버튼을 눌러 매칭을 받고 싶은지 여부를 결정합니다.
- 내 강아지 특성, 친구가 되고싶은 강아지 특성을 입력합니다.
- 추천(입력한 특성에 하나라도 해당한 경우, 최대 20마리)받은 강아지 카드를 슬라이드하거나, 하트 혹은 깨진 하트 버튼을 눌러서 매칭 여부를 정합니다.
- 매칭이 끝나면 매칭이 성공한 강아지의 주인에게 DM메세지를 보낼 수 있습니다.

![프로필](./images/profile.gif)

### 프로필
- 편집 버튼을 누른 후 닉네임, 프로필 사진, 프로필 배경, 강아지 정보를 변경할 수 있습니다.
- 유저의 강아지 정보, 게시물, 스크랩한 게시물을 확인할 수 있습니다.
- 다른 사람의 프로필에서 팔로잉 버튼, DM메세지 버튼을 누를 수 있습니다.

<img src="/images/검색.png"  width="200px" height="400px">

### 검색
- 제목으로 게시물을 검색할 수 있습니다.
- 닉네임으로 유저를 검색할 수 있습니다.
- 검색한 태그가 포함된 게시물을 확인할 수 있습니다.

<img src="/images/알림.png"  width="200px" height="400px">

### 알림
- 팔로우, 좋아요, 댓글을 받은 경우 알림이 생깁니다
- 알림을 읽은 경우 흐리게 표시됩니다.

<img src="/images/dm1.png"  width="200px" height="400px">

<img src="/images/dm2.png"  width="200px" height="400px">

### DM
- DM방을 클릭하면 이전의 메세지가 표시되고, 이어서 대화할 수 있습니다.
- 더하기 버튼을 클릭하고, 새로운 유저와 대화할 수 있습니다.

## 😄 회고록
- React -> React Native로의 전환
  - 사용자 관점에서 바라볼 때 SNS의 사용성은 웹보다는 모바일로의 사용성이 훨씬 더 높다고 판단하여 프로젝트 중간에 React Native로 전환하여 모바일 앱으로 개발하였습니다. 특히 산책 기능의 GPS 기능의 정확도와 백그라운드에서의 사용을 위해 전환하였으나 일정 관리가 어려웠습니다. 시간에 쫓기듯이 프로젝트를 진행하여서 완성도면에서 아쉬운 부분들이 많았습니다. 그래서 기획/설계 관점에서부터 시간을 더 투자하여 사용자 경험을 고려하여 진행하는 것이 중요하다는 것을 깨달았습니다.
- 팀장으로서의 역할
  - 팀장이 어떠한 사고 방식을 가지느냐에 따라 팀의 분위기가 달라졌었습니다. 일정 관리 부분에서 조바심을 느껴 불안함을 보였을 때 팀원들 또한 불안해하는 것을 느꼈고, 그에 따라 어떻게든 해낼 수 있다는 긍정적인 사고방식을 지니며 팀원을 다독이자 프로젝트 능률이 더 올라갈 수 있었습니다. 또한 팀원들의 의견을 서로 존중해줌으로써 적극적인 피드백 수용이 가능하였고, 원활한 의사소통이 이루어지는데 일조할 수 있었습니다.

## 🤝 팀원 소개

### 김태현 (프론트엔드, 팀장)
### 김평섭 (프론트엔드)
### 배정식 (프론트엔드, 테크리더)
### 이윤지 (백엔드)
### 이지원 (백엔드)
### 이형우 (백엔드, 테크리더)

## 💻 기술 스택

### FrontEnd & BackEnd

[![React Native](https://img.shields.io/badge/React_Native-0.73.2-blue?style=flat&logo=react)](https://reactnative.dev/)
[![Kakao Map API](https://img.shields.io/badge/API-Kakao_Map-red?style=flat)](https://developers.kakao.com/docs/latest/ko/local/dev-guide)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.1-green?style=flat&logo=spring)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)](https://www.oracle.com/java/)
[![MariaDB](https://img.shields.io/badge/MariaDB-10.11.6-yellow?style=flat&logo=mariadb)](https://mariadb.org/)
[![Redis](https://img.shields.io/badge/Redis-7.2.4-red?style=flat&logo=redis)](https://redis.io/)
[![WebSocket](https://img.shields.io/badge/WebSocket-gray?style=flat&logo=websocket)](https://en.wikipedia.org/wiki/WebSocket)

### Cooperation

[![Git](https://img.shields.io/badge/Git-gray?style=flat&logo=git)](https://git-scm.com/)
[![GitLab](https://img.shields.io/badge/GitLab-gray?style=flat&logo=gitlab)](https://about.gitlab.com/)
[![Notion](https://img.shields.io/badge/Notion-gray?style=flat&logo=notion)](https://www.notion.so/)
[![Jira](https://img.shields.io/badge/Jira-gray?style=flat&logo=jira)](https://www.atlassian.com/software/jira)
[![Mattermost](https://img.shields.io/badge/Mattermost-gray?style=flat&logo=mattermost)](https://mattermost.com/)

### Tools

[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-2023.3.2-red?style=flat&logo=intellij-idea)](https://www.jetbrains.com/idea/)
[![Android Studio](https://img.shields.io/badge/Android_Studio-2023.1.1-green?style=flat&logo=android-studio)](https://developer.android.com/studio)
[![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-1.85.1-blue.svg?style=flat&logo=visual-studio-code)](https://code.visualstudio.com/)


### Infra

[![AWS EC2](https://img.shields.io/badge/AWS_EC2-gray?style=flat&logo=amazon-aws)](https://aws.amazon.com/ec2/)
[![Docker](https://img.shields.io/badge/Docker-24.0.7-blue?style=flat&logo=docker)](https://www.docker.com/)
[![AWS S3](https://img.shields.io/badge/AWS_S3-gray?style=flat&logo=amazon-s3)](https://aws.amazon.com/s3/)
[![Ubuntu](https://img.shields.io/badge/Ubuntu-20.04.06-purple?style=flat&logo=ubuntu)](https://ubuntu.com/)

## 🏛️ 아키텍처

![구조](/images/구조.png)

## 📊 ERD 다이어그램

![ERD](/images/ERD.png)

## 🎨 와이어프레임
<img src="/images/와이어프레임.png"  width="400px" height="600px">

## ⚙️ 전체 기능 소개

|  |기능|기능 설명|
|----|--------|------------|
|1|access token, refresh token|각 요청에서 Access token과 Refresh token을 통해 Access Token을 재발급 받는다.|
|2|이메일 인증|이메일 인증을 통해 로그인 아이디를 설정한다.|
|3|사용자 닉네임 중복체크|서비스 내에서 사용할 닉네임을 설정한다.|
|4|비밀번호 입력|로그인할때 사용할 비밀번호를 사용한다.|
|5|로그인 기능|아이디와 비밀번호를 입력해 로그인한다.|
|6|프로필 수정|사용자 닉네임을 변경한다.|
|7|배경사진 수정|사용자의 배경사진을 변경한다.|
|8|프로필 수정|프로필에 기재될 소개글, 비밀번호를 변경한다.|
|9|마이페이지|마이페이지에 들어간다.|
|10|프로필 검색|회원 닉네임을 통해 검색 키워드가 포함된 회원 프로필 목록을 보여준다.|
|11|팔로워 수 확인|회원의 팔로워 수를 확인하다.|
|12|팔로잉 수 확인|회원의 팔로잉 수를 확인한다.|
|13|팔로잉|회원을 팔로잉한다.|
|14|언팔로우|회원을 언팔로우한다.|
|15|반려견 등록|사용자와 함께하고 있는 반려견을 등록한다.|
|16|품종 검색|반려견의 품종을 검색한다.|
|17|반려견 목록|나와 함께하는 반려견 목록을 확인할 수 있다.|
|18|반려견 상세|나와 함께하는 반려견의 세부 정보를 확인할 수 있다.|
|19|게시물 등록|사진이나 영상을 등록한다.|
|20|게시물 검색|게시물을 제목으로 검색한다.|
|21|게시물 상세보기|게시물에 관한 모달을 생성한다.|
|22|게시물 태그 검색|태그가 포함된 게시글을 검색할 수 있다.|
|23|게시물 사진 모아보기|프로필 페이지에서 해당일(월)에 올린 사진들을 모아볼 수 있다. (캘린더 형식)|
|24|마이페이지|유저의 게시글/스크랩/반려견 목록을 확인할 수 있다.|
|25|큐레이팅 게시물 목록|메인 페이지에서 사용자별 큐레이팅 기준에 맞는 게시글 목록을 볼 수 있다.|
|26|팔로우 유저 게시물 목록|팔로우한 유저의 게시물 목록을 최신순으로 전달|
|27|게시물 좋아요|게시물에 좋아요 표시/해체를 할 수 있다.|
|28|게시물 스크랩|게시물을 스크랩 추가/해제를 할 수 있다.|
|29|댓글 등록|게시물에 댓글을 작성한다.|
|30|댓글 목록|게시물에 해당하는 댓글 목록을 볼 수 있다.|
|31|내 위치 산책 보기|산책 경로가 고민될 때, 산책 페이지에서 다른 사람의 산책로를 확인할 수 있다.|
|32|매칭 특징 추가|매칭을 위한 내 반려견 특징을 수정한다.|
|33|상대 특징 추가|매칭을 원하는 반려견 특징을 생성한다.|
|34|대화방 생성|대화할 상대를 선택한 후, 대화방을 생성한다.|
|35|메세지 전송|대화방내의 상대에게 메세지를 전송한다.|
---


