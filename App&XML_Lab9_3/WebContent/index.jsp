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



<body  >
<center>
<div align="left" style="width: 50%">
<c:import var = "weather" url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"/>
<x:parse xml = "${weather}" var = "output"/>    
    
	<h1><x:out select = "$output/query/results/channel/title" /></h1>
	<p>Today Status: <br>
	Date : <x:out select = "$output/query/results/channel/item/*[name()='yweather:condition']/@date" /> <br>
	Temp. : <x:out select = "$output/query/results/channel/item/*[name()='yweather:condition']/@temp" /> <br>
	Info. : <x:out select = "$output/query/results/channel/item/*[name()='yweather:condition']/@text" /></p>
<center>
<table border="1" width="100%">
  
	<tr >
		<th align="center">
			Code		
		</th>
		<th align="center">
			Date		
		</th>
		<th align="center">
			Day		
		</th>
		<th align="center">
			High		
		</th>
		<th align="center">
			Low		
		</th>
		<th align="center">
			Infomation		
		</th>
	</tr>
	  <x:forEach select = "$output/query/results/channel/item/*[name()='yweather:forecast']" var = "item">
	  	<tr>
	  	<td align="center">
            <x:out select = "$item/@code" />
        </td>
        <td align="center">
            <x:out select = "$item/@date" />
        </td>
        <td align="center">
            <x:out select = "$item/@day" />
        </td>       
        <td align="center" style="font-size:${varClass}px">
        	 <x:out select = "$item/@high" />
        </td>
        <td align="center">
            <x:out select = "$item/@low" />
        </td>
        <td align="center">
            <x:out select = "$item/@text" /></li>
        </td>
        
        </tr>    
      </x:forEach>

</table>
    
    </center>
  
    </div>

</center>

</body>
</html>