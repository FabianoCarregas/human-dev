<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Doc</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<style>
    *{
        font-size: 16px;
    }
</style>

<body>

<div style="padding: 0" class="container">
    <h1 style="font-family: 'DejaVu Sans' ">Categorias</h1>
    <a href="/admin/categories/new">
        <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-lg">Nova categoria</button>
    </a>
    <div >
        <table class="table table-bordered table-responsive">
            <thead>
            <tr class="col-">
                <th>Nome</th>
                <th>Código</th>
                <th>Status</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="categoria">
                <tr>
                    <td>${categoria.name}</td>
                    <td>${categoria.code}</td>
                    <td>${categoria.active}</td>
                    <td class="text-center"><a href="subcategories/&{categoria.code}">
                        <button type="button" class="btn btn-link" style="font-size: large">Subcategorias</button></a>
                    <td class="text-center">
                        <a class="btn btn-default" role="button" href="/admin/categories/${ categoria.code }">
                        Editar
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>