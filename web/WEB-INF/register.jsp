<%-- 
    Document   : register
    Created on : Oct 12, 2022, 12:46:27 PM
    Author     : ety
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Username</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="" method="post">
            Username: <input type="text" name="username" value="${username}">
            <input type="submit" name="registerUsername" value="Register Name">
            <input type="hidden" name="action" value="register">
        </form>
        
         ${message}
        
    </body>
</html>
