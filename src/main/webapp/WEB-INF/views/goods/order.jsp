<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>OrderManage</title>
    <link rel="stylesheet" href="/static/css/plugins/bootstrap.css">
    <link href="/static/css/goods/order.css" rel="stylesheet">
    <script src="/static/js/goods/order.js" type="text/javascript"></script>
    <script src="/static/js/plugins/jquery.min.js"></script>
    <script src="/static/js/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/util/util.js" type="text/javascript"></script>
</head>
<body>

<div class="view-box">
    <div class="menu">

        <!-- Кнопка для открытия модального окна -->
        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="addBlock()">
            Добавить Заказ
        </button>



        <div class="showUserDiv">
            <form id="showUser"></form>

        </div>
    </div>

    <table id="userT">

        <thead>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>group1</td>
            <td>group2</td>
            <td>group3</td>
            <td>group4</td>
            <td>group5</td>
        </tr>
        </thead>
    </table>
</div>















</body>
</html>
