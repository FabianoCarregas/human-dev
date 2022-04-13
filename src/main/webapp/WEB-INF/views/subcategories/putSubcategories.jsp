<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title >Doc</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
    <div class="container" >
        <div class="row">
            <h1>Editar subcategoria</h1>
        </div>
        <form action="/admin/subcategories/${subcategory.category.code}/${subcategory.code}" method="post" class="form-post">
            <input type="hidden" name="id" value="${subcategory.id}">
            <div class="row">
                <label class="form-label">Nome</label>
                <input name="name" type="text" class="form-control" value="${subcategoryFormDto.name }">
                <form:errors path="subcategoryFormDto.name" cssClass="alert-danger"/>
            </div>
            <div class="row">
                <label class="form-label" >Código</label>
                <input name="code" type="text" class="form-control" value="${ subcategoryFormDto.code }">
                <form:errors path="subcategoryFormDto.code" cssClass="alert-danger"/>
            </div>
            <div class="form-group row">
                <input type="checkbox" class="form-check-input" name="active" ${subcategoryFormDto.active ? 'checked' : ''}>
                    <label class="form-check-label" class="form-label">
                       Categoria Ativa?
                       <span class="text-muted check-helper">
                           Mostra ou deixa de mostrar a categoria na listagem dos alunos, de formações. etc
                       </span>
                    </label>
            </div>
            <div class="row">
                <label class="form-label">Ordem da categoria</label>
                <input name="ordination" type="text" class="form-control" value="${ subcategoryFormDto.ordination }">
                <form:errors path="subcategoryFormDto.ordination" cssClass="alert-danger"/>
            </div>
            <div class="row" >
                <label>Guia de estudos</label>
                <textarea class="form-control" name="studyGuide" rows="6" value="${ subcategoryFormDto.studyGuide }"></textarea>
            </div>
            <div class="row">
                <label class="form-label">Descrição</label>
                <input name="subcategoryDescription" type="text" class="form-control" value="${ subcategoryFormDto.subcategoryDescription }">
            </div>
            <div class="row">
                <label class="form-label">Categorias</label>
                <select class="form-control" name="categoryId" >
                    <c:forEach items="${category}" var="categoria">
                        <option value="${categoria.id}">${categoria.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="row" >
            <button type="submit" class="btn btn-success" >Salvar</button>
            </div>
        </form>
    </div>
</body>
</html>