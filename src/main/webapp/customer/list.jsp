<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 7/3/21
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="hidden" name="action" value="search">
    <input type="text" name="key">
    <button>Search</button>
</form>
<center>
    <h1>List Customer</h1>
    <a href="/customers?action=create">Create a Customer</a>
    <c:forEach items="${customers}" var="cus">
        <h3><a href="/customers?action=view&id=${cus.idCus}">${cus.name}</a> | ${cus.age}</h3>
    </c:forEach>
</center>
</body>
</html>
