<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body style=
				"background-color: #000000;
				background-image: url(task5_back.jpg); 
				background-position: center;
				background-attachment: fixed;
				backgroun-repeat: no-repeat;">	
				<h1><center><xsl:value-of select="rss/channel/title"/></center></h1>
				<div style="width: 80%;">
					<table>
						<xsl:for-each select="rss/channel/item">
						<tr>
							<td colspan="2">
								<p>
									<xsl:variable name="username" select="link"/>
									<a href="{$username}"><xsl:value-of select="title"/></a>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<img>
								<xsl:attribute name="url">
									<xsl:value-of select="media:content/@url"/>
								</xsl:attribute>
								</img>
							</td>
							<td>
								<xsl:value-of select="description"/>
							</td>
						</tr>
						</xsl:for-each>
					</table>
				</div>
			</body>
		</html>
	</xsl:template> 
</xsl:stylesheet>

