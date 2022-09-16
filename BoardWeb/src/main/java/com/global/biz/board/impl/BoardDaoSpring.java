package com.global.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.global.biz.board.BoardVO;

@Repository
public class BoardDaoSpring { // �ι�° ���
	// public class BoardDaoSpring extends JdbcDaoSupport{ ù��° ��� getJdbcTemplate ���

	// SQL ��ɾ�
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* ù��° ���
	 * @Autowired public void setSuperDataSource(DataSource dataSource) {
	 * super.setDataSource(dataSource); }
	 */	
	// CRUD ����� �޼ҵ� ���� 
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("======> Spring JDBC�� InsertBoard() ����� ó��");
//		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent()); ù���� ���
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent()); // �ι�° ���
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("======> Spring JDBC�� updateBoard() ����� ó��");
//		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq()); ù���� ���
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());// �ι�° ���
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("======> Spring JDBC�� deleteBoard() ����� ó��");
//		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq()); ù���� ���
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());// �ι�° ���
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("======> Spring JDBC�� getBoard() ����� ó��");	
		Object[] args = {vo.getSeq()};
//		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper()); ù���� ���
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());// �ι�° ���
	}
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("======> Spring JDBC�� getBoardList() ����� ó��");
//		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper()); ù���� ���
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());// �ι�° ���
	}
	
}
