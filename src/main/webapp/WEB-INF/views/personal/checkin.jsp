<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Отметиться</title>
	<link rel="stylesheet" href="../../../static/util/lustran/css/style.css">
	<link rel="stylesheet" href="../../../static/css/util/hidden.css">
	<script src="../../../static/util/lustran/js/jquery-3.1.1.min.js"></script>
	<script src="../../../static/util/lustran/vendor/bootstrap/assets/javascripts/bootstrap.min.js"></script>
	<script src="../../../static/util/lustran/vendor/Inputmask-3.x/dist/jquery.inputmask.bundle.js"></script>
	<script src="../../../static/util/lustran/js/main.js"></script>
	<script src="../../../static/js/util/navigation.js"></script>

</head>
<body>
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
			<div class="lustran-container">
				<div class="check-in-wrapper">
					<div class="check-in-inner">
						<!-- Ввести пин -->
						<div class="pin-wrapper">
							<h2>Отметка</h2>
							<div class="pin">
								<label for="">Введите свой пин-код</label>
								<div class="input-group">
								<input type="password" class="form-control">
									<span class="input-group-btn">
										<button class="btn btn-pin" type="button">ОК</button>
									</span>
								</div><!-- /input-group -->
							</div>
						</div>

						<!-- Приветствие -->
						<div class="wellcome-wrapper">
							<div class="wellcome">
								<i class="fa fa-smile-o" aria-hidden="true"></i>
								<div class="wellcome-top">Доброе&nbsp<span class="day-time">утро</span>,<br><span class="name">Иванов Иван Иванович</span></div>
								<div class="wellcome-bottom">Вы успешно отметились и можете приступать пользоваться системой.</div>
							</div>
						</div>

						<!-- Отметившиеся -->
						<div class="checking-in-wrapper">
							<h2>Отметившиеся</h2>
							<div class="checking-in">
								<div class="checking-in-body">
									<div class="checking-in-period">
										<div class="period-top">11 ноября, пятница</div>
										<ul class="checking-in-list">
											<li class="checking-in-list-item"><span class="checking-in-date">11.12.16</span>&nbsp<span class="checking-in-time sep-dot">11:20</span><span class="checking-in-location sep-dot">Юбилейный</span><span class="checking-in-person">Иванов Иван Иванович</span></li>
											<li class="checking-in-list-item"><span class="checking-in-date">11.12.16</span>&nbsp<span class="checking-in-time sep-dot">11:20</span><span class="checking-in-location sep-dot">Юбилейный</span><span class="checking-in-person">Иванов Иван Иванович</span></li>
											<!-- Опоздавший класс lateness -->
											<li class="checking-in-list-item lateness"><span class="checking-in-date">11.12.16</span>&nbsp<span class="checking-in-time sep-dot">11:20</span><span class="checking-in-location sep-dot">Юбилейный</span><span class="checking-in-person">Иванов Иван Иванович</span><span class="badge lateness">опоздание</span></li>
										</ul>
									</div>

									<div class="checking-in-period">
										<div class="period-top">16 ноября, четверг</div>
										<ul class="checking-in-list">
											<li class="checking-in-list-item"><span class="checking-in-date">11.12.16</span>&nbsp<span class="checking-in-time sep-dot">11:20</span><span class="checking-in-location sep-dot">Юбилейный</span><span class="checking-in-person">Иванов Иван Иванович</span></li>
											<li class="checking-in-list-item"><span class="checking-in-date">11.12.16</span>&nbsp<span class="checking-in-time sep-dot">11:20</span><span class="checking-in-location sep-dot">Юбилейный</span><span class="checking-in-person">Иванов Иван Иванович</span></li>
											<!-- Опоздавший класс lateness -->
											<li class="checking-in-list-item lateness"><span class="checking-in-date">11.12.16</span>&nbsp<span class="checking-in-time sep-dot">11:20</span><span class="checking-in-location sep-dot">Юбилейный</span><span class="checking-in-person">Иванов Иван Иванович</span><span class="badge lateness">опоздание</span></li>
										</ul>
									</div>
								</div>
								<div class="checking-in-footer">
									<form class="form-horizontal">
										<div class="form-group">
											<label for="" class="control-label">с</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" data-input="date">
											</div>
											<label for="" class="control-label">по</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" data-input="date">
											</div>
											<div class="col-sm-2">
												<button type="submit" class="btn btn-success">Показать</button>
											</div>
											<div class="col-sm-3">
												<label for="" class="control-label check"><input type="checkbox">&nbspТолько опоздания</label>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>	
				</div>
			</div>
		</main>
	</div>
</body>
</html>