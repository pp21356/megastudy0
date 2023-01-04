package com.example.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.MemberDto;

@RestController
public class PutController {
	
	@PutMapping("/member1")
	public String putMemberDto(@RequestBody MemberDto memberdto) {
		return memberdto.toString();
	}
	
	@PutMapping("/member2")
	public Object putMemberDto2(@RequestBody MemberDto memberdto) {
		return memberdto;
	}
	
	//Extends putMemberDto2
	@PutMapping("/member3")
	public ResponseEntity putMemberDto3(@RequestBody MemberDto memberdto) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberdto);
	}
	
}
