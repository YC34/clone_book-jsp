<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 6/25/24
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int n1 = Integer.parseInt(request.getParameter("n1"));
    int n2 = Integer.parseInt(request.getParameter("n2"));
    long result =0;

    switch (request.getParameter("op")) {
        case "+": result = n1 + n2; break;
        case "-": result = n1 - n2; break;
        case "*": result = n1 * n2; break;
        case "/": result = n1 / n2; break;
    }
%>
<html>
<head>
    <title>계산기 JSP</title>
</head>
<body>
    <h2>계산 결과</h2>
    <hr>
    결과 : <%=result%>
</body>
</html>
