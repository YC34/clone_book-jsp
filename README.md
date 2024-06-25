# 한빛 아카테미 JSP 책 클론코딩

### Information
* Environment
  * java version : 17
  * jdk : Temurin-17.0.11+9
  * Server : tomcat 11.0.0
  * os : mac
  * idle : intellij 
  * build : gradle 

## ISSUE
* JSTL 사용 방법 변경됨. javax -> jakarta로 변경 됨.
  * tomcat 10.0.0 이상, spring 3.0 이상 
  * 변경 사항
    * uri = <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    * dependency -   
      * implementation group: 'jakarta.servlet.jsp.jstl', name: 'jakarta.servlet.jsp.jstl-api', version: '3.0.0' 
      * implementation group: 'org.glassfish.web', name: 'jakarta.servlet.jsp.jstl', version: '3.0.0'

    