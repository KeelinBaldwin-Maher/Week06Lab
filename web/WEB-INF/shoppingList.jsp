<%-- 
    Document   : shoppingList
    Created on : Oct 12, 2022, 12:47:43 PM
    Author     : ety
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        Hello, ${username}
        <a href="ShoppingList?logout">
            Logout
        </a>
        
        <h2>List</h2>
        <form>
            Add item: <input type="text" name="addListItem" value="${listItemInput}">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>


        <%-- <c:if test="${list.size > 0}"> --%>
            <form>
                <table>
                    <c:forEach var="item" items="${list}"> 
                    <tr>
                        <td>
                            <input type="radio" name="deleteListItem" value="${item.index}">
                            ${item.name}
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
            </form>
            
      <%-- </c:if> --%>

        
    </body>
</html>
