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
    <script src="<c:url value="/static/js/personal/admin.js"/>" type="text/javascript"></script>
    <script src="/static/js/plugins/jquery.min.js"></script>
    <script src="/static/js/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/util/util.js" type="text/javascript"></script>
</head>
<body onload="getActive()">
<%--<div class="container">
    <div class="alert alert-success hidden" id="success-alert">
        <div>Ваши данные были успешно отправлены.</div>
    </div>

</div>--%>


<div class="view-box">
    <div class="menu">

        <!-- Кнопка для открытия модального окна -->
        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="addBlock()">
            Добавить пользователя
        </button>



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
            <td></td>
        </tr>
        </thead>
    </table>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Заголовок модального окна -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title" id="myModalLabel">Добавление пользователя</h4>
            </div>
            <!-- Основная часть модального окна, содержащая форму для регистрации -->
            <div class="modal-body">
                <!-- Форма для регистрации -->
                <form role="form" class="form-horizontal">

                    <!-- Блок для ввода id -->
                    <div class="changeDivId">
                        <%--<div class="form-group" id="divId">--%>
                        <div class="form-group has-feedback" id="divId">
                            <label for="userId" class="control-label col-xs-3">id:</label>
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>


                                    <input type="text" class="form-control" id="userId" name="id" required
                                           pattern="[0-9]{4}">
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Блок для ввода ФИО -->

                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">ФИО:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="name" name="name" required/>
                            </div>

                        </div>
                    </div>
                    <!-- Конец блока для ввода ФИО-->


                    <%--Блок ввод Должности--%>
                    <div class="form-group has-feedback">
                        <label for="roles" class="control-label col-xs-3">Должность</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <select id="roles" class="form-control" name="roles" required>
                                    <option value="Продавец">Продавец</option>
                                    <option value="Снабженец">Снабженец</option>
                                    <option value="Руководитель">Руководитель</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- Конец блока для ввода Должности-->

                    <%--Признак активного пользователя--%>
                    <div class="form-group">
                        <input type="hidden" id="active" name="active" value="true">
                    </div>
                    <%--Конец признака активного пользователя--%>
                </form>
            </div>
            <!-- Нижняя часть модального окна -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                <button id="save" type="button" onclick="putUser()" class="btn btn-primary">Регистрация</button>
            </div>
        </div>
    </div>
</div>




<%--
<!-- Задний прозрачный фон-->
<div onclick="addBlock('none')" id="wrap"></div>

<!-- Само окно-->
<div id="window" class="window">

    &lt;%&ndash;method="post"&ndash;%&gt;
    <form:form class="form-horizontal" id="detailsForm">
        <div class="center">

            <div class="changeDivId">
                <div class="form-group" id="divId">
                    <label for="userId" class="control-label col-xs-3">id</label>

                    <div class="col-xs-9">
                        <input type="text" class="form-control" id="userId" name="id">
                    </div>
                </div>
            </div>



            <div class="form-group">
                <label for="name" class="control-label col-xs-3">ФИО</label>

                <div class="col-xs-9">
                    <input type="text" class="form-control" id="name" name="name" required/>
                </div>
            </div>



            <div class="form-group">
                <label for="roles" class="control-label col-xs-3">Должность</label>

                <div class="col-xs-9">
                    <select id="roles" class="form-control" name="roles">
                        <option disabled>Введите роль</option>
                        <option value="Руководитель">Руководитель</option>
                        <option value="Снабженец">Снабженец</option>
                        <option value="Продавец">Продавец</option>
                    </select>
                </div>
            </div>



            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <button class="btn btn-success" type="button" onclick="putUser()">Сохранить</button>
                    <button class="btn btn-danger" type="button" onclick="addBlock('none')">Отменить</button>
                </div>
            </div>
        </div>
    </form:form>
</div>--%>
</body>
</html>
