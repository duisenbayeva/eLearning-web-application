<%-- 
    Document   : profile
    Created on : 14.05.2015, 20:48:34
    Author     : bduis_000
--%>

<%@page import="entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Student user = (Student) request.getSession().getAttribute("currentUser");
   
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= user.getName()%></title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>


