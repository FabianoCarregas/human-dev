<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:template-pageStart/>
<div class="row">
    <h1>Editar Curso</h1>
</div>
<form action="/admin/courses/${course.subcategory.category.code}/${course.subcategory.code}/${course.code}" method="post" class="form-post">
    <input type="hidden" name="id" value="${course.id}">
    <div class="row">
        <label class="form-label">Nome</label>
        <input name="name" type="text" class="form-control" value="${courseDto.name}" placeholder="Digite aqui o nome do curso">
        <form:errors path="courseFormDto.name" cssClass="alert-danger"/>
    </div>
    <div class="row">
        <label class="form-label" >Código</label>
        <input name="code" type="text" class="form-control" value="${courseDto.code}" placeholder="por exemplo: desenvolvimento, mobile(não use letras maiúsculas ou acentos...">
        <form:errors path="courseFormDto.code" cssClass="alert-danger"/>
    </div>
    <div class="row">
        <label class="form-label" >Tempo para finalização do Curso</label>
        <input name="courseTimeHours" type="number" class="form-control" value="${courseDto.courseTimeHours}" placeholder="o numero de horas para a finalização do curso...">
        <form:errors path="courseFormDto.courseTimeHours" cssClass="alert-danger"/>
    </div>
    <div class="form-group row ">
        <input type="checkbox" class="form-check-input" name="active">
        <label class="form-check-label" class="form-label">
            Curso Ativo?
            <span class="text-muted check-helper">Mostra ou deixa de mostrar o curso na listagem dos alunos, de formações. etc </span>
        </label>
    </div>
    <div class="row">
        <label class="form-label">Público alvo</label>
        <input name="targetAudience" type="text" class="form-control" value="${courseDto.targetAudience}" placeholder="business, java, marketing, frontend...">
    </div>
    <div class="row">
        <label class="form-label">Instrutor do curso</label>
        <input name="instructor" type="text" class="form-control" value="${courseDto.instructor}" placeholder="digite o nome do instrutor do curso aqui">
        <form:errors path="courseFormDto.instructor" cssClass="alert-danger"/>
    </div>
    <div class="row">
        <label class="form-label">Descrição</label>
        <input name="courseDescription" type="text" class="form-control" value="${courseDto.courseDescription}" placeholder="por exemplo:IOS, Android, PhoneGap e mais...">
    </div>
    <div class="row">
        <label>Habilidades desenvolvidas</label>
        <input class="form-control" name="developdSkills" value="${courseDto.developedSkills}" placeholder="Um texto apontando para formações para ajudar pessoas perdidas">
    </div>
    <div class="row">
        <label class="form-label">Subcategorias</label>
        <select class="form-control" name="subcategoryId" >
            <c:forEach items="${subcategories}" var="subcategoria">
                <option value="${subcategoria.id}" ${subcategoria.code == course.subcategory.code ? 'selected' : ''}>${subcategoria.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="row">
        <button type="submit" class="btn btn-success">Enviar</button>
    </div>
</form>
<templates:template-pageEnd>
</templates:template-pageEnd>