package com.global.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
    public DispatcherServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	process(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트의 요청 path 정보를 추출함
		String uri = request.getRequestURI(); // BoardWeb/~~ 여기서 /전까지임
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		// 2. HandlerMapping을 통해 path에 해당하는 controller를 검색함 (MVC FrameWork 방식)
		Controller ctrl = handlerMapping.getController(path);
		// 3. 검색된 컨트롤러를 시작한다.
		String viewName = ctrl.handleRequest(request, response);
		// 4. ViewResolver를 통해서 viewName에 해당하는 화면을 검색함
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		// 5. 검색된 화면으로 이동한다.
		response.sendRedirect(view);
		
		/*
		// 2. 클라이언트 요청에 path에 따라 적절히 분기처리한다.(Model 2 방식)
		if(path.equals("/login.do")) { // ㅡㅡㅡㅡㅡㅡ 로그인 처리 ㅡㅡㅡㅡㅡㅡ
			System.out.println("로그인 처리");
			// 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 데이터베이스 연동처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// 화면 네비게이션
			if(user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login_proc.jsp");
			}
			
		} else if(path.equals("/logout.do")) { // ㅡㅡㅡㅡㅡㅡ 로그아웃 처리 ㅡㅡㅡㅡㅡㅡ
			System.out.println("로그아웃 처리");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		} else if(path.equals("/insertBoard.do")) { // ㅡㅡㅡㅡㅡㅡ 글 목록 처리 ㅡㅡㅡㅡㅡㅡ
			System.out.println("글 목록 처리");
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			// 화면 응답
			response.sendRedirect("getBoardList.do");
		
		} else if(path.equals("/updateBoard.do")) { // ㅡㅡㅡㅡㅡㅡ 글 수정 처리 ㅡㅡㅡㅡㅡㅡ
			System.out.println("글 수정 처리");
			BoardVO vo = new BoardVO();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);
			vo.setContent(content);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")) { // ㅡㅡㅡㅡㅡㅡ 글 삭제 처리 ㅡㅡㅡㅡㅡㅡ
			System.out.println("글 삭제 처리");
			// 1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			// 화면 응답
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")) { // ㅡㅡㅡㅡㅡㅡ 글 상세 조회 처리 ㅡㅡㅡㅡㅡㅡ
			System.out.println("글 상세 조회 처리");
			// 1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
		} else if(path.equals("/getBoardList.do")) { // ㅡㅡㅡㅡㅡㅡ 글 목록 조회 처리 ㅡㅡㅡㅡㅡㅡ
			System.out.println("글 목록 조회 처리");
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 검색된 결과를 session에 저장하고 글 목록 화면으로 이동시킴
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
		*/
	}
	
	
}
