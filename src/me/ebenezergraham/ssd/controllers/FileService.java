package me.ebenezergraham.ssd.controllers;
/*
ebenezergraham created on 5/30/19
*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileService extends Thread {
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	public FileService(HttpServletRequest request,
	                   HttpServletResponse response) {
		this();
		this.request = request;
		this.response = response;
	}
	
	public FileService(){
		super();
	}
	
	public void run() {
		try {
			System.out.println("New Thread " + Thread.currentThread().getId());
			switch (request.getMethod()){
				case "GET":
					getFile();
					break;
				case "POST":
					postFile();
					break;
				case "DELETE":
					deleteFile();
					break;
					default:
						response.getWriter().println("Method Not supported");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getFile() {
		try {
			System.out.println("FileService::getFile " + Thread.currentThread().getId());
			request.setAttribute("payload", "Hello SSD");
			request.getRequestDispatcher("document.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void postFile() {
		try {
			System.out.println("FileService::postFile " + Thread.currentThread().getId());
			
			request.setAttribute("payload", "Posted Data");
			request.getRequestDispatcher("document.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteFile() {
		try {
			System.out.println("FileService::deleteFile " + Thread.currentThread().getId());
			
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			response.setHeader("payload", "I can't delete this file because then I have to create it again");
			response.getWriter().println("I can't/don't want to delete this file because then I have to create it again");
			// JSPs don't permit delete methods
		//	request.getRequestDispatcher("document.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
