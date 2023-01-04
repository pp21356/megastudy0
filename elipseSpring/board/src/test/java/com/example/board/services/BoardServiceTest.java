package com.example.board.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardServiceTest {
	@Autowired
	BoardServiceImpl boardService;
	
	
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글작성");
		board.setContent("새로운 내용 생성");
		board.setWriter("인성");
		boardService.register(board);
		log.info("생성 게시물 번호 : " + board.getBno());
	}
	
	@Test
	public void testGet() {
		log.info(boardService.get(1L).toString());
	}
	@Test
	public void testGetList() {
		boardService.getList().forEach(board->log.info(board.toString()));
	}
	
	@Test
	public void testModify() {
		BoardVO board = boardService.get(2L);
		if(board== null) {
			return;
		}
		board.setTitle("제목 또 수정합니다.");
		log.info("Modify : " + boardService.modify(board));
	}
	
	@Test
	public void testRemove() {
		log.info("Remove  : " + boardService.remove(22L));
	}
	
	
	
}
