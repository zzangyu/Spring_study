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
//public class DeleteBoardController {
//
//	@RequestMapping("/deleteBoard.do")
//	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
//		System.out.println("�� ���� ó��");
//		// 1. ����� �Է� ���� ����
////		String seq = request.getParameter("seq");
//		
//		// 2. DB ����
////		BoardVO vo = new BoardVO();
////		vo.setSeq(Integer.parseInt(seq));
//		
////		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//
//		// ȭ�� ����
////		ModelAndView mav = new ModelAndView();
////		mav.setViewName("redirect:getBoardList.do");
////		return mav;
//		return "getBoardList.do";
//	}
//
//}
