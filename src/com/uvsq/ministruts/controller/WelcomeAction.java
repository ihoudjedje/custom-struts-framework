package com.uvsq.ministruts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeAction implements Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		
		if(Integer.parseInt(request.getParameter("age")) > 18) {
		
			System.out.println("Hello "+ request.getParameter("firstname") + " " + request.getParameter("familyname")+ "\n");
			System.out.println("you got " + request.getParameter("age") + "\n");
			System.out.println("and your email is " + request.getParameter("email"));
		
			return "Presentation_page";
		}else {
			return "Error_page";
	}
	}
}
