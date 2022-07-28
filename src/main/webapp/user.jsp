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
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div>
    <h1>Manage User</h1>
    <form action="UserController" method="post">
        <input type="hidden" name="userId" value="${userBean.userId}">
        <div>
            <label class="label">FirstName :</label>
           <div><input type="text" name="firstName" class="text" value="${userBean.firstName}" size="30"></div>
        </div>
        <div>
            <label class="label">LastName : </label>
            <div><input type="text" name="lastName" class="text" value="${userBean.lastName}" size="30"></div>
        </div>
        <div>
            <label class="label">E-Mail : </label>
            <div><input type="text" name="emailId" class="text" value="${userBean.emailId}" size="30"></div>
        </div>
        <div>
            <label class="label">Mobile : </label>
            <div><input type="text" name="mobile" class="text" value="${userBean.mobile}" size="30"></div>
        </div>
        <div>
            <label class="label">UserName : </label>
            <div><input type="text" name="userName" class="text" value="${userBean.userName}" size="30"></div>
        </div>
        <div>
            <label class="label">Password : </label>
            <div><input type="password" name="password" class="text" value="${userBean.password}" size="30"></div>
        </div>
        <div>&nbsp;</div>
        <div>
            <input type="submit" value="Submit" class="butStnd">
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
            <c:forEach items="${userList}" var="userBean" varStatus="user">
                <tr class="${user.count % 2 == 0 ? 'even':'odd'}">
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
                        <a href="UserController?action=delete&userId=${userBean.userId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
