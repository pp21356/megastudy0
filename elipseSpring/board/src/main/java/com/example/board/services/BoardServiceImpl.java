package com.example.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.beans.dao.BoardDAO;
import com.example.board.vo.BoardVO;
import com.example.board.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void register(BoardVO board) {
		boardDAO.register(board);
	}
	@Override
	public BoardVO get(Long bno) {
		return boardDAO.get(bno);
	} 
	@Override
	public boolean modify(BoardVO board) {
		return boardDAO.modify(board);
	}
	@Override
	public boolean remove(long bno) {
		return boardDAO.remove(bno);
	}
	@Override
	public List<BoardVO> getList(){
		return boardDAO.getList();
	}
	@Override
	public List<BoardVO> getList(Criteria cri){
		return boardDAO.getList(cri);
	}
	@Override
	public int getTotal(Criteria cri) {
		return boardDAO.getTotal(cri);
	}
}