package com.example.board.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.board.BoardApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {BoardApplication.class})
public class BoardControllerTest {
	//가짜 MVC 
	//마치 브라우저에서 URL을 요청한 것처럼 환경 생성
	private MockMvc mockMvc;
	
	//요청을 처리해주는 WebApplicationContext를 불러온다.
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeEach
	public void setup() {
		//가짜 MVC에 webApplicationContext를 전달 후 환경 생성
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	public void testList() throws Exception {
		log.info(mockMvc.perform (MockMvcRequestBuilders.get("/board/list")).toString());//.andReturn().getModelAndView().getModelMap().toString());
	}
	
	
	public void testRegist() throws Exception{
		String result= mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "테스트 새 글 제목").param("content", "테스트 새 글 내용").param("writer", "Cat")).toString();
	}
	
	
	public void testGet()throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno","24")).andReturn().toString());
				
	}
	
	
	public void testModify() throws Exception{
		String result= mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("bno", "2").param("title", "테스트 새 글 제목").param("content", "테스트 새 글 내용").param("writer", "Doh")).andReturn().getModelAndView().getModelMap().toString();
		log.info(result);
	}
	
	@Test
	public void testRemove() throws Exception {
		String result= mockMvc.perform(MockMvcRequestBuilders.get("/board/remove").param("bno", "27")).andReturn().getFlashMap().toString();
		log.info(result);
	}
	
	
	
	
	
}
