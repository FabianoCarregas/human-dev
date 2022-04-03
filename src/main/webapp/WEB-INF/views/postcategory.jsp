<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Doc</title>
</head>
<body>

    <form action="postcat" method="post">
        <label for="name">Name:</label><br>
        <input id="name" type="text" name="name" value="${ category.name }">     </br>

        <label for="code">Code:</label><br>
        <input id="code" type="text" name="code" value="${ category.code }"> </br>

        <label for="description">description:</label><br>
        <input id="description" type="text" name="categoryDescription" value="${ category.categoryDescription }"> </br>

        <label for="studyGuide">description:</label><br>
        <input id="studyGuide" type="text" name="studyGuide" value="${ category.studyGuide }"> </br>

        <label for="active">Active Category </label>
        <input id="active" type="checkbox" name="active" value="true"> </br>

        <label for="order">order:</label><br>
        <input id="order" type="number" name="ordination" value="${ category.ordination }"> </br>

        <label for="icon">icon:</label><br>
        <input id="icon" type="text" name="icon" value="${ category.icon }"> </br>

        <label for="color">color:</label><br>
        <input id="color" type="text" name="hexaColor" value="${ category.hexaColor }"> </br>

        <input type="hidden" name="id" value="${ category.id }">
        <input type="submit">
    </form>
</body>
</html>