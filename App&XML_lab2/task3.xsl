<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
		<body style="background-color:#CCCCCC">
				<center><div style="background-image: url(task3_back.jpg); height: 720px; width: 960px; class: center;">
				<h1 style="color:#444444; padding-top: 20px;"><center>Persone</center></h1>
				
				<table><center>
					<tr>
						<td><h1><center>Name</center></h1></td>
						<td><h1><center>Surname</center></h1></td>
						<td><h1><center>Address</center></h1></td>
						<td><h1><center>Phone</center></h1></td>
						<td><h1><center>Job</center></h1></td>
					</tr>
					<xsl:for-each select="company/persones/persone">
					<tr>
						<td width="180px"><h2 style="color: #444444; margin-left: 10px;"><xsl:value-of select="name"/></h2></td>
						<td width="180px"><h2 style="color: #444444; margin-left: 10px;"><xsl:value-of select="surname"/></h2></td>
						<td width="180px"><h2 style="color: #444444; margin-left: 10px;"><xsl:value-of select="home_address"/></h2></td>
						<td width="180px"><h2 style="color: #444444; margin-left: 10px;"><xsl:value-of select="phone"/></h2></td>
						<td width="180px"><h2 style="color: #444444; margin-left: 10px;"><xsl:value-of select="job"/></h2></td>
					</tr>
					</xsl:for-each>
				</center></table>
			</div></center>
		</body>
		</html>
	</xsl:template> 
</xsl:stylesheet>