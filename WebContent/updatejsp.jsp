<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<center><tr>
   <td><h1>Registration Form For Sports</h1></td>
</tr><center>
 
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<form action="UpdateServlet" method="post">

<table border='0' cellpadding='0' cellspacing='0' width='480px' align='center'>
<tr>

<%
Class.forName("com.mysql.jdbc.Driver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod","root","root");
 String sql="SELECT * FROM USERS where userid=?";
	PreparedStatement ps=con.prepareStatement(sql);
	//HttpSession us=request.getSession();
	String userid=session.getAttribute("user").toString();
	
	ps.setString(1,userid);
	
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
%>


<tr>
    <td align='center'>Password:</td>
    <td><input type='text' name="password" value="<%=rs.getString(2) %>"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>


<tr>
    <td align='center'>User name:</td>
    <td><input type='text' name="username" value="<%=rs.getString(3) %>"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>

<tr>
    <td align='center'>Address:</td>
    <td><input type='text' name="address" value="<%=rs.getString(4) %>"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>

<tr>
    <td align='center'>Mobile:</td>
    <td><input type='text' name="mobile" value="<%=rs.getString(5) %>"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>

<tr>
    <td align='center'>Email:</td>
    <td><input type='text' name="email" value="<%=rs.getString(6) %>"></td>
</tr>

<% } %>

 <td align='center'><input type='submit' name='REGISTER' value="register"></td>
     
</tr>
</form>
</table>
</table>
 
</table>
</body>
</html>