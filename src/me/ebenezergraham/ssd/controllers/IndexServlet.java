package me.ebenezergraham.ssd.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response){
		FileService fileService = new FileService(request,response);
		fileService.run();
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response){
		FileService fileService = new FileService(request,response);
		fileService.run();
	}
	
	@Override
	protected void doDelete(HttpServletRequest request,
	                        HttpServletResponse response) {
		FileService fileService = new FileService(request,response);
		fileService.run();
	}
	
	@Override
	protected void doPut(HttpServletRequest request,
	                        HttpServletResponse response) {
		FileService fileService = new FileService(request,response);
		fileService.run();
	}
}
