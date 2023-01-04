package com.example.board.beans.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.mappers.BoardMapper;
import com.example.board.vo.BoardVO;
import com.example.board.vo.Criteria;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
	
	@Autowired
	private BoardMapper mapper;
	
	public void register(BoardVO board) {
		mapper.insertSelectKey_bno(board);
	}

	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}
	
	public boolean modify(BoardVO board) {
		return mapper.update(board) != 0;
	}
	
	public boolean remove(Long bno) {
		return mapper.delete(bno)!=0;
	}
	public List<BoardVO> getList(){
		return mapper.getList();
	}
	public List<BoardVO> getList(Criteria cri){
		return mapper.getListWithPaging(cri);
	}
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}

}
