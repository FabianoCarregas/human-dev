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
    <h1>Categories List</h1>
    <ul>
        <c:forEach items="${categories}" var="cat">
            <h3>categorie</h3>
            <li>${cat.name}</li>
            <li>${cat.code}</li>
            <li>${cat.icon}</li>
            <li>${cat.categoryDescription}</li>
            <li>${cat.hexaColor}</li>
            <h1>--------------------------------------------------------------------</h1>
        </c:forEach>
    </ul>
</body>
</html>