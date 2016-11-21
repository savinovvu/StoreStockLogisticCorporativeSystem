<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>LocalManage</title>
 <%--   <link href="<c:url value='/static/css/index.css' />" rel="stylesheet">--%>
    <link href="<c:url value='/static/css/local.css' />" rel="stylesheet">

</head>
<body>
<table class="table table-striped display" id="datatable">
    <thead>
    <tr>
        <th>id</th>
        <th>Место</th>
        <th>Действие</th>
    </tr>
    </thead>
    <c:forEach items="${locals}" var="local">
        <jsp:useBean id="local" scope="page" type="ru.inbox.savinov_vu.model.local.LocalStorage"/>
        <td>${local.localId}</td>
        <td>${local.localName}</td>

        <td>
            <button class="btn" onclick="deletelocal()" value="удалить"></button>

        <br>
        <br>
        <br>

            <button class="btn" onclick="setlocal" value="установить"></button>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
