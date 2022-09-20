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
		
		// 1. Ŭ���̾�Ʈ�� ��û path ������ ������
		String uri = request.getRequestURI(); // BoardWeb/~~ ���⼭ /��������
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		// 2. HandlerMapping�� ���� path�� �ش��ϴ� controller�� �˻��� (MVC FrameWork ���)
		Controller ctrl = handlerMapping.getController(path);
		// 3. �˻��� ��Ʈ�ѷ��� �����Ѵ�.
		String viewName = ctrl.handleRequest(request, response);
		// 4. ViewResolver�� ���ؼ� viewName�� �ش��ϴ� ȭ���� �˻���
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		// 5. �˻��� ȭ������ �̵��Ѵ�.
		response.sendRedirect(view);
		
		/*
		// 2. Ŭ���̾�Ʈ ��û�� path�� ���� ������ �б�ó���Ѵ�.(Model 2 ���)
		if(path.equals("/login.do")) { // �ѤѤѤѤѤ� �α��� ó�� �ѤѤѤѤѤ�
			System.out.println("�α��� ó��");
			// ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// �����ͺ��̽� ����ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// ȭ�� �׺���̼�
			if(user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login_proc.jsp");
			}
			
		} else if(path.equals("/logout.do")) { // �ѤѤѤѤѤ� �α׾ƿ� ó�� �ѤѤѤѤѤ�
			System.out.println("�α׾ƿ� ó��");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		} else if(path.equals("/insertBoard.do")) { // �ѤѤѤѤѤ� �� ��� ó�� �ѤѤѤѤѤ�
			System.out.println("�� ��� ó��");
			// 1. ����� �Է� ���� ����
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ����
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			// ȭ�� ����
			response.sendRedirect("getBoardList.do");
		
		} else if(path.equals("/updateBoard.do")) { // �ѤѤѤѤѤ� �� ���� ó�� �ѤѤѤѤѤ�
			System.out.println("�� ���� ó��");
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
			
		} else if(path.equals("/deleteBoard.do")) { // �ѤѤѤѤѤ� �� ���� ó�� �ѤѤѤѤѤ�
			System.out.println("�� ���� ó��");
			// 1. ����� �Է� ���� ����
			String seq = request.getParameter("seq");
			
			// 2. DB ����
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			// ȭ�� ����
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")) { // �ѤѤѤѤѤ� �� �� ��ȸ ó�� �ѤѤѤѤѤ�
			System.out.println("�� �� ��ȸ ó��");
			// 1. �˻��� �Խñ� ��ȣ ����
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
		} else if(path.equals("/getBoardList.do")) { // �ѤѤѤѤѤ� �� ��� ��ȸ ó�� �ѤѤѤѤѤ�
			System.out.println("�� ��� ��ȸ ó��");
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// �˻��� ����� session�� �����ϰ� �� ��� ȭ������ �̵���Ŵ
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
		*/
	}
	
	
}
