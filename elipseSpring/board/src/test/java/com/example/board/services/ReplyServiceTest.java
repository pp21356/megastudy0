package com.example.board.services;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.vo.Criteria;
import com.example.board.vo.ReplyVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j

public class ReplyServiceTest {
	
	private Long[] arBno= {69L, 68L, 67L, 66L, 65L};
	
	@Autowired
	private ReplyService replyService;
	
	//@Test
	public void testReplyService() {
		log.info(replyService.toString());
	}
	
	//@Test
	public void testInsert() {
		//5개 게시글에 4개씩 달기
		IntStream.rangeClosed(1,20).forEach(i->{
			ReplyVO reply = new ReplyVO();
			
			reply.setBno(arBno[i%5]);
			reply.setReply("서비스로 만든 댓글" +i);
			reply.setReplier("service"+i);
			
			replyService.register(reply);
			
		});
	}
	
	//@Test
	public void testRead() {
		Long targetRno = 21L;
		
		log.info("Service test read : " + replyService.get(targetRno));
	}
	
	//@Test
	public void testDelete() {
		Long targetRno = 34L;
		
		replyService.remove(targetRno);
	}
	
	//@Test 
	public void testUpdate() {
		Long targetRno = 21L;
		
		ReplyVO reply = replyService.get(targetRno);
		
		reply.setReply("Update Reply 0000");
		
		int count= replyService.modify(reply);
		
		log.info("Service Test update : " + count);
	}
	
	@Test
	public void testList() {
		Criteria cri =  new Criteria();
		List<ReplyVO> replies = replyService.getList(cri,69L);
		replies.forEach(reply-> log.info("Service Test getList : " + reply.toString()));
	}
	
}
