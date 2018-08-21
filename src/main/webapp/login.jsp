<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import = "java.io.*,java.util.*" %>--%>




<%--<c:choose>--%>
    <%--<%= request.getParameter("username") %>--%>
    <%--<%= request.getParameter("password") %>--%>

    <%--<c:when test="${username.equals(\"admin\") and password.equals(\"password\")}">--%>
        <%----%>


        <%--response.sendRedirect("profile")--%>
    <%--</c:when>--%>


    <%--<c:otherwise>--%>
        <%--response.sendRedirect("notAdmin")--%>
    <%--</c:otherwise>--%>



<%--</c:choose>--%>


<%--}--%>


<%
    if (request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("password")){
            response.sendRedirect("/profile.jsp");
        }   else {
                 response.sendRedirect("/notAdmin.jsp");
        }
    }


%>


<html>
<head>
    <title>Login</title>

</head>
<body>
<h1><strong>LOGIN</strong></h1>

<%--<% request.setAttribute("username", "password"); %>--%>
<form method="POST" action="login.jsp">

    <label for="username">Username</label>
    <input id="username" name="username" class="form-control" type="text">


    <br>

    <label for="password">Password</label>
    <input id="password" name="password" type="password">

    <br>

    <input type="submit" value="Log In">
</form>

</body>
</html>