<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Improve</title>
    <style rel="stylesheet" type="text/css">
        <%@ include file="style.css" %>
    </style>
</head>
<b>Прайс-лист</b>
<form action="" method="POST">
    <%@ include file="inputs.jsp" %>
    <c:choose>
        <c:when test="${alert !=null}">
            <p name="alertMessage" id="alert">${alert}</p>
        </c:when>
        <c:otherwise>
            <%@ include file="result_table.jsp" %>
        </c:otherwise>
    </c:choose>
</form>
</body>
</html>
