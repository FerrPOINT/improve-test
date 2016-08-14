<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table class="margin-up">
    <tr>
        <th>Категория</th>
        <th>Наименование</th>
        <th>Цена</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.category.name}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
