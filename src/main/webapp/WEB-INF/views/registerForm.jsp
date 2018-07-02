<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h2>Hello World!</h2>

<%--<form method="post">--%>
    <%--first name:<input type="text" name="firstName" /> <br/>--%>
    <%--last name:<input type="text" name="lastName" /><br/>--%>
    <%--username:<input type="text" name="userName" /><br/>--%>
    <%--password:<<input type="password" name="password" ><br/>--%>
    <%--<input type="submit" value="register" />--%>
<%--</form>--%>


<sf:form method="post" commandName="spitter" enctype="multipart/form-data">
    FN: <sf:input path="firstName" /><sf:errors path="firstName" /> <br/>
    LN: <sf:input path="lastName" /><sf:errors path="lastName" /> <br/>
    UN: <sf:input path="userName" /><sf:errors path="userName" /> <br/>
    PW: <sf:password path="password" /><sf:errors path="password" /> <br/>
    Photo:<input type="file" name="photo" accept="image/jpeg">
    <input type="submit" value="register" />
</sf:form>


</body>
</html>
