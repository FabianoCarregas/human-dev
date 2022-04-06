<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Doc</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

    <div style="padding: 0" class="container">
        <h1 style="font-family: 'DejaVu Sans' ">Categorias</h1>
        <a href="/admin/categories/new">
            <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-lg">Nova categoria</button>
        </a>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr class="col">
                    <th>Nome</th>
                    <th>Código</th>
                    <th>Status</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="categoria">
                    <tr class="col">
                        <td>${categoria.name}</td>
                        <td>${categoria.code}</td>
                        <td>${categoria.active}</td>
                        <td><a href="subcategories/&{categoria.code}">
                            <button type="button" class="btn btn-link" style="text-align: center">Subcategory</button></a>
                        <td><a href="/admin/categories/${ categoria.code }">
                        <button type="button" class="btn btn-primary">EDIT</button></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>