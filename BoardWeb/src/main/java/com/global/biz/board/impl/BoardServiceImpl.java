package com.global.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
// import com.global.biz.common.Log4jAdvice;
// import com.global.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOMybatis boardDAO;
//	private BoardDaoSpring boardDaoSpring;
//	private LogAdvice logAdvice;
//	private Log4jAdvice log4jAdvice;

//	public BoardServiceImpl() {
//		log4jAdvice = new Log4jAdvice();
//	}
	
	@Override
	public void insertBoard(BoardVO vo) {
//		log4jAdvice.printLogging();
		
//		if(vo.getSeq() == 0) { 
//			 throw new IllegalArgumentException("0번 글은 등록하실 수 없습니다."); 
//		}
		
		boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
//		log4jAdvice.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
//		log4jAdvice.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
//		log4jAdvice.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
//		log4jAdvice.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
