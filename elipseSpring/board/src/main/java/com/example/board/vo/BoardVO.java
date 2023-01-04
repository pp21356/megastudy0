package com.example.board.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String updatedate;
	//input태그의 name에 
		//attachList[i].fileName
		//attachList[i].uuid
		//attachList[i].uploadPath
		//attachList[i].fileType
		//방식으로 submit을 하면 자동으로 List에 add
		private List<AttachFileVO> attachList;
		
		public BoardVO() {}
}
