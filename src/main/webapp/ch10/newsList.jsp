<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 6/27/24
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>뉴스 관리앱</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container w-75 mt-5 mx-auto">
        <h2>뉴스 목록</h2>
        <hr>
        <ul class="list-group">
            <c:forEach var="news" items="${newslist}" varStatus="status">
                <li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                    <a href="news.nhn?action=getNews&aid=${news.aid}" class="text-decoration-none">[${status.count}] ${news.title}, ${news.date}</a>
                    <a href="news.nhn?action=deleteNews&aid=${news.aid}"><span class="badge bg-secondary">&times;</span></a>
                </li>
            </c:forEach>
        </ul>
        <hr>
        <c:if test="${error != null}">
            <div class="alert alert-danger alert-dismissible fade show mt-3">
                에러 발생: ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>
        <button class="btn btn-outline-info mb-3" type="button" data-bs-toggle="collapse" data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">뉴스 등록</button>
        <div class="collapse" id="addForm">
            <div class="card card-body">
                <form method="post" action="/news.nhn?action=addNews" enctype="multipart/form-data">
                    <label class="form-label">제목</label>
                    <input type="text" name="title" class="form-control">
                    <label class="form-label">이미지</label>
                    <input type="file" name="file" class="form-control">
                    <label class="form-label">기사내용</label>
                    <textarea cols="50" rows="5" name="content" class="form-control"></textarea>
                    <button type="submit" class="btn btn-success mt-3">저장</button>
                </form>
            </div>
        </div>
    </div>



</body>
</html>
