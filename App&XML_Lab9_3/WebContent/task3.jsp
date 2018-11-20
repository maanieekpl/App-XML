<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.lab9.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		Host[] hosts = { 
				
			 new Host("localhost", "127.0.0.1"), 
			 new Host("a", "1.2.3.4"),
			 new Host("b", "2.2.2.2"),
			 new Host("c", "10.20.10.20"),

			};
	
		request.setAttribute("host", hosts);
		RequestDispatcher rs = request.getRequestDispatcher("xmlservlet");
		rs.forward(request,response);
		
	%>

</body>
</html>