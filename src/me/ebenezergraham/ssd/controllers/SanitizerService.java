package me.ebenezergraham.ssd.controllers;
/*
ebenezergraham created on 6/26/19
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SanitizerService extends Thread {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, String> characterEncodedMap;
	
	public SanitizerService(HttpServletRequest request,
	                        HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		characterEncodedMap = new HashMap<>();
	}
	
	public void run() {
		try {
			System.out.println("New Sanitizer Thread " + Thread.currentThread().getId());
			encode();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void encode() throws IOException {
		//load Encoding into a map
		//loadEncodedVersion();
		loadEncodingFromFile("web/resources/urlencoding.txt");
		
		//Get the parameter from the request
		String input = request.getParameter("param");
		
		// Sample Example just in case the user doesn't supply a parameter
		if (input == null) input = "<script>alert()</script>";
		
		// loop through all the loaded characters and replace them with encoded versions
		for (String character : characterEncodedMap.keySet()) {
			String value = characterEncodedMap.get(character);
			input = input.replaceAll("[" + character + "]", value);
		}
		
		response.getWriter().print("Encoded Value: ");
		response.getWriter().println(input);
	}
	
	private void loadEncodingFromFile(String filename) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			String[] details;
			while ((line = reader.readLine()) != null) {
				details = line.split(",");
				characterEncodedMap.put(details[0], details[1].trim());
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	private Map<String, String> loadEncodedVersion() {
		characterEncodedMap.put("%", "%3d");
		characterEncodedMap.put("<", "%3C");
		characterEncodedMap.put(">", "%3E");
		characterEncodedMap.put("=", "%3d");
		characterEncodedMap.put(" ", "%20");
		characterEncodedMap.put("&", "%26");
		characterEncodedMap.put("?", "%3f");
		characterEncodedMap.put(";", "%3b");
		return characterEncodedMap;
	}
}
