<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Doc</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Categorias</h1>
    </div>
    <div class="row">
        <a class="btn btn-primary" role="button" href="/admin/categories/new"  >
            Nova categoria
        </a>
    </div>
    <div class="row" >
        <table class="table table-bordered table-responsive">
            <thead>
                <tr>
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
                        <td class="active${categoria.id} ">${categoria.active == true ? "Ativa" : "Inativa"} </td>
                        <td class="text-center">
                            <c:if test="${categoria.active}">
                                <button class="btn btn-default change-status " data-category-id="${categoria.id}">
                                    Desativar
                                </button>
                            </c:if >
                        </td>
                        <td class="text-center">
                            <a role="button" href="/admin/subcategories/${categoria.code}">
                                Subcategorias
                            </a>
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
<script src="../../../assets/js/jquery.js"></script>
<script src="../../../assets/js/scripts.js"></script>
</body>
</html>