<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title >Doc</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container" >
        <h1 style="font-family: 'DejaVu Sans' ">Editar categoria</h1>
        <form action="/admin/categories/${category.code}" method="post">
            <input type="hidden" name="id" value="${category.id}">
            <div class="mb-3">
                <label class="form-label">Nome</label>
                <input name="name" type="text" class="form-control" value="${ category.name }">
                <form:errors path="categoryFormDto.name" cssClass="alert-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label" >Código</label>
                <input name="code" type="text" class="form-control" value="${ category.code }">
                <form:errors path="categoryFormDto.code" cssClass="alert-danger"/>
            </div>
            <div class="form-group ">
                <div class="mb-3 form-check div-checkbox">
                    <input type="checkbox" class="form-check-input" name="active" value="${ category.active }">
                    <label class="form-check-label" class="form-label" >
                        <p class="active-category">Categoria Ativa? </p>
                    </label>
                    <p class="text-muted">
                        Mostre ou deixa de mostrar a categoria na listagem dos alunos, de formações, etc
                    </p>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Ordem da categoria</label>
                <input name="ordination" type="text" class="form-control" value="${ category.ordination }">
                <form:errors path="categoryFormDto.ordination" cssClass="alert-danger"/>
            </div>
            <div class="form-group" >
                <label>Guia de estudos</label>
                <textarea class="form-control" name="studyGuide" rows="6" value="${ category.studyGuide }"></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label" >Caminho do ícone</label>
                <input name="icon" type="text" class="form-control" value="${ category.icon }">
            </div>
            <div class="mb-3">
                <label class="form-label">Color</label>
                <input name="hexaColor" type="text" class="form-control" value="${ category.hexaColor }">
                <form:errors path="categoryFormDto.hexaColor" cssClass="alert-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Descrição</label>
                <input name="categoryDescription" type="text" class="form-control" ${ category.categoryDescription }>
            </div>
            <div class="mb-3" >
            <button type="submit" class="btn btn-success" >Salvar</button>
            </div>
        </form>
    </div>
</body>
</html>