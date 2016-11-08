
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>StartManage</title>
    <link href="<c:url value='/static/css/index.css' />" rel="stylesheet">

</head>
<body>

<form action="/editUser" method="post">
    <input type="submit" name="viewAllUsers" value="Управление пользователями">
</form>

<form action="/editOrder" method="post">
    <input type="submit" name="viewAllUsers" value="Управление заказами">
</form>

<form action="/addOrder" method="post">
    <input type="submit" name="viewAllUsers" value="Добавить заказ">
</form>



</body>
</html>
