package com.example.board.beans;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.beans.dao.ReplyDAO;
import com.example.board.vo.Criteria;
import com.example.board.vo.ReplyVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ReplyDAOTest {

	private Long[] arBno= {69L, 68L, 67L, 66L, 65L};
	
	@Autowired 
	ReplyDAO replyDAO;
	
	@Test
	public void testReplyDAO() {
		log.info(replyDAO.toString());
	}
	
	//@Test
	public void testInsert() {
		//5개의 게시물에 3개씩 댓글 달기
		IntStream.rangeClosed(1, 15).forEach(i -> {
			ReplyVO reply = new ReplyVO();
			
			reply.setBno(arBno[i%5]);
			reply.setReply("댓글 테스트 - DAO - " +i);
			reply.setReplier("guest" + i);
			
			log.info("Insert count: " + replyDAO.register(reply));
		});
	}
	
	//@Test
	public void testRead() {
		Long TargetRno = 30L;
		ReplyVO reply = replyDAO.get(TargetRno);
		
		log.info(reply.toString());
	}
	
	//@Test
	public void testDelete() {
		Long targetRno= 35L;
		
		replyDAO.remove(targetRno);
	}
	
	//@Test
	public void testModify() {
		Long targetRno = 21L;
		ReplyVO reply = replyDAO.get(targetRno);
		reply.setReply("REply Updated");
		
		int count = replyDAO.modify(reply);
		log.info("Update count : " + count);
	}
	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = replyDAO.getList(cri,69L);
		replies.forEach(reply-> log.info(reply.toString()));
	}
	
	
}
