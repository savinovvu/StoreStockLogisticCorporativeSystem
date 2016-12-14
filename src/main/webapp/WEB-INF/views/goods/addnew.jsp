<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавить заказ</title>
    <link rel="stylesheet" href="../../../static/util/lustran/css/style.css">
    <link rel="stylesheet" href="../../../static/css/util/hidden.css">

    <script src="../../../static/util/lustran/js/jquery-3.1.1.min.js"></script>
    <script src="../../../static/util/lustran/vendor/bootstrap/assets/javascripts/bootstrap.min.js"></script>
    <script src="../../../static/util/lustran/vendor/Inputmask-3.x/dist/jquery.inputmask.bundle.js"></script>
    <script src="../../../static/util/lustran/js/main.js"></script>
    <script src="../../../static/js/util/navigation.js"></script>
    <script src="/static/js/plugins/jquery.cookie.js"></script>
    <script src="../../../static/js/goods/addnew.js"></script>

</head>
<body onload="updatePage()">
<div class="lustran-page">
    <nav class="lustran-nav">
        <a href="#" onclick="getNavigation('addNewNav')" class="lustran-nav-item"><i class="fa fa-plus-circle"
                                                                                     aria-hidden="true"></i>Добавить
            заказ</a>

        <div class="displayNone">
            <form action="addOrder" method="get">
                <input id="addNewNav" class="btn btn-primary" class="btn" type="submit" name="viewAllUsers">
            </form>
        </div>


        <a href="#" onclick="getNavigation('indexNav')" class="lustran-nav-item"><i class="fa fa-list-alt"
                                                                                    aria-hidden="true"></i>Заказы и
            товары</a>

        <div class="displayNone">
            <form action="editOrder" method="get">
                <input id="indexNav" class="btn btn-primary" class="btn" type="submit" name="viewAllUsers">
            </form>
        </div>


        <a href="#" onclick="getNavigation('checkInNav')" class="lustran-nav-item"><i class="fa fa-user-plus"
                                                                                      aria-hidden="true"></i>Отметиться</a>

        <div class="displayNone">
            <form action="checkUser" method="get">
                <input id="checkInNav" class="btn btn-primary" class="btn" type="submit" name="viewAllUsers">
            </form>
        </div>

    </nav>
    <main class="lustran-main">
        <%--<nav class="navbar lustran-navbar navbar-static-top">--%>
        <%--<div class="lustran-container-nav">--%>
        <%--	<div class="collapse navbar-collapse">--%>
        <%--<ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle lustran-dropdown" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Фильтр&nbsp<span class="caret"></span></a>--%>
        <%--<ul class="dropdown-menu lustran-dropdown-menu">
          <li><a href="#">ID заказа</a></li>
          <li><a href="#">Наименование</a></li>
          <li><a href="#">Артикул</a></li>
          <li><a href="#">Ориентировочная дата</a></li>
        </ul>
      </li>
      <li class="status-menu">
        <a href="#" class="lustran-dropdown" role="button">Выберите статус&nbsp<span class="caret"></span></a>
        <div class="status-menu-dropdown">
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Обработан</button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Обработан</a></li>
                    <li><a href="#">Не обработан</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Заказан</button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <li><a href="#">Заказан</a></li>
                    <li><a href="#">Не заказан</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Проверен и отложен</button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                    <li><a href="#">Проверен и отложен</a></li>
                    <li><a href="#">Отсутствует</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Звонили</button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
                    <li><a href="#">Звонили</a></li>
                    <li><a href="#">Не звонили</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Выдан</button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu5">
                    <li><a href="#">Выдан</a></li>
                    <li><a href="#">Не выдан</a></li>
                </ul>
            </div>
            <div class="status-menu-check">
                <input type="checkbox">
                <label>Уточнить дату</label>
                <input type="checkbox">
                <label>Ориентировочная</label>
                <input type="checkbox">
                <label>Уточненная</label>
            </div>
        </div>
      </li>
 </ul>--%>
        <%--  		<form class="navbar-form navbar-left lustran-search-form">
                      <div class="form-group">
                          <input type="text" class="form-control" placeholder="Поиск...">
                      </div>
                  </form>--%>
        <%--<ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">Заказов всего <span class="badge badge-pur-light">1</span></li>
            <li class="navbar-text">В обработке <span class="badge badge-pur-light">2</span></li>
            <li class="navbar-text">Выдано <span class="badge badge-pur-light">6</span></li>
            <li class="navbar-text">Дефект <span class="badge badge-pur-light">0</span></li>
        </ul>--%>
        <%-- 	</div>--%>
        <%--	</div>--%>


        <%--</nav>--%>
        <div class="lustran-container">
            <div class="new-order-wrapper">
                <h2>Добавление нового заказа</h2>
                <div class="new-order">
                    <div class="new-order-header">
                        <div class="new-order-info">
                            <%--	<div class="new-order-info-row">ID заказа&nbsp<span class="new-order-id">0001</span>&nbspот&nbsp<span class="new-order-date">12.12.16</span></div>--%>
                            <div class="new-order-info-row addSpan" ><span class="new-order-shop delSpan">Название магазина</span></div>
                            <div class="new-order-info-row"><span class="new-order-person">ФИО сотрудника</span></div>
                            <%--<div class="new-order-info-row">Порядковый номер&nbsp<span class="new-order-iter">1</span></div>--%>
                        </div>
                        <%--	<div class="new-order-barcode" style="background-image: url(../../../static/util/lustran/img/shtrihcod.png);"></div>--%>
                    </div>
                    <div class="new-order-body">




                        <%----------------------------------This Form-------------------------------%>

                        <form id="serializedForm" action="" class="new-order-form" name="form">
                            <div class="new-order-form-row row">
                                <fieldset class="col-sm-2">
                                    <label for="">Артикул</label>
                                    <input name="vendorCode" type="text" class="form-control" value="123">
                                </fieldset>
                                <fieldset class="col-sm-3">
                                    <label for="">Наименование товара</label>
                                    <input name="product_name" type="text" class="form-control" value="Товар">
                                </fieldset>
                                <fieldset class="col-sm-2">
                                    <label for="">Количество товара</label>
                                    <input name="countProducts" type="text" value="1" class="form-control"
                                           data-input="number">
                                </fieldset>
                                <fieldset class="col-sm-2">
                                    <label for="">Ориентировочная дата поставки</label>
                                    <input name="deliveryProductDate" type="text" class="form-control" value=""
                                           data-input="date">
                                </fieldset>
                                <fieldset class="col-sm-1">
                                    <label for="">Предоплата</label>
                                    <input name="prepayment" type="text" class="form-control" value=""
                                           data-input="number">
                                </fieldset>
                                <div class="new-row add" data-toggle="add-row"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbspДобавить товар</div>
                            </div>
                            <div class="new-order-form-row bottom row">
                                <div class="col-sm-4">
                                    <fieldset>
                                        <label for="">ФИО заказчика<span>*</span></label>
                                        <input name="customerName" type="text" class="form-control" required>
                                    </fieldset>
                                    <fieldset>
                                        <label for="">Телефон заказчика<span>*</span></label>
                                        <input name="customerPhone" type="text" class="form-control" data-input="phone"
                                               required>
                                    </fieldset>
                                </div>
                                <fieldset class="col-sm-6 col-sm-offset-1">
                                    <label for="">Комментарий</label>
                                    <textarea name="orderComment" id="" cols="30" rows="5"
                                              class="form-control"></textarea>
                                </fieldset>
                            </div>
                            <div class="btn-wrapper">
                                <input name="button" type="submit" onclick="sendForm()" class="btn btn-success btn-lg"
                                       value="Сохранить и распечатать">
                             <%--   <button type="submit" name="save">Сохранить</button>--%>
                            </div>
                        </form>

                            <%----------------------------------This Form-------------------------------%>




                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>