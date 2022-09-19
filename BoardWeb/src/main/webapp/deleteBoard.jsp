<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.global.biz.board.BoardVO" %>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");
	
	// 2. DB 연동
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(vo);

	// 화면 응답
	response.sendRedirect("getBoardList.jsp");
%>