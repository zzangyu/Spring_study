package com.global.view.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;
import com.global.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
			return "getBoardList.do";
		} else {
			return "login"; // prefix
		}

	}

}
