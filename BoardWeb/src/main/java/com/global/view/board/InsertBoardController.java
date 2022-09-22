//package com.global.view.board;
//
//import javax.servlet.http.HttpServletRequest;
//// import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//// import org.springframework.web.servlet.ModelAndView;
//// import org.springframework.web.servlet.mvc.Controller;
//
//import com.global.biz.board.BoardVO;
//import com.global.biz.board.impl.BoardDAO;
//
//@Controller
//public class InsertBoardController {
////	public class InsertBoardController implements Controller {
//
//	@RequestMapping(value = "/insertBoard.do")
//	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
////		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글 목록 처리");
//		// 1. 사용자 입력 정보 추출
////		String title = request.getParameter("title");
////		String writer = request.getParameter("writer");
////		String content = request.getParameter("content");
//		
//		// 2. DB 연동
////		BoardVO vo = new BoardVO();
////		vo.setTitle(title);
////		vo.setWriter(writer);
////		vo.setContent(content);
//		
////	BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//
//		// 화면 응답
////		ModelAndView mav = new ModelAndView();
////		mav.setViewName("redirect:getBoardList.do");
////		return mav;
//		return "getBoardList.do";
//	}
//
//}
