<%--
  Created by IntelliJ IDEA.
  User: zhenghao
  Date: 2018/7/1
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${spittleList}" var="spittle">
    <%--<li id="spittle_<c:out value="${spittle.id}"/>">--%>
        <%--<div class="spittleMessage">--%>
            <%--<c:out value="${spittle.message}" />--%>
        <%--</div>--%>
        <%--<div>--%>
            <%--<span class="spittleTime">--%>
                <%--<c:out value="${spittle.time}"/>--%>
            <%--</span>--%>
            <%--<span class="spittleLocation">--%>
                <%--(<c:out value="${spittle.latitude}" />,--%>
                <%--<c:out value="${spittle.longitude}" />)--%>
            <%--</span>--%>
        <%--</div>--%>
    <%--</li>--%>
    1
</c:forEach>

</body>
</html>
