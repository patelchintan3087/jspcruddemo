<%--
  Created by IntelliJ IDEA.
  User: chintanpatel
  Date: 28/07/22
  Time: 4:49 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<div>
    <h1>Manage User</h1>
    <form action="UserController" method="post">
        <input type="hidden" name="userId" value="${userBean.userId}">
        <div>
            <label>FirstName </label>
            <input type="text" name="firstName" value="${userBean.firstName}" size="30">
        </div>
        <div>
            <label>LastName </label>
            <input type="text" name="lastName" value="${userBean.lastName}" size="30">
        </div>
        <div>
            <label>E-Mail </label>
            <input type="text" name="emailId" value="${userBean.emailId}" size="30">
        </div>
        <div>
            <label>Mobile </label>
            <input type="text" name="mobile" value="${userBean.mobile}" size="30">
        </div>
        <div>
            <label>UserName </label>
            <input type="text" name="userName" value="${userBean.userName}" size="30">
        </div>
        <div>
            <label>Password </label>
            <input type="password" name="password" value="${userBean.password}" size="30">
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
<div>
    <c:if test="${!empty userList}">
        <table>
            <tr>
                <th>&nbsp;</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>E-Mail</th>
                <th>Mobile</th>
                <th>UserName</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${userList}" var="userBean">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${userBean.firstName}</td>
                    <td>${userBean.lastName}</td>
                    <td>${userBean.emailId}</td>
                    <td>${userBean.mobile}</td>
                    <td>${userBean.userName}</td>
                    <td>${userBean.password}</td>
                    <td>
                        <a href="UserController?action=edit&userId=${userBean.userId}">Edit</a>
                        &nbsp;|&nbsp;
                        <a href="UserController?action=delete&userI=${userBean.userId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
