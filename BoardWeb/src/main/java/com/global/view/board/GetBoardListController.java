//package com.global.view.board;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.global.biz.board.BoardVO;
//import com.global.biz.board.impl.BoardDAO;
//
//@Controller
//public class GetBoardListController {
//
//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) { // 정보를 줘야돼서 ModelAndView도 같이 활용한다.
////		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글 목록 조회 처리");
////		BoardVO vo = new BoardVO();
////		BoardDAO boardDAO = new BoardDAO();
////		List<BoardVO> boardList = boardDAO.getBoardList(vo);
//		
//		// 검색된 결과를 session에 저장하고 글 목록 화면으로 이동시킴
////		HttpSession session = request.getSession();
////		session.setAttribute("boardList", boardList);
////		return "getBoardList";
//		
//		// 검색된 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
//		mav.addObject("boardList", boardDAO.getBoardList(vo));
//		mav.setViewName("getBoardList.jsp");
//		return  mav;
//	}
//
//}
