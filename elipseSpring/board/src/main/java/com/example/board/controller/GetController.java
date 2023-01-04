package com.example.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GetController {
	
	@GetMapping("/board")
	public String showBoard() {
		log.info("----------------");
		log.info("GetController:showBoard() : Called");
		log.info("----------------");
		return "(Get) Board like this";
	}
	
	//http://localhost:10002/request?name=v1&email=v2&organization=v3
	//Getter/Setter Auto Configuration
	@GetMapping(value="/request")
	public String getRequestParam(MemberDto memberdto) {
		return memberdto.toString();
	}
	
}
