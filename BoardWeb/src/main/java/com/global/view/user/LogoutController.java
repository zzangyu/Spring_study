//package com.global.view.user;
//
//import javax.servlet.http.HttpServletRequest; import
//javax.servlet.http.HttpServletResponse; import
//javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller; 
//import org.springframework.web.bind.annotation.RequestMapping; 
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller 
//public class LogoutController {
// 
//	@RequestMapping("/logout.do") 
//	public String logout(HttpSession session) {
//		System.out.println("�α׾ƿ� ó��"); 
//		// HttpSession session = request.getSession();
//		session.invalidate(); 
//		// ModelAndView mav = new ModelAndView(); 
//		//mav.setViewName("redirect:login.jsp"); 
//		return "login.jsp"; 
//	}
//
//}
// 