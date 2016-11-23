<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>LocalManage</title>
    <link href="/static/css/local/local.css" rel="stylesheet">
    <script src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"/>"></script>
    <script src="/static/js/plugins/jquery.cookie.js"></script>
    <script src="/static/js/locals/local.js"></script>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>Место</th>
        <th>Действие</th>
     <%--   <th>удалить</th>--%>
    </tr>
    </thead>
    <c:forEach items="${locals}" var="local">

        <jsp:useBean id="local" scope="page" type="ru.inbox.savinov_vu.model.local.LocalStorage"/>
        <tr>
        <form method="get" action="/deleteLocal">
            <td><input name="localId" value="${local.localId}" readonly></td>
            <td><input type="text" name="localName" class="localName-${local.localId}" value="${local.localName}" readonly> </td>
            <td>
                <div>
                <input type="button" class="btn selectButton" onclick="setLocal(${local.localId})" value="Выбрать">

                <input type="submit" class="btn deleteButton"  value="Удалить">
                </div>
        </td>
        </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
