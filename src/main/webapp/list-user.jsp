<%@ page import="com.example.andersen01.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ven0n
  Date: 12.02.2022
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
    <div>
<%--        <a href="<%=request.getContextPath()%>/new">Add New User</a>--%>
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
        <% List<User> users = (List<User>) request.getAttribute("listUser");%>
        <tbody>
            <%for (User user:users) {%>
                <tr>
                    <td>
                        <%=user.getId()%>
                    </td>
                    <td>
                        <%=user.getSurname()%>
                    </td>
                    <td>
                        <%=user.getName()%>
                    </td>
                    <td>
                        <%=user.getAge()%>
                    </td>
<%--                    <td><a href="edit?id=<%=user.getId()%>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<%=user.getId()%>">Delete</a></td>--%>
                </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
