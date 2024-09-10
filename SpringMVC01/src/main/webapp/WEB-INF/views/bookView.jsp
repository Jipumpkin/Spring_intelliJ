<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
    .review-toggle{
        cursor : pointer;
        color : #17a2b8;
        font-weight : bold;
        text-decoration: underline;
    }

    .review-toggle:hover{
        color : #1e81b0;
    }
</script>
</head>
<body>

	<div class="container">
		<h2>Spring MVC 01</h2>
		<div class="panel panel-default">
			<div class="panel-heading">책 상세보기(ID:${book.id})</div>
			<div class="panel-body">
                <table class="table table-bordered">
                    <tr>
                        <td>번호</td>
                        <td>${book.id}</td>
                    </tr>

                    <tr>
                        <td>제목</td>
                        <td>${book.title}</td>
                    </tr>

                    <tr>
                        <td>가격</td>
                        <td>${book.price}</td>
                    </tr>

                    <tr>
                        <td>저자</td>
                        <td>${book.author}</td>
                    </tr>

                    <tr>
                        <td>페이지</td>
                        <td>${book.page}</td>
                    </tr>

                </table>
                <!-- 수정, 삭제, 목록, 수량, 구매(장바구니) -->
                <table class="table table-bordered">

                <tr>
                    <td>
                        <a class="btn btn-sm btn-primary">수량</a>
                        <a class="btn btn-sm btn-warning">삭제</a>
                        <a href="/s01/bookList" class="btn btn-sm btn-info">목록</a>
                    </td>
                    <td>
                        수량 : <input type="number"></input>
                        <button class="btn btn-sm btn-primary">장바구니 담기</button>
                    </td>
                </tr>

                </table>
                <!-- 작성된 리뷰가 있으면 출력 / 없으면 리뷰가 없습니다. -->
                <c:if test="${not empty avg_rating}">
                <h3>리뷰 리스트 ( 평점평균 : <small class="badge badge-warning">${avg_rating}</small> )</h3>
                </c:if>
                <c:if test="${empty avg_rating}">
                <h3>리뷰 리스트 ( 평점평균 : <small class="badge badge-warning"> 0 </small> )</h3>
                </c:if>
                <table class="table">
                    <c:if test="${not empty reviews}">

                    <c:forEach var="review" items="${reviews}">
                    <tr>
                        <td>작성일 : <fmt:formatDate value="${review.created_at}" pattern="yyyy-MM-dd" /></td>
                        <td>${review.content}</td>
                        <td>평점 : <small class="badge badge-warning">${review.rating}</small></td>
                        <td><a href="/s01/reviewRemove/${review.id}/${book.id}" class="btn btn-warning">삭제</a></td>
                    </tr>
                    </c:forEach>

                    </c:if>
                    <c:if test="${empty reviews}">
                    <tr>
                        <td colspan="3"> 등록된 리뷰가 없습니다.</td>
                    </tr>
                    </c:if>
                </table>

                <!-- 리뷰 : 제목, 작성자, 평점(1~5) -->

                <div class="text-center mt-4">
                    <span class="review-toggle" onclick="toggle()">리뷰 및 평점 쓰기</span>
                </div>
                <div id="review-form" class="mt-3 mb-3" style="display:none;">




                <h3>리뷰작성</h3>
                <form action="/s01/reviewAdd" method="post">
                   <input type="hidden" name="book_id" value="${book.id}"/>
                   <input type="hidden" name="customer_id" value="${cus.id}"/>
                   <table class="table">
                      <tr>
                        <td>내용</td>
                        <td><textarea rows="2" name="content" class="form-control"></textarea></td>
                      </tr>
                      <tr>
                        <td>평점</td>
                        <td>
                          <select class="form-control" name="rating">
                            <option value="1">1점-매우 나쁨</option>
                            <option value="2">2점-나쁨</option>
                            <option value="3">3점-보통</option>
                            <option value="4">4점-좋음</option>
                            <option value="5">5점-매우 좋음</option>
                          </select>
                        </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                             <button type="submit" class="btn btn-sm btn-primary">리뷰등록</button>
                          <td>
                      </tr>
                   </table>
                </form>
                </div>

			</div>
			<div class="panel-footer">웹기반 인공지능 Track2(B)- Jipumpkin</div>
		</div>
	</div>

</body>
 <script>
      function toggle() {
          var reviewForm = document.getElementById("review-form");
          if (reviewForm.style.display === "none" || reviewForm.style.display === "") {
              reviewForm.style.display = "block";
          } else {
              reviewForm.style.display = "none";
          }
      }
  </script>
</html>
