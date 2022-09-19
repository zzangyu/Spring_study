<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.global.biz.board.BoardVO" %>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%
	BoardVO vo = new BoardVO();
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");

	vo.setSeq(Integer.parseInt(seq));
	vo.setTitle(title);
	vo.setContent(content);
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	response.sendRedirect("getBoardList.jsp");
%>