<%-- 
    Document   : allUsers
    Created on : May 30, 2020, 10:59:22 AM
    Author     : glamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Table of All Users</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Role Name</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${usersAll}" var="u">
                    <tr>
                        <td>${u.userId}</td>
                        <td>${u.username}</td>
                        <td>${u.roleId.roleName}</td>
                        <td><a href="allusers?userid=${u.userId}&action=delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </body>
</html>
