package com.example.board.mappers;

import java.util.List;

import com.example.board.vo.AttachFileVO;

public interface AttachFileMapper {
	public void insert(AttachFileVO vo);
	public void delete(String uuid);
	public List<AttachFileVO> findByBno(Long bno);
}
