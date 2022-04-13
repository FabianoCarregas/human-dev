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
        <h3>${subcategory.name}</h3>
        <h1>Cursos</h1>
    </div>
    <div class="row">
        <a class="btn btn-primary" role="button"   >
            Novo curso
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
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ coursesPage.content }" var="curso">
                <tr>
                    <td>${curso.name}</td>
                    <td>${curso.code}</td>
                    <td>${curso.active == true ? "Ativa" : "Inativa"} </td>
                    <td class="text-center">
                        <button class="btn btn-default">
                            Editar
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="${coursesPage.first ? 'disabled' : ''}">
                    <a href="/admin/courses/${categorycode}/${subcategory.code}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${coursesPage.totalPages}" varStatus="status" >
                    <li ><a href="/admin/courses/${categorycode}/${subcategory.code}?page=${status.count}"> ${status.count} </a></li>
                </c:forEach>
                <li class="${coursesPage.last ? 'disabled' : ''}">
                    <a href="/admin/courses/${categorycode}/${subcategory.code}?page=${coursesPage.totalPages}"  aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script src="scripts.js">
</script>
</body>
</html>