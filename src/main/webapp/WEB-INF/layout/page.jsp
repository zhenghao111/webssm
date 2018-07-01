<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<body>

<div id="header">
    <t:insertAttribute name="header"/>
</div>

<div id="content">
    <t:insertAttribute name="body" />
</div>

<div id="footer">
    <t:insertAttribute name="footer"/>
</div>

</body>
</html>
