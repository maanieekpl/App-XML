<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
        
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import var = "weather" url = "http://localhost:9988/Lab9_3/data/host.xml"/>
<x:parse xml = "${weather}" var = "output"/>    
    &lthosts&gt <br>
   <x:forEach select = "$output/hosts/host" var = "item">
         &lthost name ="<x:out select = "$item/@name" />"&gt <br>
         &ltip&gt<x:out select = "$item/ip" />&lt/ip&gt <br>
         &lt/host&gt<br>
   </x:forEach>
   &lt/hosts&gt
   
   <br>
   <br>
   <a href="updateip.html"> Update host</a>
</body>
</html>