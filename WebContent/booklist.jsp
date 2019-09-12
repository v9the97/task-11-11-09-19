<%@page import="java.sql.*"%>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<h3>Select The Desired Subject</h3>
	<hr>
		<pre>
		<form action="ShowSelectedBooks.jsp">
		
<%
Class.forName("com.mysql.jdbc.Driver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod","root","root");
 String sql="SELECT distinct subject FROM books ";
	PreparedStatement ps=con.prepareStatement(sql);
	
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		
%>
<input type="checkbox" name="subject" value="<%= rs.getString(1)%>"><a href='BookListServlet?subject=<%=rs.getString(1) %>'><%= rs.getString(1)%></a><br>

<%
	}
	con.close();
%>
<input type="submit" >
</form>
</pre>
	<hr>
</body>
</html>