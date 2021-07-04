<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 7/4/21
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customers" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="text" name="id" value="${customer.idCus}">
    <input type="text" name="name" value="${customer.name}">
    <input type="text" name="age" value="${customer.age}">
    <button>Edit</button>
</form>
<form action="/customers" method="post">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="${customer.idCus}">
    <button>Delete</button>
</form>
</body>
</html>