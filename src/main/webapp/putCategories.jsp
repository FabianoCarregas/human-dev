<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>postcategory.jsp
<c:url value="/alterarCategoria" var="linkServletPostCategory"/>"

<!doctype html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Doc</title>
</head>
<body>

    <form action="${linkServletPostCategory}" method="post">

        Name: <input type="text" name="name" value="${ category.name }">     </br>
        Code: <input type="text" name="code" value="${ category.code }"> </br>
        order: <input type="number" name="ordination" value="${ category.ordination }"> </br>
        Description: <input type="text" name="categoryDescription" value="${ category.categoryDescription }"> </br>
        Active : <input type="text" name="active" value="${ category.active }"> </br>
        icon: <input type="text" name="icon" value="${ category.icon }"> </br>
        color: <input type="text" name="hexaColor" value="${ category.hexaColor }"> </br>
        <input type="hidden" name="id" value="${ category.id }">
        <input type="submit">
    </br>
    </form>
</body>
</html>