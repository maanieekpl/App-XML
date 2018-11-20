<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
		<body>
		<xsl:for-each select="members/member">
			<p>Dear <xsl:value-of select="Author"/>,</p>

			<p>Your paper under title <xsl:value-of select="Title"/> that was register under nr ID <xsl:value-of select="ID_number"/> was successfully uploaded to a DepCoS-RELCOMEX conference.</p>

			<p>You can check that the file is correctly uploaded by following this link: ….</p>

			<p>Thanks for submitting to DepCoS-RELCOMEX 201x. Until the deadline, you</p>

			<p>can still update your information or transmit a revised file.</p>

			<p>Best regards,</p>

			<p>DepCoS-RELCOMEX chairs.  </p>
		</xsl:for-each>
		</body>
		</html>

	</xsl:template> 
</xsl:stylesheet>