//package com.global.view.board;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.global.biz.board.BoardVO;
//import com.global.biz.board.impl.BoardDAO;
//
//@Controller
//public class UpdateBoardController {
//
//	@RequestMapping("/updateBoard.do")
//	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
//		System.out.println("�� ���� ó��");
////		BoardVO vo = new BoardVO();
////		String title = request.getParameter("title");
////		String content = request.getParameter("content");
////		String seq = request.getParameter("seq");
//		
////		vo.setSeq(Integer.parseInt(seq));
////		vo.setTitle(title);
////		vo.setContent(content);
////		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.updateBoard(vo);
//		
////		ModelAndView mav = new ModelAndView();
////		mav.setViewName("getBoardList.do");
//		return "getBoardList.do";
//	}
//
//}
