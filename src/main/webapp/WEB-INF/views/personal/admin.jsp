<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>UserManage</title>
    <link rel="stylesheet" href="/static/css/plugins/bootstrap.css">
    <link href="/static/css/personal/admin.css" rel="stylesheet">
    <script src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"/>"></script>
    <script src="<c:url value="/static/js/personal/admin.js"/>" type="text/javascript"></script>
    <script src="/static/js/util/util.js" type="text/javascript"></script>

</head>
<body onload="getActive()">

<%--<form class="input-group" id="putUser" action="javascript:void(null);" onsubmit="putUser()">
    <input type="text" class="form-control"  id="userName" name="userName" placeholder="Введите имя" required>
    <input type="text" class="form-control" id="userId" name="id" placeholder="Введите пин" step="1" required pattern="[0-9]{4}">
    <select id="userRoles" class="form-control" name="roles">
        <option disabled>Введите роль</option>
        &lt;%&ndash;        <option value="ADMIN">Сис.админ</option>&ndash;%&gt;
        <option value="Руководитель">Руководитель</option>
        <option value="LOGISTIC">Кладовщик</option>
        <option value="VENDOR">Продавец</option>
    </select>
    <input type="hidden" id="active" name="active" value="true">
    <input type="submit" class="btn-success" value="Добавить/Редактировать по id">

</form>--%>
<div class="view-box">
    <div class="menu">
        <a class="btn btn-sm btn-info" onclick="addBlock('block')">добавить пользователя</a>

        <div class="showUserDiv">
            <form id="showUser"></form>

        </div>
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
</div>


<%--<div id="parent_popup">
<div id="popup">
    <p style="cursor: pointer;" onclick="document.getElementById('parent_popup').style.display='none';">Закрыть</p>
    <p>Текст в окне</p>
</div>
</div>--%>


<!-- Задний прозрачный фон-->
<div onclick="addBlock('none')" id="wrap"></div>

<!-- Само окно-->
<div id="window">

    <!-- Картинка крестика-->
    <p>чтото написано</p>

        <a href="http://sergey-oganesyan.ru/javascript-s-primerami/kak-sdelat-vsplyvayushee-okno.html" class="myButton">Вернуться
            к статье</a>
        <a class="myButton" href="http://sergey-oganesyan.ru/">sergey-oganesyan.ru</a>

</div>




<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Имя пользователя</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name"/>">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="roles" class="control-label col-xs-3">role</label>

                        <div class="col-xs-9">
                            <select id="roles" class="form-control" name="roles">
                                <option disabled>Введите роль</option>
                                    <%--        <option value="ADMIN">Сис.админ</option>--%>
                                <option value="Руководитель">Руководитель</option>
                                <option value="Кладовщик">Кладовщик</option>
                                <option value="Продавец">Продавец</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button class="btn btn-primary" type="button" onclick="putUser()">Сохранить</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
