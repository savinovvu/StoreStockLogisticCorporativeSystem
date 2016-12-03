<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>LocalManage</title>
    <script src="/static/js/plugins/jquery.min.js"></script>
    <link rel="stylesheet" href="/static/css/plugins/bootstrap.css">
    <script src="/static/js/plugins/bootstrap/bootstrap.min.js"></script>

    <link href="/static/css/local/local.css" rel="stylesheet">
    <script src="/static/js/plugins/jquery.cookie.js"></script>
    <script src="/static/js/locals/local.js"></script>
    <script src="/static/js/locals/localCookie.js"></script>
</head>
<body onload="getAll()">

<div class="view-box">
    <div class="menu">

        <!-- Кнопка для открытия модального окна -->
        <button type="button" onclick="addBlockAndNullinput()" class="btn btn-lg btn-success custombtn"
                data-toggle="modal"
                data-target="#myModal">
            Добавить Место
        </button>


        <div class="showUserDiv">
            <form id="showUser"></form>

        </div>
    </div>

    <table id="LocalT">

        <thead>
        <tr>
            <td>id</td>
            <td>Место</td>
            <td>Действие</td>
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
                <h4 class="modal-title" id="myModalLabel">Добавление места</h4>
            </div>
            <!-- Основная часть модального окна, содержащая форму для регистрации -->
            <div class="modal-body">
                <!-- Форма для регистрации -->
                <form role="form" class="form-horizontal">

                    <!-- Блок для ввода id -->

                    <div class="form-group">
                        <input type="hidden" class="form-control" id="localId" name="localId" required/>
                    </div>


                    <!-- Блок для ввода места -->

                    <div class="form-group has-feedback">
                        <label for="localName" class="control-label col-xs-3">Место:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="localName" name="localName" required/>
                            </div>

                        </div>
                    </div>
                    <!-- Конец блока для ввода места-->

            </div>
            </form>

            <!-- Нижняя часть модального окна -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
                <button id="save" type="button" onclick="putLocal()" class="btn btn-primary" data-dismiss="modal">
                    Готово
                </button>
            </div>
        </div>
    </div>
</div>
</div>


</body>
</html>

</table>
</body>
</html>
