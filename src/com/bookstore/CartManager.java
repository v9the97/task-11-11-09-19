package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CartManager")
public class CartManager extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList list=new ArrayList();
		PrintWriter out=response.getWriter();
	HttpSession httpsession=request.getSession();
	String s="vinod";
	s=request.getParameter("code");
	if(httpsession.getAttribute("check")!=null)
	{	
			list=(ArrayList) httpsession.getAttribute("check");
			list.add(s);
			httpsession.setAttribute("check", list);
			}
	else {
		

		list.add(s);
		httpsession.setAttribute("check", list);
	
	}
	out.print(httpsession.getAttribute("check"));
	

	}

}
