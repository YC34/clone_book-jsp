<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 6/25/24
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>JSTL 종합예제</title>
</head>
<body>
        <h2>JSTL 종합에제</h2>
        <hr>
        <h3>set,out</h3>
        <c:set var="product1" value="<h2>애플 아이폰</h2>" />
        <c:set var="product2" value="삼성 갤럭시 노트" />
        <c:set var="intArray" value="${[1,2,3,4,5]}" />
        <p>
            product1(jstl):
            <c:out value="${product1}" default="Not registered" escapeXml="true"/>
        </p>
</body>
</html>
