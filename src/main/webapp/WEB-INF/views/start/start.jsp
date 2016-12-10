<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>StartManage</title>


    <link rel="stylesheet" href="/static/css/plugins/bootstrap.css">
    <link href="/static/css/start/start.css" rel="stylesheet">
</head>
<body>
<div class="parent">
<div class="menu">
    <form action="/editUser" method="get">
        <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Управление пользователями">
    </form>

    <form action="/editOrder" method="get">
        <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Управление заказами">
    </form>

<%--    <form action="/addOrder" method="get">
        <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Добавить заказ">
    </form>--%>

    <form action="/editLocal" method="get">
        <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Управление местом">
    </form>
</div>
</div>





</body>
</html>
