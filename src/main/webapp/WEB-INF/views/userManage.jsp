
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>UserManage</title>
    <link href="<c:url value='/static/css/index.css' />" rel="stylesheet">
    <script src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"/>"></script>
    <script src="<c:url value="/static/js/admin.js"/>"
            type="text/javascript"></script>


</head>
<body onload="getActive()">


<form id="putUser" action="javascript:void(null);" onsubmit="putUser()">
    <input type="text" id="name" name="userName" placeholder="Введите имя" required>
    <input type="text" id="userId" name="id" placeholder="Введите пин" step="1" required pattern="[0-9]{4}">
    <select id="roles" name="roles">
        <option disabled>Введите роль</option>
        <option value="ADMIN">Сис.админ</option>
        <option value="COMMANDER">Руководитель</option>
        <option value="LOGISTIC">Кладовщик</option>
        <option value="VENDOR">Продавец</option>
    </select>
    <input type="hidden" id="active" name="active" value="true">
    <input type="submit" class="btn" value="Добавить пользователя">

</form>




<div class="showUserDiv">
    <form id="showUser"></form>

</div>

<table id="userT">
    <thead>
    <tr>
        <td>id</td>
        <td>Имя</td>
        <td>Роль</td>
        <td>Действие</td>
    </tr>
    </thead>
</table>

</body>
</html>
