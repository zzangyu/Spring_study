<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="board" value="${board}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 정보</title>
</head>
<body>
	<div align="center">
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="${board.seq}" >
			<table border="1" cellpading="0" cellspacing="0">
				<%-- 제목 --%>
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left">
						<input type="text" name="title" value="${board.title}">
					</td>
				</tr>
				<%-- 작성자 --%>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.writer}</td>
				</tr>
				<%-- 내용 --%>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left">
						<textarea rows="10" cols="40" name="content">${board.content}</textarea>
					</td>
				</tr>
				<%-- 등록일 --%>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.regDate}</td>
				</tr>
				<%-- 조회수 --%>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.cnt}</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정">
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp" >글 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=${board.seq}" >글 삭제</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do" >글 목록</a>
	</div>
</body>
</html>