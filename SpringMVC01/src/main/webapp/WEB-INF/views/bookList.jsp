<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>Spring MVC 01</h2>
	  <div class="panel panel-default">

	  <c:if test="${empty cus}">
	    <div class="panel-heading text-center">Book
            <form class="form-inline" action="/s01/login" method="post">
              <label for="username">아이디:</label>
              <input type="text" class="form-control" placeholder="Enter username" id="username" name="username">
              <label for="password">Password:</label>
              <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">

              <button type="submit" class="btn btn-primary btn-sm">로그인</button>
            </form>

	    </div>
	    </c:if>
	    <c:if test="${not empty cus}">
	    <div class="panel-heading text-center">Book
            <form class="form-inline" action="/s01/logout" method="post">
              <label>Welcome! ${cus.name}.</label>

              <label>Reserves : ${cus.reserves}</label>


              <button type="submit" class="btn btn-primary btn-sm">로그아웃</button>
            </form>

	    </div>
	    </c:if>


	    <div class="panel-body">

        <table class="table table-bordered table-hover">
             <thead>
                <tr>
                   <th>번호</th>
                   <th>제목</th>
                   <th>가격</th>
                   <th>저자</th>
                   <th>페이지</th>
                </tr>
             </thead>
             <tbody>
                <!-- 게시글 내용 출력 -->
                <c:forEach varStatus="i"  var="vo"   items="${bookList}">
                <tr>
                   <td><c:out value="${vo.id}" /></td>
                   <td><a href="/s01/bookView/${vo.id}"><c:out value="${vo.title}" /></a></td>
                   <td><c:out value="${vo.price}" /></td>
                   <td><c:out value="${vo.author}" /></td>
                   <td><c:out value="${vo.page}" /></td>
                </tr>
                </c:forEach>
             </tbody>
        </table>

        <c:if test="${not empty cus}">
        <button class ="btn btn-sm btn-primary" onclick="location.href='/s01/bookRegister'">책 등록</button>
        </c:if>
	    </div>
	    <div class="panel-footer">웹기반 인공지능 Track2 (B) - Jipumpkin</div>
	  </div>
	</div>
</body>
</html>