package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String password,username,address,mobile,email;
		password=request.getParameter("password");
	username=request.getParameter("username");
	address=request.getParameter("address");
	mobile=request.getParameter("mobile");
	email=request.getParameter("email");
	out.println("u"+username);
	HttpSession obj=request.getSession();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod","root","root");
		String sql="update  USERS set password=?,username=?,address=?,mobile=?,email=? where userid=?";
		PreparedStatement ps=con.prepareStatement(sql);
	
		ps.setString(1,password);
		ps.setString(2,username);
		ps.setString(3,address);
		ps.setString(4,address);
		ps.setString(5,email);
		ps.setString(6,obj.getAttribute("user").toString());
		
		out.println("update Completed ddddd");
		
		int n=ps.executeUpdate();
		out.println("update Completed");
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("working");
	}

}
