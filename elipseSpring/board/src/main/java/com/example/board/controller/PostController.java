package com.example.board.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PostController {
	
	@PostMapping("/board")
	public String showBoard() {
		log.info("----------------");
		log.info("PostController:showBoard() : Called");
		log.info("----------------");
		return "(Post) Board like this";
	}
	
	//http://localhost:10002/request
	//Getter/Setter Auto Configuration
	@PostMapping(value="/request")
	public String getRequestParam(@RequestBody MemberDto memberdto) {
		log.info("MemberDTO");
		return memberdto.toString();
	}
	
}
