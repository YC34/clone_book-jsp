<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 6/27/24
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>뉴스 관리 앱</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container w-75 mt-5 mx-auto">
        <h2>${news.title}</h2>
        <hr>
        <div class="card w-75 mx-auto">
            <img class="card-img-top" src="${news.img}">
            <div class="card-body">
                <h4 class="card-title">Date: ${news.date}</h4>
                <p class="card-text">Content: ${news.content}</p>
            </div>
        </div>
        <hr>
        <a href="javascript:history.back()" class="btn btn-primary"><< Back</a>
    </div>
</body>
</html>
