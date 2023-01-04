package com.example.ex00.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class erroecontroller {
	@GetMapping("/error")
	public String handelError(HttpServletRequest request) {
		Object status =request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			int status_code=Integer.valueOf(status.toString());
			if(status_code == HttpStatus.NOT_FOUND.value()) {
				return "error/4040404040";
			}
		}
		return "error/5050505050";
	}
}
