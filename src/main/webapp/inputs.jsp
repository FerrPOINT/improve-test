<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="left-float">
    <br>Категория:</br>
    <input type="text" name="category"
           value=<%=request.getParameter("category")==null? "": request.getParameter("category")%>>
</div>
<div class="left-float">
    <br>Наименование:</br>
    <input type="text" name="name"
           value=<%=request.getParameter("name")==null? "": request.getParameter("name")%>>
</div>
<div class="left-float">
    <br>Цена от:</br>
    <input type="number" step="0.01" name="priceFrom"
           value=<%=request.getParameter("priceFrom")==null? "": request.getParameter("priceFrom")%>>
</div>
<div>
    <br>Цена до:</br>
    <input type="number" step="0.01" name="priceTo"
           value=<%=request.getParameter("priceTo")==null? "": request.getParameter("priceTo")%>>
    <input type="submit" value="Отправить"/>
</div>
</body>
</html>
