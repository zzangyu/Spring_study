package com.global.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. spring �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. spring �����̳ʷκ��� BoardServiceImpl ��ü�� ��û�Ѵ�.
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		// 3. �� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("�޷�");
		vo.setWriter("���� ������");
		vo.setContent("���� ����;�");
		boardService.insertBoard(vo);
		
		// 4. �� ��� �˻� ��� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println(board.toString());
		}
		
		// 5. �����̳� �ݱ�
		container.close();
	}

}
