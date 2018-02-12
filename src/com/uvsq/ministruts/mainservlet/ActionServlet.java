package com.uvsq.ministruts.mainservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import com.uvsq.ministruts.controller.Action;
import com.uvsq.ministruts.factory.FactoryXMLParser;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Main Servlet");
		try {
			FactoryXMLParser factory = FactoryXMLParser.getInstance("/home/ilyeshoudjedje/Documents/eclipse-workspace/MonStrutsFramework/WebContent/config.xml");
			Action a = factory.getAction(request.getServletPath());
			String nextPage = a.perform(request, response);
			request.getRequestDispatcher(nextPage+".jsp").forward(request, response);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | ParserConfigurationException
				| SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
