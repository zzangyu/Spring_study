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
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) { // ������ ��ߵż� ModelAndView�� ���� Ȱ���Ѵ�.
////		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("�� ��� ��ȸ ó��");
////		BoardVO vo = new BoardVO();
////		BoardDAO boardDAO = new BoardDAO();
////		List<BoardVO> boardList = boardDAO.getBoardList(vo);
//		
//		// �˻��� ����� session�� �����ϰ� �� ��� ȭ������ �̵���Ŵ
////		HttpSession session = request.getSession();
////		session.setAttribute("boardList", boardList);
////		return "getBoardList";
//		
//		// �˻��� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
//		mav.addObject("boardList", boardDAO.getBoardList(vo));
//		mav.setViewName("getBoardList.jsp");
//		return  mav;
//	}
//
//}
