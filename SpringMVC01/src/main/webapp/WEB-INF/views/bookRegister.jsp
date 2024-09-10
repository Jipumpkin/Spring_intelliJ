<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix ="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Spring MVC 01</h2>
		<div class="panel panel-default">
			<div class="panel-heading">책 등록하기</div>
			<div class="panel-body">
			<!-- 책 등록 폼 -->
                <form action="/s01/bookRegister" method="post">
                  <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
                  </div>
                  <div class="form-group">
                    <label for="price">가격:</label>
                    <input type="number" class="form-control" placeholder="Enter price" id="price" name="price">
                  </div>

                  <div class="form-group">
                    <label for="author">저자:</label>
                    <input type="text" class="form-control" placeholder="Enter author" id="author" name="author">
                  </div>

                  <div class="form-group">
                    <label for="page">페이지:</label>
                    <input type="number" class="form-control" placeholder="Enter page" id="page" name="page">
                  </div>

                  <button type="submit" class="btn btn-primary btn-sm">등록하는것을묻는것에대한허락을구하는행위의양해구하기</button>
                  <button type="reset" class="btn btn-danger btn-sm">취소</button>
                </form>

			</div>
			<div class="panel-footer">웹기반 인공지능 Track2(B)- Jipumpkin</div>
		</div>
	</div>

</body>
</html>