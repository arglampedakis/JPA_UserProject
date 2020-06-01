<%-- 
    Document   : insertuser
    Created on : Jun 1, 2020, 8:20:31 PM
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
        <hr>
        <br><br>
        <form align="center">
            Username: <input type="text" name="username"/>
            <br><br>
            <label for="role">Select Role</label>
            <select name="role">
                <c:forEach items="${roles}" var="r">
                    <option value="${r.roleId}">${r.roleName}</option>    
                </c:forEach>
            </select>
            <br><br>
            <input type="submit" value="Submit"/>
            <input type="reset" value="reset"/>
        </form>
        <br><br>
        <hr>
    </body>
</html>
