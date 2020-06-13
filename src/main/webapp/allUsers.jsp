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
        <h1>Welcome ${loggedUser.username}</h1>
        <h3>Table of All Users</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Role Name</th>
                        <c:if test="${loggedUser.roleId.roleId == 1}">
                        <th>Delete</th>
                        </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${usersAll}" var="u">
                    <tr>
                        <td>${u.userId}</td>
                        <td>${u.username}</td>
                        <td>${u.roleId.roleName}</td>
                        <c:if test="${loggedUser.roleId.roleId == 1}">
                            <td><a href="allusers?userid=${u.userId}&action=delete">Delete</a></td>
                            <!--alternative way-->
                            <!-- <td>
                            <form action="allusers" method="post">
                            <input type="hidden" name="userid" value="${u.userId}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <input type="submit" value="delete"/>
                            </form>
                            </td> -->
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
