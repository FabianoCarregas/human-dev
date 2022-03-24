<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.humanDev.entities.Category" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Doc</title>
</head>
<body>
    <h1>Categories List</h1>
    <ul>
        <%
            List<Category> caregoryList = (List<Category>)request.getAttribute("categories");
            for (Category c : caregoryList) {
        %>
        <h3>Category -></h3>
            <li><%= c.getName() %></li>
            <li><%= c.getCode() %></li>
            <li><%= c.getIcon() %></li>
            <li><%= c.getCategoryDescription() %></li>
            <li><%= c.getHexaColor() %></li>
        <h1>--------------------------------------------------------------------</h1>
        <%
            }
        %>
    </ul>
</body>
</html>