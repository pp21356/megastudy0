package com.example.board.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.vo.Criteria;
import com.example.board.vo.ReplyVO;

@Service
public interface ReplyService {
	public int register(ReplyVO reply);
	public ReplyVO get(Long rno);
	public int modify(ReplyVO reply);
	public int remove(Long rno);
	public List<ReplyVO> getList(Criteria cri, Long bno);
}
