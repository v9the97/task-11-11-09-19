package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String utype=request.getParameter("utype");
		try{
			if(utype.equals("owner")){
				if(userid.equals("admin") && password.equals("indore")){
					response.sendRedirect("adminpage.jsp");
				}else{
					out.println("INVALID CREDENTIALS FOR ADMIN");
				}
				
			}else{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod","root","root");
				String sql="SELECT username FROM USERS where userid=? AND password=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,userid);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					//response.sendRedirect("buyerpage.jsp");
					
					HttpSession session=request.getSession();
					session.setAttribute("user", userid);
					
					
					RequestDispatcher rd=request.getRequestDispatcher("buyerpage.jsp");
					rd.forward(request, response);
					
				}else{
					out.println("INVALID BUYER CREDENTIALS");
				}
				con.close();
			}
		}catch(Exception e){
			out.println(e);
		}
	}

}
