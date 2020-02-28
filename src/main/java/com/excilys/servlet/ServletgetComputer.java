package com.excilys.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletgetComputer extends HttpServlet {

public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
	request.getRequestDispatcher("/static/View/addComputer.html").forward(request, response);
	
  }
}

