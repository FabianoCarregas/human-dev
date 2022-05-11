<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:template-pageStart/>
<div class="row">
    <h1>Report</h1>
    <h3>Professores</h3>
</div>
<div class="row" >
    <table class="table table-bordered ">
    <thead>
    <tr>
        <th>Instrutor</th>
        <th>Quantidade de cursos</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${instructor.instructor}</td>
            <td>${instructor.coursesNumber}</td>
        </tr>
    </tbody>
    </table>
</div>
<div class="row">
    <h1>Report</h1>
    <h3>Categorias</h3>
</div>
<div class="row">
    <table class="table table-bordered ">
        <thead>
            <tr>
                <th>Categoria</th>
                <th>Quantidade de cursos</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ categories }" var="categoria">
                <tr>
                    <td>${categoria.name}</td>
                    <td>${categoria.coursesQuantity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <templates:template-pageEnd />