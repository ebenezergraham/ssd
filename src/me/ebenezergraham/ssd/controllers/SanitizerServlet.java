package me.ebenezergraham.ssd.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "SanitizerServlet",urlPatterns = "/sanitize")
public class SanitizerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response){
		SanitizerService sanitizerService = new SanitizerService(request,response);
		sanitizerService.run();
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response){
		SanitizerService sanitizerService = new SanitizerService(request,response);
		sanitizerService.run();
	}
}
