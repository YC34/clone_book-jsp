<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 6/25/24
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="calc" class="ch07.Calculator"/>
<jsp:setProperty name="calc" property="*"/>

<html>
  <head>
  <title>계산기-useBean</title>
  </head>
  <body>
        <h2>계산결과-useBean</h2>
        <hr>
        결과: <%=calc.calc()%>
  </body>
</html>
