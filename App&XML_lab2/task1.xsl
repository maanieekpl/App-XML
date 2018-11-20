<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
		<body>
			<h1>Details</h1>
			<p><xsl:value-of select="details/name"/></p>
			<p><xsl:value-of select="details/lastname"/></p>
			<p><xsl:value-of select="details/home_address"/></p>
			<p><xsl:value-of select="details/phone"/></p>
			<p><xsl:value-of select="details/job"/></p>
		</body>
		</html>
	</xsl:template> 
</xsl:stylesheet>