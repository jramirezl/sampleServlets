<%-- 
    Document   : welcome.jsp
    Created on : Jun 20, 2019, 12:16:47 AM
    Author     : jpramirez
--%>

<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <% 
            out.println(request.getAttribute("message"));
        %>
        <c:out value="${message}"/>
    </body>
</html>
