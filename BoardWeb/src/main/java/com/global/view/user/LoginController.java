//package com.global.view.user;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.global.biz.user.UserVO;
//import com.global.biz.user.impl.UserDAO;
//
//@Controller
//public class LoginController {
//	@RequestMapping("/login.do")
//	public String loginView(UserVO vo) {
//		System.out.println(" 로그인 화면으로 이동");
//		
//	}
//	
//	@RequestMapping("/login.do")
//	public String login(UserVO vo, UserDAO userDAO) {
////		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		// 사용자 입력 정보 추출
////		String id = request.getParameter("id");
////		String password = request.getParameter("password");
//			
//		// 데이터베이스 연동처리
////		UserVO vo = new UserVO();
////		vo.setId(id);
////		vo.setPassword(password);
//			
////		UserDAO userDAO = new UserDAO();
////		UserVO user = userDAO.getUser(vo);
//		
//		// 화면 네비게이션
////		ModelAndView mav = new ModelAndView();
//		if(userDAO.getUser(vo) != null) {
//			return "getBoardList.do";
//		} else {
//			return "login.jsp"; // prefix
//		}
//	}
//	
//}
