<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.humanDev.entities.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 6px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
    <meta charset="ISO-8859-1">
</head>
<body>
    <header>
        <div>
            <h1>Categorias</h1>
        </div>
    </header>
    <div>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Code</th>
            <th >Icon</th>
            <th>Description</th>
            <th>Active</th>
            <th>Color</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${categories}" var="categoria">
        <tr>
            <td>${categoria.id}</td>
            <td>${categoria.name}</td>
            <td>${categoria.code}</td>
            <td>${categoria.icon}</td>
            <td>${categoria.categoryDescription}</td>
            <td id="active-${categoria.id}">${categoria.active}</td>
            <td>${categoria.hexaColor}</td>

            <td><button onclick ="statusChange(${categoria.id})">changeStatus</button></td>
            <td><a href="/getCategory?id=${ categoria.id }"><button>EDIT</button></a></td>
            </c:forEach>
        </tr>
        <td><a href="/criarCategoria"><button>Add Category</button></a></td>
    </table>
    </div>
    <script src="scripts.js">
    </script>
</body>
</html>