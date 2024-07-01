# 한빛 아카테미 JSP 책 클론코딩

### Information
* Environment
  * java version : 17
  * jdk : Temurin-17.0.11+9
  * Server : tomcat 11.0.0
  * os : mac
  * idle : intellij 
  * build : gradle 
  * DB : oracle-11g

### ISSUE
* JSTL 사용 방법 변경됨. javax -> jakarta로 변경 됨.
  * tomcat 10.0.0 이상, spring 3.0 이상 
  * 변경 사항
    * uri = <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    * dependency -   
      * implementation group: 'jakarta.servlet.jsp.jstl', name: 'jakarta.servlet.jsp.jstl-api', version: '3.0.0' 
      * implementation group: 'org.glassfish.web', name: 'jakarta.servlet.jsp.jstl', version: '3.0.0'

* 2024.06.27 ch10 패키지
  * img파일 경로 저장이 안됨
    * 해결 : 경로 설정이 잘못됨.(해결완료.)


### config에 대한 궁금증 및 보완하고싶은 사항.
  1. code에서 DB의 정보가 노출되고 있다. 노출되지 않게 설정파일을 따로 설정하는것이 좋아보인다.(프레임워크의 필요성..?)
  2. 매번 새로운 service가 생겨날때마다 dao단에 중복되는 코드들이 많이 보인다. 중복코드를 제거해보고싶다.
  3. image경로를 상대경로와 절대경로로 구분하여 지정해서 테스트 해봐야겠다.


## DockerFile
  * 현재 프로젝트를 image화 하고 docker-hub에 build하고 push해보기.
  * Base image는 리눅스를 사용하였다. 
  * 리눅스에 터미널로 접속하기 위해 ssh를 열어 두었다. 
  * ISSUE
    * DockerFile의 위치보다 상위 폴더가 COPY가 되질 않는다. 원인 파악하악 해야함.