package com.uvsq.ministruts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresentationAction implements Action {

	@Override
	public String perform(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("name", "ilyes");
		System.out.println("Nouveau article grace à simo "+ req.getParameter("article"));
		return "article";
	}

}
