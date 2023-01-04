package com.example.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DeleteController {

	@DeleteMapping("/member/{variable}")
	public String DeleteMember(@PathVariable String variable) {
		return variable;
	}
	
	//http://localhost:10002/request?email=XXX
	@DeleteMapping(value="/request")
	public String DeleteRequest(@RequestParam String email) {
		return email + "을 가지고 있는 유저가 delete됩니다.";
	}
}
