<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
            <div class="mb-3" style="margin-top: 35px">
                <label class="form-label">Nome</label>
                <input name="name" type="text" class="form-control" placeholder="Digite aqui o nome da categoria">
            </div>
            <div class="mb-3">
                <label class="form-label" style="margin-top: 20px">Codigo</label>
                <input name="code" type="text" class="form-control" placeholder="por exemplo: desenvolvimento, mobile(não use letras maiúsculas ou acentos...">
            </div>
            <div class="form-group ">
                <div class="mb-3 form-check div-checkbox" style="margin-top: 20px">
                    <input type="checkbox" class="form-check-input"
                           name="active" placeholder="Mostra ou deixa de mostrar a categoria na listagem dos alunos, de formações, etc">
                    <label class="form-check-label" class="form-label">
                        <p class="active-category">Categoria Ativa?</p>
                    </label>
                    <p class="text-muted">
                        Mostre ou deixa de mostrar a categoria na listagem dos alunos, de formações, etc
                    </p>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label" style="margin-top: 20px">Ordem da categoria</label>
                <input name="ordination" type="text" class="form-control" placeholder="por exemplo: categoria de ordem 1 aparece antes da categoria 2">
            </div>
            <div class="form-group">
                <label style="margin-top: 20px">Guia de estudos</label>
                <textarea class="form-control" name="studyGuide" rows="6"
                          placeholder="Um texto apontando para formações para ajudar pessoas perdidas"></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label" style="margin-top: 20px">Caminho do ícone</label>
                <input name="icon" type="text" class="form-control" placeholder="por exemplo: /images/categorias/programação.svg">
            </div>
            <div class="mb-3">
                <label class="form-label" style="margin-top: 20px">cor</label>
                <input name="hexaColor" type="text" class="form-control" placeholder="por exemplo: #fcc14a">
            </div>
            <div class="mb-3">
                <label class="form-label" style="margin-top: 20px">Descrição</label>
                <input name="categoryDescription" type="text" class="form-control" placeholder="por exemplo:IOS, Android, PhoneGap e mais...">
            </div>
            <div style="margin-top: 25px;" class="mb-3">
                <button type="submit" class="btn btn-success" style="margin-bottom:30px">Enviar</button>
            </div>
        </form>
    </div>
</body>
</html>