package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList list=new ArrayList();
		HttpSession httpsession=request.getSession();
		PrintWriter out=response.getWriter();
		 out.println("<h4>Your Cart</h4>");
         String sql="select * from books where bcode in "+list;
         sql=sql.replace('[', '(');
         sql=sql.replace(']', ')');
		if(httpsession.getAttribute("check")!=null)
		{	
				list=(ArrayList) httpsession.getAttribute("check");
				 try{
		                Class.forName("com.mysql.jdbc.Driver");
		                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod","root","root");
		                PreparedStatement ps=con.prepareStatement(sql);
		                ResultSet rs=ps.executeQuery();
		                out.println("<form action=RemoveAll>");
		                out.println("<table border=2>");
		                out.println("<tr>");
		                out.println("<th>Code</th>");
		                out.println("<th>Title</th>");
		                out.println("<th>Author</th>");
		                out.println("<th>Subject</th>");
		                out.println("<th>Price</th>");
		                out.println("</tr>");
		                int sum=0;
		                while(rs.next()){
		                    String s1=rs.getString(1);
		                    String s2=rs.getString(2);
		                    String s3=rs.getString(3);
		                    String s4=rs.getString(4);
		                    int s5=rs.getInt(5);
		                    sum=sum+s5;
		                    out.println("<tr>");
		                    out.println("<td>"+s1+"</td>");
		                    out.println("<td>"+s2+"</td>");
		                    out.println("<td>"+s3+"</td>");
		                    out.println("<td>"+s4+"</td>");
		                    out.println("<td>"+s5+"</td>");
		                    out.println("<td><a href=RemoveBook?code="+s1+">[X]</a></td>");
		                    out.println("</tr>");
		                    
		                }
		                out.println("<tr>");
		                out.println("<td></td><td></td><td></td>");
		                out.println("<td>Total</td>");
		                out.println("<td>"+sum+"</td>");
		                out.println("<td></td>");
		                out.println("<td><input type=submit value=X></td>");
		                out.println("</tr>");
		                out.println("</table>");
		                out.println("</form>");
		                con.close();
		                }catch(Exception e){
		                    out.println(e);
		                }
		                
		                
		                
		                
		                out.println("<h5><a href=SubjectPageServlet>Add-More-Books</a></h5>");
		                out.println("<h5><a href=buyerpage.jsp>Buyer-Home</a></h5>");
		        }
		out.println("</body>");
        out.println("</html>");

		            }
		            }

	

