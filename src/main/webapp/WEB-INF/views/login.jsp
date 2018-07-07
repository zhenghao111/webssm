<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<body><h2>Hello World!</h2>

<form name="f" action="/spitter/login" method="post">
    User: <input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Login">
    <input type="hidden" name="_csrf" value="123-123">
</form>
</body>
</html>
