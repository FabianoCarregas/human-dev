<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/alterarCategoria" var="linkServletPutCategory"/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Doc</title>
</head>
<body>

    <form action="${linkServletPutCategory}" method="post">

        <label for="name">Name:</label><br>
        <input id="name" type="text" name="name" value="${ category.name }">     </br>
        <label for="code">Code:</label><br>
        <input id="code" type="text" name="code" value="${ category.code }"> </br>
        <label for="order">order:</label><br>
        <input id="order" type="number" name="ordination" value="${ category.ordination }"> </br>
        <label for="description">description:</label><br>
        <input id="description" type="text" name="categoryDescription" value="${ category.categoryDescription }"> </br>
        <label for="status">status:</label><br>
        <input id="status" type="text" name="active" value="${ category.active }"> </br>
        <label for="icon">icon:</label><br>
        <input id="icon" type="text" name="icon" value="${ category.icon }"> </br>
        <label for="color">color:</label><br>
        <input id="color" type="text" name="hexaColor" value="${ category.hexaColor }"> </br>

        <input type="hidden" name="id" value="${ category.id }">
        <br>
        <input type="submit">
    </form>
</body>
</html>