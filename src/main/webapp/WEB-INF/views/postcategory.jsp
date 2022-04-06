<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Doc</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 style="font-family: 'DejaVu Sans' ">Nova categoria</h1>
        <form action="/admin/categories" method="post">
            <div class="mb-3">
                <label class="form-label">Nome</label>
                <input name="name" type="text" class="form-control" placeholder="Digite aqui o nome da categoria"
                <form:errors path="categoryFormDto.name" cssClass="alert-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label" >Codigo</label>
                <input name="code" type="text" class="form-control" placeholder="por exemplo: desenvolvimento, mobile(não use letras maiúsculas ou acentos...">
                <form:errors path="categoryFormDto.code" cssClass="alert-danger"/>
            </div>
            <div class="form-group ">
                <div class="mb-3 form-check div-checkbox">
                    <input type="checkbox" class="form-check-input" name="active" >
                    <label class="form-check-label" class="form-label" >
                        <p class="active-category">Categoria Ativa?</p>
                    </label>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Ordem da categoria</label>
                <input name="ordination" type="text" class="form-control" placeholder="por exemplo: categoria de ordem 1 aparece antes da categoria 2">
                <form:errors path="categoryFormDto.ordination" cssClass="alert-danger"/>
            </div>
            <div class="mm-3">
                <label>Guia de estudos</label>
                <textarea class="form-control" name="studyGuide" rows="6"
                          placeholder="Um texto apontando para formações para ajudar pessoas perdidas"></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Caminho do ícone</label>
                <input name="icon" type="text" class="form-control" placeholder="por exemplo: /images/categorias/programação.svg">
            </div>
            <div class="mb-3">
                <label class="form-label">cor</label>
                <input name="hexaColor" type="text" class="form-control" placeholder="por exemplo: #fcc14a">
                <form:errors path="categoryFormDto.hexaColor" cssClass="alert-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Descrição</label>
                <input name="categoryDescription" type="text" class="form-control" placeholder="por exemplo:IOS, Android, PhoneGap e mais...">
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-success">Enviar</button>
            </div>
        </form>
    </div>
</body>
</html>