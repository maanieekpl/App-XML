<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	<html>
		<body>
			<h2>TV SCHEDULE</h2>
			<table border="1">
				<tr bgcolor="#9acd32">
					<th>Time</th>
					<th>Title</th>
					<th>Description</th>
				</tr>
					<xsl:for-each select="TVSCHEDULE/CHANNEL/DAY/PROGRAMSLOT">
				<tr>
					<td><xsl:value-of select="TIME" /></td>
					<td><xsl:value-of select="TITLE" /></td>
					<td><xsl:value-of select="DESCRIPTION" /></td>
				</tr>
					</xsl:for-each>
			</table>
		</body>
	</html>
	</xsl:template>
</xsl:stylesheet>
