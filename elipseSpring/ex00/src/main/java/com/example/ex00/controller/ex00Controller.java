package com.example.ex00.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/example/*")
@Slf4j
public class ex00Controller {

	@RequestMapping(value= "/eat", method= {RequestMethod.GET, RequestMethod.POST})
	public String eating() {
		return"갈비찜 먹고싶다.";
	}
	
	@RequestMapping("/sleep")
	public String sleep() {
		log.info("--------------------");
		log.info("자는중");
		log.info("--------------------");
		return "자는 중";
	}
	
	@RequestMapping("") //@RequestMapping 어노테이션을 생략하면 요청에 의해 실행될 수 없다.
	public String luck() {
		return "로또 50회차 미당첨분이 나에게로..";
	}
	
	@GetMapping("/play/{variable1}")
	public String play(@PathVariable("variable1") String variable1) {
		log.info("--------------------");
		log.info(variable1);
		log.info("--------------------");
		return "20시간째 노는중";
	}
	
	@GetMapping("/sing") //sing?name=XXXX$song=XXXX&duration=XXX
	public String sing(@RequestParam String name,
			@RequestParam String sing,
			@RequestParam String duration) {
		log.info("--------------------");
		log.info(name);
		log.info(sing);
		log.info(duration);
		log.info("--------------------");
		return "노래중";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw) {
		log.info("Login called:" + id + "/" + pw);
		if(id.equals("admin")) {
			return "admin";
		}
		return "User ";
	}
}
