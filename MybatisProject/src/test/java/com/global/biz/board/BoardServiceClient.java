package com.global.biz.board;

import java.util.List;

import com.global.biz.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis �ӽ� ����.....");
		vo.setWriter("ȫ�浿");
		vo.setContent("myBatis �ְ�");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("------>"+board.toString());
		}
		
	}

}
