<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 6/25/24
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
<%--    <meta charset="UTF-8">--%>
    <title>JSP 종합 예제</title>
</head>
<body>
    <h2>JSP 종합 예제</h2>
    <hr>
    <%!
        String[] members = {"김길동","홍길동","김사랑","박사랑"};
        int num1 = 10;

        int calc(int num2){
            return num1*num2;
        }
    %>

    <h3>
        1. JSP주석
    </h3>
    <h3>
        2.calc(10) 메서드 실행 결과:
        <%=calc(10)%>
    </h3>
    <hr>
    <h3>
        3. include: hello.jsp
        <%@include file="../hello.jsp"%>
    </h3>
    <hr>
    <h3>
        4. 스크립트(배열 데이터 출력)
    </h3>
        <ul>
            <%
                for (String name : members) {
            %>
                <li><%=name%></li>
            <%
                }
            %>


        </ul>

</body>
</html>
