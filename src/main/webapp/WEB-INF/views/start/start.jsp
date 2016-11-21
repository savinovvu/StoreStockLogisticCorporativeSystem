
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>StartManage</title>
    <link href="<c:url value='/static/css/start.css' />" rel="stylesheet">

</head>
<body>

<div class="menu">
<form action="/editUser" method="get">
    <input class="btn"  type="submit" name="viewAllUsers" value="Управление пользователями">
</form>

<form  action="/editOrder" method="get">
    <input class="btn"  class="btn" type="submit" name="viewAllUsers" value="Управление заказами">
</form>

<form action="/addOrder" method="get">
    <input class="btn" type="submit" name="viewAllUsers" value="Добавить заказ">
</form>

<form action="/editLocal" method="get">
    <input class="btn"  type="submit" name="viewAllUsers" value="Управление местом">
</form>
</div>


</body>
</html>
