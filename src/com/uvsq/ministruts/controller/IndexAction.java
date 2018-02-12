package com.uvsq.ministruts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexAction implements Action {

	@Override
	public String perform(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("This will launch the Welcome page");
		return "Welcome_page";
	}

}
