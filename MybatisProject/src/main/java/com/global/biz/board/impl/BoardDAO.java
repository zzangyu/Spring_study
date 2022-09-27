package com.global.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.global.biz.board.BoardVO;
import com.global.biz.util.SqlSessionFactoryBean;

public class BoardDAO {
	
	private SqlSession myBatis;
	
	public BoardDAO() {
		myBatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		myBatis.insert("BoardDAO.insertBoard", vo);
		myBatis.commit();
	}

	public void updateBoard(BoardVO vo) {
		myBatis.update("BoardDAO.updateBoard", vo);
		myBatis.commit();
	}
	
	public void deleteBoard(BoardVO vo) {
		myBatis.delete("BoardDAO.deleteBoard", vo);
		myBatis.commit();
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)myBatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return myBatis.selectList("BoardDAO.getBoardList", vo);
	}
	
}
