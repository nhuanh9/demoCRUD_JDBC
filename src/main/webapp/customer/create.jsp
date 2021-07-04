<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 7/3/21
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customers" method="post">
    <input type="hidden" name="action" value="create">
    <input type="text" name="id">
    <input type="text" name="name">
    <input type="text" name="age">
    <button>Create</button>
</form>
</body>
</html>
