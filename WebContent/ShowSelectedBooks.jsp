<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table style="width:100%">
  <tr>
    <th>Book Code</th>
    <th>Book Title</th>
    <th>Subject</th>
    <th>Author</th>
    <th>Price</th>
  </tr>
  
 

<%

 Class.forName("com.mysql.jdbc.Driver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod","root","root");
 String parameter[]=request.getParameterValues("subject");
String sub="";
for(int i=0;i<parameter.length-1;i++)
{
	sub+="'"+parameter[i]+"',";
}
 sub+="'"+parameter[parameter.length-1]+"'";

  String sql="SELECT * FROM books where subject in ("+sub+")";
  PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
%>

<tr>
    <td><%=rs.getString(1) %></td>
    <td><%=rs.getString(2) %></td>
    <td><%=rs.getString(3) %></td>
    <td><%=rs.getString(4) %></td>
    <td><%=rs.getString(5) %></td>
  </tr>
<%} %>
</table>
</body>
</html>