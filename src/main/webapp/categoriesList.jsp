<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.humanDev.entities.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Doc</title>
</head>
<body>

    <c:if test="${not empty categoria}">
        Category ${ categoria } created successfully !!!
    </c:if>

    <ul>
        <c:forEach items="${categories}" var="categoria">
            <li>Id = ${categoria.id}</li>
            <li>Name = ${categoria.name}</li>
            <li>Code = ${categoria.code}</li>
            <li>Icon = ${categoria.icon}</li>
            <li>Description = ${categoria.categoryDescription}</li>
            <li>Active = ${categoria.active}</li>
            <li>Color = ${categoria.hexaColor}</li>

            <a href="/getCategory?id=${ categoria.id }">edit</a>
        </c:forEach>
    </ul>

</body>
</html>