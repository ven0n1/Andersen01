<%--
  Created by IntelliJ IDEA.
  User: ven0n
  Date: 12.02.2022
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
    <div>
        <a href="<%=request.getContextPath()%>/new">Add New User</a>
    </div>
    <br>
    <table style="border-collapse: collapse; width: 100%;" border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>SurName</th>
                <th>Name</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${listUser}">

                <tr>
                    <td>
                        <c:out value="${user.id}" />
                    </td>
                    <td>
                        <c:out value="${user.surname}" />
                    </td>
                    <td>
                        <c:out value="${user.name}" />
                    </td>
                    <td>
                        <c:out value="${user.age}" />
                    </td>
                    <td><a href="edit?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
