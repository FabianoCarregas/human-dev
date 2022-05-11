<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:template-pageStart/>
<div class="row">
    <h1>Editar categoria</h1>
</div>
<form action="/admin/categories/${category.code}" method="post" class="form-post">
    <input type="hidden" name="id" value="${category.id}">
    <div class="row">
        <label class="form-label">Nome</label>
        <input name="name" type="text" class="form-control" value="${ category.name }">
        <form:errors path="categoryFormDto.name" cssClass="alert-danger"/>
    </div>
    <div class="row">
        <label class="form-label" >Código</label>
        <input name="code" type="text" class="form-control" value="${ category.code }">
        <form:errors path="categoryFormDto.code" cssClass="alert-danger"/>
    </div>
    <div class="form-group row">
            <input type="checkbox" class="form-check-input" name="active" ${category.active ? 'checked' : ''}>
            <label class="form-check-label" class="form-label">
               Categoria Ativa?
               <span class="text-muted check-helper">
                   Mostra ou deixa de mostrar a categoria na listagem dos alunos, de formações. etc
               </span>
            </label>
    </div>
    <div class="row">
        <label class="form-label">Ordem da categoria</label>
        <input name="ordination" type="text" class="form-control" value="${ category.ordination }">
        <form:errors path="categoryFormDto.ordination" cssClass="alert-danger"/>
    </div>
    <div class="row" >
        <label>Guia de estudos</label>
        <textarea class="form-control" name="studyGuide" rows="6" value="${ category.studyGuide }"></textarea>
    </div>
    <div class="row">
        <label class="form-label" >Caminho do ícone</label>
        <input name="icon" type="text" class="form-control" value="${ category.icon }">
    </div>
    <div class="row">
        <label class="form-label">Color</label>
        <input name="hexaColor" type="text" class="form-control" value="${ category.hexaColor }">
        <form:errors path="categoryFormDto.hexaColor" cssClass="alert-danger"/>
    </div>
    <div class="row">
        <label class="form-label">Descrição</label>
        <input name="categoryDescription" type="text" class="form-control" ${ category.categoryDescription }>
    </div>
    <div class="row" >
    <button type="submit" class="btn btn-success" >Salvar</button>
    </div>
</form>
<templates:template-pageEnd>
</templates:template-pageEnd>