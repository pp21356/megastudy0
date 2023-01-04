package com.example.board.beans.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.mappers.ReplyMapper;
import com.example.board.vo.Criteria;
import com.example.board.vo.ReplyVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReplyDAO {
	
	@Autowired
	private final ReplyMapper mapper;
	
	public int register(ReplyVO reply) {
		log.info("register......." + reply);
		return mapper.insert(reply);
	}
	
	public ReplyVO get(Long rno) {
		log.info("get........." +rno);
		return mapper.read(rno);
	}
	
	public int modify (ReplyVO reply){
		log.info("modify......."+ reply);
		return mapper.update(reply);
	}
	
	public int remove(Long rno) {
		log.info("delete........"+rno);
		return mapper.delete(rno);
	}
	
	public List<ReplyVO> getList(Criteria cri, Long bno){
		log.info("get reply List of Board : " + bno);
		return mapper.getListWithPaging(cri, bno);
	}
}
