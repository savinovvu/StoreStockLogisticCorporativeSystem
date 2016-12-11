<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Управление заказами</title>
    <link rel="stylesheet" href="../../../static/util/lustran/vendor/perfect-scrollbar/css/perfect-scrollbar.min.css">
    <link rel="stylesheet" href="../../../static/util/lustran/css/style.css">
    <link rel="stylesheet" href="../../../static/css/util/hidden.css">
    <link rel="stylesheet" href="../../../static/css/goods/goods.css">
    <script src="../../../static/util/lustran/js/jquery-3.1.1.min.js"></script>
    <script src="../../../static/util/lustran/vendor/bootstrap/assets/javascripts/bootstrap.min.js"></script>
    <script src="../../../static/util/lustran/vendor/Inputmask-3.x/dist/jquery.inputmask.bundle.js"></script>
    <script src="../../../static/util/lustran/vendor/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js"></script>
    <script src="../../../static/util/lustran/js/main.js"></script>
    <script src="../../../static/js/util/navigation.js"></script>
    <script src="../../../static/js/goods/order.js"></script>

</head>
<body onload="getActive()" >
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


        <a href="#" onclick="getNavigation('indexNav')" class="lustran-nav-item"><i class="fa fa-list-alt" aria-hidden="true"></i>Заказы и
            товары</a>

        <div class="displayNone">
            <form action="editOrder" method="get">
                <input id="indexNav" class="btn btn-primary" class="btn" type="submit" name="viewAllUsers">
            </form>
        </div>


        <a href="#" onclick="getNavigation('checkInNav')"  class="lustran-nav-item"><i class="fa fa-user-plus" aria-hidden="true"></i>Отметиться</a>

        <div class="displayNone">
            <form action="checkUser" method="get">
                <input id="checkInNav" class="btn btn-primary" class="btn" type="submit" name="viewAllUsers">
            </form>
        </div>



    </nav>
    <main class="lustran-main">
        <nav class="navbar lustran-navbar navbar-static-top">
            <div class="lustran-container-nav">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle lustran-dropdown" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Фильтр&nbsp<span class="caret"></span></a>
                            <ul class="dropdown-menu lustran-dropdown-menu">
                                <li><a href="#">ID заказа</a></li>
                                <li><a href="#">Наименование</a></li>
                                <li><a href="#">Артикул</a></li>
                                <li><a href="#">Ориентировочная дата</a></li>
                            </ul>
                        </li>

                        <li class="status-menu">
                            <a href="#" class="lustran-dropdown" role="button">Выберите статус&nbsp<span
                                    class="caret"></span></a>
                            <div class="status-menu-dropdown">
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle lustran-drop" type="button"
                                            id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="true">Обработан
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li><a href="#">Обработан</a></li>
                                        <li><a href="#">Не обработан</a></li>
                                    </ul>
                                </div>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle lustran-drop" type="button"
                                            id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="true">Заказан
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                        <li><a href="#">Заказан</a></li>
                                        <li><a href="#">Не заказан</a></li>
                                    </ul>
                                </div>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle lustran-drop" type="button"
                                            id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="true">Отложен
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                                        <li><a href="#">Отложен</a></li>
                                        <li><a href="#">Отсутствует</a></li>
                                    </ul>
                                </div>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle lustran-drop" type="button"
                                            id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="true">Звонили
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
                                        <li><a href="#">Звонили</a></li>
                                        <li><a href="#">Не звонили</a></li>
                                    </ul>
                                </div>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle lustran-drop" type="button"
                                            id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="true">Выдан
                                    </button>
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
                    </ul>
                    <form class="navbar-form navbar-left lustran-search-form">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Поиск...">
                        </div>
                    </form>
                    <ul class="nav navbar-nav navbar-right myAddTop">
                        <li class="navbar-text del">Заказов всего <span class="badge badge-pur-light">1</span></li>
                        <li class="navbar-text del">В обработке <span class="badge badge-pur-light">2</span></li>
                        <li class="navbar-text del">Выдано <span class="badge badge-pur-light">6</span></li>
                        <li class="navbar-text del">Дефект <span class="badge badge-pur-light">0</span></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="lustran-container">
            <!-- Заказ -->
            <article class="order">
                <header class="order-header">
                    <div class="order-id">заказ<span>0001</span></div>
                    <div class="order-basket">13</div>
                    <a href="#order-add" class="btn btn-sm order-add"><i class="fa fa-plus-circle"
                                                                         aria-hidden="true"></i></a>
                </header>
                <section class="order-body">
                    <ul class="order-list">
                        <li class="order-list-item status-removed"> <!-- удаленный заказ status-removed -->
                            <header class="order-list-item-header"><span class="badge badge-pur">1</span><span
                                    class="order-date sep-dot">11.12.16</span><span class="order-name sep-dot">Название товара</span><span
                                    class="order-count sep-dot"><i>1</i> шт</span><span class="order-float-date">16.12.16</span>
                                <a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a><a
                                        href="#" class="remove-order-status" data-toggle="remove-order"></a></header>
                            <div class="container-fluid">
                                <ul class="order-status-list row">
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Обработан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">12.12.16</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Заказан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Отложен</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Дозвон</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Выдан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <%--                      --%>

                        <li class="order-list-item">
                            <header class="order-list-item-header"><span class="badge badge-pur">2</span><span
                                    class="order-date sep-dot">11.12.16</span><span class="order-name sep-dot">Название товара</span><span
                                    class="order-count sep-dot"><i>1</i> шт</span><span class="order-float-date">16.12.16</span>
                                <a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a><a
                                        href="#" class="remove-order-status" data-toggle="remove-order"
                                        data-toggle="remove-order"></a></header>
                            <div class="container-fluid">
                                <ul class="order-status-list row">
                                    <li class="col-sm-2">
                                        <div class="order-status status-danger"> <!-- status-danger -->
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не обработан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null"> <!-- ждет обработки status-null -->
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">--.--.--</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Уточнить дату</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Заказан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body status-null">
                                                <div class="status-top"><span class="status">Отсутствует</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не звонили</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Выдан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
             <%--                      --%>

                        <li class="order-list-item">
                            <header class="order-list-item-header"><span class="badge badge-pur">3</span><span
                                    class="order-date sep-dot">11.12.16</span><span class="order-name sep-dot">Название товара</span><span
                                    class="order-count sep-dot"><i>1</i> шт</span><span class="order-float-date">16.12.16</span>
                                <a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a><a
                                        href="#" class="remove-order-status" data-toggle="remove-order"></a></header>
                            <div class="container-fluid">
                                <ul class="order-status-list row">
                                    <li class="col-sm-2">
                                        <div class="order-status"> <!-- status-danger -->
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status"> обработан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-danger">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">--.--.--</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Заказан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body status-null">
                                                <div class="status-top"><span class="status">Отсутствует</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не звонили</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Выдан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </section>
            </article>
            <!-- end Заказ -->
            <!-- Заказ -->
            <article class="order">
                <header class="order-header">
                    <div class="order-id">заказ<span>0002</span></div>
                    <div class="order-basket">13</div>
                    <a href="#order-add" class="btn btn-sm order-add"><i class="fa fa-plus-circle"
                                                                         aria-hidden="true"></i></a>
                </header>
                <section class="order-body">
                    <ul class="order-list">
                        <li class="order-list-item">
                            <header class="order-list-item-header"><span class="badge badge-pur">1</span><span
                                    class="order-date sep-dot">11.12.16</span><span class="order-name sep-dot">Название товара</span><span
                                    class="order-count sep-dot"><i>1</i> шт</span><span class="order-float-date">16.12.16</span>
                                <a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a><a
                                        href="#" class="remove-order-status" data-toggle="remove-order"></a></header>
                            <div class="container-fluid">
                                <ul class="order-status-list row">
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Обработан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">12.12.16</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Заказан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Отложен</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Дозвон</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Выдан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="order-list-item">
                            <header class="order-list-item-header"><span class="badge badge-pur">2</span><span
                                    class="order-date sep-dot">11.12.16</span><span class="order-name sep-dot">Название товара</span><span
                                    class="order-count sep-dot"><i>1</i> шт</span><span class="order-float-date">16.12.16</span>
                                <a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a><a
                                        href="#" class="remove-order-status" data-toggle="remove-order"></a></header>
                            <div class="container-fluid">
                                <ul class="order-status-list row">
                                    <li class="col-sm-2">
                                        <div class="order-status status-danger"> <!-- status-danger -->
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не обработан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null"> <!-- ждет обработки status-null -->
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">--.--.--</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Уточнить дату</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Заказан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body status-null">
                                                <div class="status-top"><span class="status">Отсутствует</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не звонили</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Выдан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="order-list-item">
                            <header class="order-list-item-header"><span class="badge badge-pur">3</span><span
                                    class="order-date sep-dot">11.12.16</span><span class="order-name sep-dot">Название товара</span><span
                                    class="order-count sep-dot"><i>1</i> шт</span><span class="order-float-date">16.12.16</span>
                                <a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a><a
                                        href="#" class="remove-order-status" data-toggle="remove-order"></a></header>
                            <div class="container-fluid">
                                <ul class="order-status-list row">
                                    <li class="col-sm-2">
                                        <div class="order-status"> <!-- status-danger -->
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status"> обработан</span><span
                                                        class="status-date">12.12.16</span></div>
                                                <div class="status-bottom"><span>Фамилия Имя Отчество</span></div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-danger">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">--.--.--</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Заказан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body status-null">
                                                <div class="status-top"><span class="status">Отсутствует</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не звонили</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                    <li class="col-sm-2">
                                        <div class="order-status status-null">
                                            <div class="order-status-body">
                                                <div class="status-top"><span class="status">Не Выдан</span><span
                                                        class="status-date"></span></div>
                                                <div class="status-bottom"><span class="edit">Изменить статус</span>
                                                </div>
                                            </div>
                                            <a href="#" class="order-status-edit"></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </section>
            </article>
            <!-- end Заказ -->
        </div>
    </main>
</div>
<div class="layout-dark">
    <div class="action">
        <div class="action-header">
            <div class="action-info">
                <div class="new-order-info-row"><span class="action-date">12.12.16</span>&nbsp<span class="action-time">12.12.16</span>
                </div>
                <div class="new-order-info-row">Изменения в заказе:&nbsp<span class="action-order">0001</span></div>
                <div class="new-order-info-row">Товар:&nbsp<span class="action-shop">Название товара</span></div>
                <i class="fa fa-times-circle close-action" aria-hidden="true" data-toggle="close-action"></i>
            </div>
        </div>
        <div class="action-body">
            <div class="form-group">
                <div class="row action-row">
                    <label for="" class="col-sm-12">Введите ваш пин-код</label>
                    <div class="col-sm-6">
                        <div class="input-group">
                            <input type="password" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-pin" type="button"><i class="fa fa-check-circle"
                                                                                 aria-hidden="true"></i></button>
								</span>
                        </div>
                    </div>
                    <div class="col-sm-6 auth">Авторизирован как
                        <div class="auth-like">Руководитель</div>
                    </div>
                </div>
                <div class="row action-row">
                    <div class="col-sm-12">
                        <div class="dropdown">
                            <button class="btn btn-default btn-block dropdown-toggle lustran-drop" type="button"
                                    id="actionDropdown" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="true">Заказан
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="actionDropdown">
                                <li><a href="#">Заказан</a></li>
                                <li><a href="#">Не заказан</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row action-row">
                    <div class="col-sm-6">
                        <button class="btn btn-cancel btn-block" type="button" data-toggle="cancel-action">Отмена
                        </button>
                    </div>
                    <div class="col-sm-6">
                        <button class="btn btn-done btn-block" type="button" data-toggle="save-action">Сохранить
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal-layout">
    <div class="modal-log">
        <div class="modal-log-header">
            <div class="log-info">
                <div class="new-order-info-row">Заказ:&nbsp<span class="log-order">0001</span></div>
                <div class="new-order-info-row">История действий товара:&nbsp<span
                        class="log-product">Название товара</span></div>
                <i class="fa fa-times-circle close-action" aria-hidden="true" data-toggle="close-action"></i>
            </div>
        </div>
        <div class="modal-log-body">
            <ul class="logs">
                <li class="log">
                    <div class="log-header">
                        <div class="log-info">
                            <div class="new-order-info-row"><span class="log-date">12.12.16</span>&nbsp<span
                                    class="log-time">12:00</span></div>
                            <div class="new-order-info-row"><span class="log-editor">Иванов Иван Иванович</span></div>
                            <i class="fa fa-times-circle close-action" aria-hidden="true"
                               data-toggle="close-action"></i>
                        </div>
                        <div class="log-status"><span class="log-status-start">Обработан</span>&nbsp<i
                                class="fa fa-long-arrow-right" aria-hidden="true"></i>&nbsp<span class="log-status-end">Отменен</span>
                        </div>
                    </div>
                    <div class="log-body">
                        <p class="log-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odit delectus nisi
                            quasi inventore harum quam asperiores tempora molestiae temporibus. Molestias?</p>
                    </div>
                </li>
                <li class="log">
                    <div class="log-header">
                        <div class="log-info">
                            <div class="new-order-info-row"><span class="log-date">12.12.16</span>&nbsp<span
                                    class="log-time">12:00</span></div>
                            <div class="new-order-info-row"><span class="log-editor">Иванов Иван Иванович</span></div>
                            <i class="fa fa-times-circle close-action" aria-hidden="true"
                               data-toggle="close-action"></i>
                        </div>
                        <div class="log-status"><span class="log-status-start">Обработан</span>&nbsp<i
                                class="fa fa-long-arrow-right" aria-hidden="true"></i>&nbsp<span class="log-status-end">Отменен</span>
                        </div>
                    </div>
                    <div class="log-body">
                        <p class="log-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odit delectus nisi
                            quasi inventore harum quam asperiores tempora molestiae temporibus. Molestias?</p>
                    </div>
                </li>
                <li class="log">
                    <div class="log-header">
                        <div class="log-info">
                            <div class="new-order-info-row"><span class="log-date">12.12.16</span>&nbsp<span
                                    class="log-time">12:00</span></div>
                            <div class="new-order-info-row"><span class="log-editor">Иванов Иван Иванович</span></div>
                            <i class="fa fa-times-circle close-action" aria-hidden="true"
                               data-toggle="close-action"></i>
                        </div>
                        <div class="log-status"><span class="log-status-start">Обработан</span>&nbsp<i
                                class="fa fa-long-arrow-right" aria-hidden="true"></i>&nbsp<span class="log-status-end">Отменен</span>
                        </div>
                    </div>
                    <div class="log-body">
                        <p class="log-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odit delectus nisi
                            quasi inventore harum quam asperiores tempora molestiae temporibus. Molestias?</p>
                    </div>
                </li>
                <li class="log">
                    <div class="log-header">
                        <div class="log-info">
                            <div class="new-order-info-row"><span class="log-date">12.12.16</span>&nbsp<span
                                    class="log-time">12:00</span></div>
                            <div class="new-order-info-row"><span class="log-editor">Иванов Иван Иванович</span></div>
                            <i class="fa fa-times-circle close-action" aria-hidden="true"
                               data-toggle="close-action"></i>
                        </div>
                        <div class="log-status"><span class="log-status-start">Обработан</span>&nbsp<i
                                class="fa fa-long-arrow-right" aria-hidden="true"></i>&nbsp<span class="log-status-end">Отменен</span>
                        </div>
                    </div>
                    <div class="log-body">
                        <p class="log-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odit delectus nisi
                            quasi inventore harum quam asperiores tempora molestiae temporibus. Molestias?</p>
                    </div>
                </li>
                <li class="log">
                    <div class="log-header">
                        <div class="log-info">
                            <div class="new-order-info-row"><span class="log-date">12.12.16</span>&nbsp<span
                                    class="log-time">12:00</span></div>
                            <div class="new-order-info-row"><span class="log-editor">Иванов Иван Иванович</span></div>
                            <i class="fa fa-times-circle close-action" aria-hidden="true"
                               data-toggle="close-action"></i>
                        </div>
                        <div class="log-status"><span class="log-status-start">Обработан</span>&nbsp<i
                                class="fa fa-long-arrow-right" aria-hidden="true"></i>&nbsp<span class="log-status-end">Отменен</span>
                        </div>
                    </div>
                    <div class="log-body">
                        <p class="log-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odit delectus nisi
                            quasi inventore harum quam asperiores tempora molestiae temporibus. Molestias?</p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="modal-log-footer">
            <div class="form-group">
                <div class="row action-row" style="width:300px">
                    <label for="" class="col-sm-12">Введите ваш пин-код</label>
                    <div class="col-sm-6">
                        <div class="input-group">
                            <input type="password" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-pin" type="button"><i class="fa fa-check-circle"
                                                                                 aria-hidden="true"></i></button>
								</span>
                        </div>
                    </div>
                    <div class="col-sm-6 auth">Авторизирован как
                        <div class="auth-like">Руководитель</div>
                    </div>
                </div>
                <div class="row action-row">
                    <div class="col-sm-12">
                        <label for="">Комментарий</label>
                        <textarea name="" id="" cols="30" rows="6" class="form-control"></textarea>
                    </div>
                </div>
                <div class="row action-row">
                    <div class="col-sm-2 col-sm-offset-4">
                        <button class="btn btn-cancel btn-block" type="button" data-toggle="cancel-log">Отмена</button>
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-done btn-block" type="button" data-toggle="save-log">Сохранить</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>