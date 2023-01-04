package com.example.board.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.example.board.vo.BoardVO;
import com.example.board.vo.Criteria;

@Service
@Mapper
public interface BoardMapper {
	//게시글 목록
	public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//게시글 등록
	public void insert(BoardVO board);

	//
	public void insertSelectKey_bno(BoardVO board);
	
	//게시글 읽기
	public BoardVO read(Long bno);
	
	//게시글 삭제
	//성공 시 삭제한 건수 리턴, 실패 시 0 리턴
	public int delete(Long bno);
	
	//업데이트
	public int update(BoardVO board);
	
	public int getTotal(Criteria cri);
}
