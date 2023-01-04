package com.example.board.mappers;

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
public class ReplyMapperTest {
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper.toString());
	}
	
	
	private Long[] arBno= {69L, 68L, 67L, 66L, 65L};
	//@Test
	public void testInsert() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO reply = new ReplyVO();
			reply.setBno(arBno[i%5]);
			reply.setReply("댓글 테스트"+i);
			reply.setReplier("replier"+i);
			
			mapper.insert(reply);
		});
	}
	
	//@Test
	public void testRead() {
		Long targetRno= 10L;
		log.info("----------------------------");
		ReplyVO reply = mapper.read(targetRno);
		log.info(reply.toString());
		log.info("----------------------------");
	}
	
	//@Test
	public void testDelete() {
		Long targetRno=10L;
		mapper.delete(targetRno);
		
	}
	
	//@Test
	public void testUpdate() {
		Long targetRno=10L;
		
		ReplyVO reply= mapper.read(targetRno);
		
		if(reply != null) {
			reply.setReply("UPDATE OK");
			
			int count = mapper.update(reply);
			log.info("UPDATE count: " + count);
		}
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, arBno[0]);
		replies.forEach(reply -> log.info(reply.toString()));
	}
	
	
}
