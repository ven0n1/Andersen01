<%--
  Created by IntelliJ IDEA.
  User: ven0n
  Date: 12.02.2022
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
            <form action="<%=request.getContextPath()%>/update" method="post">
                </c:if>
            <c:if test="${user == null}">
            <form action="<%=request.getContextPath()%>/insert" method="post">
                </c:if>

                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

<%--                    <c:if test="${user != null}">--%>
<%--                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />--%>
<%--                    </c:if>--%>
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />

                    <fieldset class="form-group">
                        <label>User Surname</label> <input type="text" value="<c:out value='${user.surname}' />" class="form-control" name="surname" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User Name</label> <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User Age</label> <input type="number" value="<c:out value='${user.age}' />" class="form-control" name="age" required="required">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
