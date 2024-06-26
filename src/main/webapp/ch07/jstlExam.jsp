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
        <h2>JSTL 종합예제</h2>
        <hr>
        <h3>set,out</h3>
        <c:set var="product1" value="<h2>애플 아이폰</h2>" />
        <c:set var="product2" value="삼성 갤럭시 노트" />
        <c:set var="intArray" value="${[1,2,3,4,5]}" />

        <p>
            product1(jstl):
            <c:out value="${product1}" default="Not registered" escapeXml="true"/>
        </p>
        <p>product1(el):${product1}</p>
        <p>intArray[2]:${intArray[2]}</p>
        <hr>

        <h3>forEach: 배열 출력</h3>
        <ul>
            <c:forEach var="num" varStatus="i" items="${intArray}">
                <li>${i.index} : ${num}</li>
            </c:forEach>
        </ul>
        <hr>

        <h3>if</h3>
        <c:set var="checkout" value="true"/>
        <c:if test="${checkout}">
            <p>주문 제품: ${product2}</p>
        </c:if>
        <c:if test="${!chkekout}">
            <p>주문 제품 아님!</p>
        </c:if>

        <c:if test="${!empty product2}">
            <p>
                <b>${product2} 이미 추가됨!!</b>
            </p>
        </c:if>
        <hr>

        <h3>choose,when,otherwise</h3>
        <c:choose>
            <c:when test="${checkout}">
                <p>주문 제품: ${product2}</p>
            </c:when>
            <c:otherwise>
                <p>주문 제품 아님 !!</p>
            </c:otherwise>
        </c:choose>
        <hr>

        <h3>forTokens</h3>
        <c:forTokens var="city" items="Seoul|Tokyo|New York|Toronto" delims="|" varStatus="i">
            <c:if test="${i.first}">도시목록 : </c:if>
            ${city}
            <c:if test="${!i.last}">,</c:if>
        </c:forTokens>
        <hr>

</body>
</html>
