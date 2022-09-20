package com.global.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.global.view.board.DeleteBoardController;
import com.global.view.board.GetBoardController;
import com.global.view.board.GetBoardListController;
import com.global.view.board.InsertBoardController;
import com.global.view.board.UpdateBoardController;
import com.global.view.user.LoginController;
import com.global.view.user.LogoutController;

public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
