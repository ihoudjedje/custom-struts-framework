package com.uvsq.ministruts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExitAction implements Action {

	@Override
	public String perform(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("This Will launch the Exit page");
		return "Exit_page";
	}
}
